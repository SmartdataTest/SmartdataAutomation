package SmartData_Appilcation;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.api.services.sheets.v4.model.ValueRange;

import org.testng.annotations.Test;


import Object_Repository.SmartData_Object;
import SmartData_GoogleSheet.SheetsExample;
import SmartData_GoogleSheet.TestGoogleSheet;
import SmartData_GoogleSheet.WriteValues;
import SmartData_Utilities.TakeScreenshot;

import org.testng.annotations.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class SmartData_App extends SmartData_Object
{
	WebDriver driver;
	ExtentReports extent;
	 ExtentTest logger;
	 ExtentHtmlReporter htmlReporter;
	 String htmlReportPath = "C:\\Users\\Vinod\\git\\SmartdataAutomation\\SmartData_GoogleSheet\\test-output\\testReport.html";
	 TakeScreenshot TS = new TakeScreenshot();
	 String PageName =null;
	 String PageURL = null;
	 ArrayList tabs;
	 SheetsExample updateValues;
	 
	 TakeScreenshot ScreenShot = new TakeScreenshot();
	 
	 List<List<Object>> URL = new ArrayList<>();
	 List<Object> CurrentURL = new ArrayList<>();
	
	 List<List<Object>> Pass = new ArrayList<>();
	 List<Object> PassStatus = new ArrayList<>();
	 
	 List<List<Object>> Fail = new ArrayList<>();
	 List<Object> FailStatus = new ArrayList<>();
	@BeforeSuite
	public void Driver_Int()
	{
		 htmlReporter = new ExtentHtmlReporter(htmlReportPath);
	     extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vinod\\Softwares\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		  // Pass Status Message
		 PassStatus.add("Pass");
		 Pass.add(PassStatus);
		 FailStatus.add("Fail");
		 Fail.add(FailStatus);
	}
	public void URL_Pass_Status_Update(String PageURL1,String URLRowValue,String URLCellValue,String StatuRow,String StatuCell) throws IOException, GeneralSecurityException
	{
		String URLUpdate = URLRowValue+":"+URLCellValue;
		String StatusUpdate=StatuRow+":"+StatuCell;
		CurrentURL.add(PageURL1);
	    URL.add(CurrentURL);
	    TestGoogleSheet.writeValuesIntoSpreadsheet("1WcD-vJXI2z4wZ9TQ1tHiT8cmmrKgD8v3cqKB-cPctRo", "SmartData!"+URLUpdate, URL);
	    TestGoogleSheet.writeValuesIntoSpreadsheet("1WcD-vJXI2z4wZ9TQ1tHiT8cmmrKgD8v3cqKB-cPctRo", "SmartData!"+StatusUpdate, Pass);
	    CurrentURL.remove(PageURL1);
	    URL.remove(CurrentURL);
	    
	}
	public void URL_Fail_Status_Update(String PageURL1,String URLRowValue,String URLCellValue,String StatuRow,String StatuCell) throws IOException, GeneralSecurityException
	{
		String URLUpdate = URLRowValue+":"+URLCellValue;
		String StatusUpdate=StatuRow+":"+StatuCell;
		CurrentURL.add(PageURL1);
	    URL.add(CurrentURL);
	    TestGoogleSheet.writeValuesIntoSpreadsheet("1WcD-vJXI2z4wZ9TQ1tHiT8cmmrKgD8v3cqKB-cPctRo", "SmartData!"+URLUpdate, URL);
	    TestGoogleSheet.writeValuesIntoSpreadsheet("1WcD-vJXI2z4wZ9TQ1tHiT8cmmrKgD8v3cqKB-cPctRo", "SmartData!"+StatusUpdate,Fail);
	    CurrentURL.remove(PageURL1);
	    URL.remove(CurrentURL);
	}
	@Test(priority=0)
	public void SmartData_Whoweare()throws Exception
	{
		TestGoogleSheet.ClearDataInSheet("1WcD-vJXI2z4wZ9TQ1tHiT8cmmrKgD8v3cqKB-cPctRo", "SmartData!B2:B");
		TestGoogleSheet.ClearDataInSheet("1WcD-vJXI2z4wZ9TQ1tHiT8cmmrKgD8v3cqKB-cPctRo", "SmartData!C2:B");
		
		driver.get(url); 
		Thread.sleep(2000);
		driver.findElement(MainMenu).click();
		Thread.sleep(2000);
		driver.findElement(WhoWeAre).click();
		Thread.sleep(2000);
		PageURL =driver.getCurrentUrl();
        if (PageURL.contains(WhoWeAreURL)) 
        {
        	URL_Pass_Status_Update(PageURL,"B2","B", "C2", "C");
        	
    		//TestGoogleSheet.RepeateCellRequest();
        	PageName=driver.findElement(WhoWeAreEle).getText();
        	if(PageName.contains(WhoWeAreText)) 
        	{
        		driver.findElement(Lets_Talk).click();
        		Thread.sleep(2000);
        		PageURL =driver.getCurrentUrl();
		        if (PageURL.contains(contactus_url)) 
		        {
		        	URL_Pass_Status_Update(PageURL,"B3","B", "C3", "C");
		        	PageName=driver.findElement(ContactusEle).getText();
		        	if(PageName.contains(Contact_Us)) 
		        	{
		        		
		        		driver.navigate().back();
		        		Thread.sleep(2000);
		        	}
		        }
		        else
		        {
		        	ScreenShot.getscreenshot(driver, "Contact US");
		        	URL_Fail_Status_Update(PageURL,"B3","C", "C3", "C");
		        }
        		driver.findElement(JobOpening).click();
        		Thread.sleep(2000);
        	}
        }
        else
        {
        	ScreenShot.getscreenshot(driver, "Who We Are URL");
        	URL_Fail_Status_Update(PageURL,"B2","C", "C2", "C");
        }
	}
	@Test(priority=1)
	public void WhatWeDo()throws Exception
	{	    
		driver.findElement(MainMenu).click();
		Thread.sleep(2000);
		driver.findElement(Service).click();
		Thread.sleep(2000);
		driver.findElement(DigitalTransformation).click();
		Thread.sleep(2000);
		PageURL =driver.getCurrentUrl();
        if (PageURL.contains(DigitalTransformation_url)) 
        {        	
        	URL_Pass_Status_Update(PageURL,"B4","B", "C4", "C");
        	PageName=driver.findElement(DigitalTransformationEle).getText();
        	if(PageName.contains(DigitalTransformation_Text)) 
        	{
        		driver.findElement(EnterpriseApp).click();
        		Thread.sleep(2000);
        		driver.navigate().back();
        		Thread.sleep(2000);
        		driver.findElement(CloudDev).click();
        		Thread.sleep(2000);
        		driver.navigate().back();
        		Thread.sleep(2000);
        		driver.findElement(MobileApp).click();
        		Thread.sleep(2000);
        		driver.navigate().back();
        		Thread.sleep(2000);
        		driver.findElement(Agile).click();
        		Thread.sleep(2000);
        	}
        }
        else
        {
        	ScreenShot.getscreenshot(driver, "Digital Transformation");
        	URL_Fail_Status_Update(PageURL,"B4","C", "C4", "C");
        }
        driver.findElement(MainMenu).click();
		Thread.sleep(2000);
		driver.findElement(Service).click();
		Thread.sleep(2000);
		driver.findElement(Enterprise).click();
		Thread.sleep(2000);
		 PageURL =driver.getCurrentUrl();
	        if (PageURL.contains(Enterprise_url))
	        {
	        	URL_Pass_Status_Update(PageURL,"B5","B", "C5", "C");
	        	PageName=driver.findElement(EnterpriseEle).getText();
	        	if(PageName.contains(Enterprise_Text)) 
	        	{
	        		System.out.println("Enterprise Application Development");
	        	}
	        }
	        else
	        {
	        	ScreenShot.getscreenshot(driver, "Enterprise");
	        	URL_Fail_Status_Update(PageURL,"B5","C", "C5", "C");
	        }
	        driver.findElement(MainMenu).click();
			Thread.sleep(2000);
			driver.findElement(Service).click();
			Thread.sleep(2000);
			driver.findElement(SalesforceDev).click();
			Thread.sleep(2000);
			PageURL =driver.getCurrentUrl();
	        if (PageURL.contains(SalesforeDev_url)) 
	        {
	        	URL_Pass_Status_Update(PageURL,"B6","B", "C6", "C");
	        	PageName=driver.findElement(SalesforceDevEle).getText();
	        	if(PageName.contains(SalesforceDev_Text)) {
	        		driver.findElement(SalesforceImplementation).click();
	        		Thread.sleep(2000);
	        		driver.navigate().back();
	        		Thread.sleep(2000);
	        	}
	        }
	        else
	        {
	        	ScreenShot.getscreenshot(driver, "Sales forec Devlopment");
	        	URL_Fail_Status_Update(PageURL,"B6","C", "C6", "C");
	        }
	        		driver.findElement(Salesforcecertification).click();
	        		Thread.sleep(2000);
	        		PageURL =driver.getCurrentUrl();
	    	        if (PageURL.contains(Salesforcecertification_url))
	    	        {
	    	        	URL_Pass_Status_Update(PageURL,"B7","B", "C7", "C");
	    	        	PageName=driver.findElement(SalesforcecertificationEle).getText();
	    	        	if(PageName.contains(Salesforcecertification_Text)) {
	    	        		driver.navigate().back();
	    	        		Thread.sleep(2000);
	    	        	}
	    	        	URL_Pass_Status_Update(PageURL,"B7","B", "C7", "C");
	    	        }
	    	        else
	    	        {
	    	        	ScreenShot.getscreenshot(driver, "Sales force Certification");
	    	        	URL_Fail_Status_Update(PageURL,"B7","C", "C7", "C");
	    	        }
	        		driver.findElement(Salesforce_sales_Cloud).click();
	        		Thread.sleep(2000);
	        		PageURL =driver.getCurrentUrl();
	    	        if (PageURL.contains(SalesforceCloud_url))
	    	        {
	    	        	URL_Pass_Status_Update(PageURL,"B8","B", "C8", "C");
	    	        	PageName=driver.findElement(SalesforceCloudEle).getText();
	    	        	if(PageName.contains(SalesforceCloud_Text)) {
	    	        		driver.navigate().back();
	    	        		Thread.sleep(2000);
	    	        	}
	    	        }
	    	        else
	    	        {
	    	        	ScreenShot.getscreenshot(driver, "Sales force Cloud");
	    	        	URL_Fail_Status_Update(PageURL,"B8","C", "C8", "C");
	    	        }
	    	        driver.findElement(Salesforce_ReadMore).click();
	    	        Thread.sleep(2000);
	    	        PageURL =driver.getCurrentUrl();
	    	        if (PageURL.contains(Salesforce_ReadMore_url))
	    	        {
	    	        	URL_Pass_Status_Update(PageURL,"B9","B", "C9", "C");
	    	        	PageName=driver.findElement(Salesforce_ReadMoreEle).getText();
	    	        	if(PageName.contains(Salesforce_ReadMore_Text)) {
	    	        		System.out.println("SalesForce Development");
	    	        	}
	    	        }
	    	        else
	    	        {
	    	        	ScreenShot.getscreenshot(driver, "Sales force ReadMore");
	    	        	URL_Fail_Status_Update(PageURL,"B9","C", "C9", "C");
	    	        }
	    	        driver.findElement(MainMenu).click();
	    			Thread.sleep(2000);
	    			driver.findElement(Service).click();
	    			Thread.sleep(2000);
	    	        driver.findElement(Staffing).click();
	    	        Thread.sleep(2000);
	    	        PageURL =driver.getCurrentUrl();
	    	        if (PageURL.contains(Staffing_url)) 
	    	        {
	    	        	
	    	        	URL_Pass_Status_Update(PageURL,"B10","B", "C10", "C");
	    	        	PageName=driver.findElement(StaffingEle).getText();
	    	        	if(PageName.contains(Staffing_Text)) 
	    	        	{
	    	        		driver.findElement(letstalk).click();
	    	        		Thread.sleep(2000);
	    	        		driver.navigate().back();
	    	        		Thread.sleep(2000);
	    	        		driver.findElement(Staffing_ReadMore).click();
	    	        		Thread.sleep(2000);
	    	        	}
	    	        }
	    	        else
	    	        {
	    	        	ScreenShot.getscreenshot(driver, "Staffing");
	    	        	URL_Fail_Status_Update(PageURL,"B10","C", "C10", "C");
	    	        }
	    	        driver.findElement(MainMenu).click();
	    			Thread.sleep(2000);
	    			driver.findElement(Service).click();
	    			Thread.sleep(2000);
	    			driver.findElement(AgileConsulting).click();
	    			Thread.sleep(2000);
	    			 PageURL =driver.getCurrentUrl();
		    	        if (PageURL.contains(AgileConsulting_url)) 
		    	        {
		    	        	URL_Pass_Status_Update(PageURL,"B11","B", "C11", "C");
		    	        	PageName=driver.findElement(AgileConsultingEle).getText();
		    	        	if(PageName.contains(AgileConsulting_Text)) {
		    	        		System.out.println("Dev-Ops/Agile Consulting");
		    	        	}
		    	        }
		    	        else
		    	        {
		    	        	ScreenShot.getscreenshot(driver, "Agile Consulting");
		    	        	URL_Fail_Status_Update(PageURL,"B11","C", "C11", "C");
		    	        }
		    	        driver.findElement(MainMenu).click();
		    			Thread.sleep(2000);
		    			driver.findElement(Service).click();
		    			Thread.sleep(2000);
		    			driver.findElement(DataScience).click();
		    			Thread.sleep(2000);
		    			 PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(DataScience_url)) 
			    	        {
			    	        	URL_Pass_Status_Update(PageURL,"B12","B", "C12", "C");
			    	        	PageName=driver.findElement(DataScienceEle).getText();
			    	        	if(PageName.contains(DataScience_Text)) {
			    	        		System.out.println("Data Science ");
			    	        	}
			    	        }
			    	        else
			    	        {
			    	        	ScreenShot.getscreenshot(driver, "Data Science");
			    	        	URL_Fail_Status_Update(PageURL,"B12","C", "C12", "C");
			    	        }
			    	        driver.findElement(MainMenu).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Service).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Automation).click();
			    			Thread.sleep(2000);
			    			PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(Automation_url)) 
			    	        {
			    	        	URL_Pass_Status_Update(PageURL,"B13","B", "C13", "C");	
			    	        	PageName=driver.findElement(AutomationEle).getText();
			    	        	if(PageName.contains(Automation_Text)) {
			    	        		System.out.println("Automation ");
			    	        	}
			    	        }
			    	        else
			    	        {
			    	        	ScreenShot.getscreenshot(driver, "Automation");
			    	        	URL_Fail_Status_Update(PageURL,"B13","C", "C13", "C");
			    	        }
			    	        
			    	        driver.findElement(MainMenu).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Service).click();
			    			Thread.sleep(2000);
			    			driver.findElement(OffShore).click();
			    			Thread.sleep(2000);
			    			PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(OffShore_url)) 
			    	        {
			    	        	URL_Pass_Status_Update(PageURL,"B14","B", "C14", "C");
			    	        	PageName=driver.findElement(OffShoreEle).getText();
			    	        	if(PageName.contains(OffShore_Text)) {
			    	        		driver.findElement(talk_with_an_expert).click();
			    	        		Thread.sleep(2000);
			    	        		WebElement offShore_readmore = driver.findElement(OffShore_ReadMore);
			    	        		JavascriptExecutor jse = (JavascriptExecutor) driver;
									jse.executeScript("arguments[0].click();", offShore_readmore);
			    	        		Thread.sleep(2000);
			    	        		driver.navigate().back();
			    	        		Thread.sleep(2000);
			    	        		WebElement Hybrid_readmore = driver.findElement(Hybrid_ReadMore);
			    	        		JavascriptExecutor js = (JavascriptExecutor) driver;
									js.executeScript("arguments[0].click();", Hybrid_readmore );
			    	        		Thread.sleep(2000);
			    	        	}
			    	        }
			    	        else
			    	        {
			    	        	ScreenShot.getscreenshot(driver, "OffShore");
			    	        	URL_Fail_Status_Update(PageURL,"B14","C", "C14", "C");
			    	        }
			    	        
			    	        driver.findElement(MainMenu).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Industries).click();
			    			Thread.sleep(2000);
			    			driver.findElement(HealthCare).click();
			    			Thread.sleep(2000);
			    			PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(HealthCare_url))
			    	        {
			    	        	URL_Pass_Status_Update(PageURL,"B15","B", "C15", "C");
			    	        	PageName=driver.findElement(HealthCareEle).getText();
			    	        	if(PageName.contains(HelathCare_Text)) {
			    	        		driver.findElement(HealthCare_viewmore).click();
			    	        		Thread.sleep(2000);
			    	        		driver.navigate().back();
			    	        		Thread.sleep(2000);
			    	        	}
			    	        }
			    	        else
			    	        {
			    	        	ScreenShot.getscreenshot(driver, "HealthCare");
			    	        	URL_Fail_Status_Update(PageURL,"B15","C", "C15", "C");
			    	        }
			    	        
			    	        driver.findElement(MainMenu).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Industries).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Retail).click();
			    			Thread.sleep(2000);
			    			PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(Retail_url))
			    	        {
			    	        	URL_Pass_Status_Update(PageURL,"B16","B", "C16", "C");
			    	        	PageName=driver.findElement(RetailEle).getText();
			    	        	if(PageName.contains(Retail_Text)) {
			    	        		System.out.println("Retail");
			    	        	}
			    	        }
			    	        else
			    	        {
			    	        	ScreenShot.getscreenshot(driver, "Retail");
			    	        	URL_Fail_Status_Update(PageURL,"B16","C", "C16", "C");
			    	        }
			    	        
			    	        driver.findElement(MainMenu).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Industries).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Manufacturing).click();
			    			Thread.sleep(2000);
			    			PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(Manufacturing_url)) 
			    	        {
			    	        	URL_Pass_Status_Update(PageURL,"B17","B", "C17", "C");
			    	        	PageName=driver.findElement(ManufacturingEle).getText();
			    	        	if(PageName.contains(Manufacturing_Text)) {
			    	        		System.out.println("Manufacturing & Logistics");
			    	        	}
			    	        }
			    	        else
			    	        {
			    	        	ScreenShot.getscreenshot(driver, "Manufacturing");
			    	        	URL_Fail_Status_Update(PageURL,"B17","C", "C17", "C");
			    	        }
			    	        driver.findElement(MainMenu).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Industries).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Insurance).click();
			    			Thread.sleep(2000);
			    			PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(Insurance_url)) 
			    	        {
			    	        	URL_Pass_Status_Update(PageURL,"B18","B", "C18", "C");
			    	        	PageName=driver.findElement(InsuranceEle).getText();
			    	        	if(PageName.contains(Insurance_Text)) {
			    	        		System.out.println("Insurance & Banking");
			    	        	}
			    	        }
			    	        else
			    	        {
			    	        	ScreenShot.getscreenshot(driver, "Insurance");
			    	        	URL_Fail_Status_Update(PageURL,"B18","C", "C18", "C");
			    	        }
			    	        driver.findElement(MainMenu).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Products).click();
			    			Thread.sleep(2000);
			    			driver.findElement(BeyondPod).click();
			    			Thread.sleep(2000);
			    			PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(BeyondPod_url)) 
			    	        {
			    	        	URL_Pass_Status_Update(PageURL,"B19","B", "C19", "C");
			    	        	PageName=driver.findElement(BeyondPodEle).getText();
			    	        	if(PageName.contains(BeyondPod_Text)) {
			    	        		System.out.println("BeyondPod");
			    	        	}
			    	        }
			    	        else
			    	        {
			    	        	ScreenShot.getscreenshot(driver, "BeyondPod");
			    	        	URL_Fail_Status_Update(PageURL,"B19","C", "C19", "C");
			    	        }
			    	        driver.findElement(MainMenu).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Products).click();
			    			Thread.sleep(2000);
			    			driver.findElement(SBN).click();
			    			Thread.sleep(2000);
			    			PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(SBN_url)) 
			    	        {
			    	        	URL_Pass_Status_Update(PageURL,"B20","B", "C20", "C");
			    	        	PageName=driver.findElement(SBNEle).getText();
			    	        	if(PageName.contains(SBN_Text)) {
			    	        		driver.findElement(SBN_ContactUs).click();
			    	        		Thread.sleep(2000);
			    	        	}
			    	        }
			    	        else
			    	        {
			    	        	ScreenShot.getscreenshot(driver, "SBN");
			    	        	URL_Fail_Status_Update(PageURL,"B20","C", "C20", "C");
			    	        }
			    	        driver.findElement(MainMenu).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Products).click();
			    			Thread.sleep(2000);
			    			driver.findElement(SmartTicket).click();
			    			Thread.sleep(2000);
			    			PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(SmartTicket_url)) 
			    	        {
			    	        	URL_Pass_Status_Update(PageURL,"B21","B", "C21", "C");
			    	        	PageName=driver.findElement(SmartTicketEle).getText();
			    	        	if(PageName.contains(SmartTicket_Text)) {
			    	        		System.out.println("SmartTicket");
			    	        	}
			    	        }
			    	        else
			    	        {
			    	        	ScreenShot.getscreenshot(driver, "SmartTicket");
			    	        	URL_Fail_Status_Update(PageURL,"B21","C", "C21", "C");
			    	        }
	}
	@Test(priority=2)
	public void SmartData_WorkHere()throws Exception{
		driver.findElement(MainMenu).click();
		Thread.sleep(2000);
		driver.findElement(WorkHere).click();
		Thread.sleep(2000);
		PageURL =driver.getCurrentUrl();
        if (PageURL.contains(WorkHere_url)) 
        {
        	URL_Pass_Status_Update(PageURL,"B37","B", "C37", "C");
        	PageName=driver.findElement(WorkHereEle).getText();
        	if(PageName.contains(WorkHere_Text)) {
        		driver.findElement(WorkHere_ContactUs).click();
        		Thread.sleep(2000);
        		PageURL =driver.getCurrentUrl();
                if (PageURL.contains(WorkHere_ContactUs_url)) 
                {
                	URL_Pass_Status_Update(PageURL,"B22","B", "C22", "C");
                	PageName=driver.findElement(WorkHere_ContactUsEle).getText();
                	if(PageName.contains(WorkHere_ContactUs_Text)) {
                		driver.navigate().back();
                		Thread.sleep(2000);
                	}
                }
                else
    	        {
                	ScreenShot.getscreenshot(driver, "Work Here Contact Us");
    	        	URL_Fail_Status_Update(PageURL,"B22","C", "C22", "C");
    	        }
        		driver.findElement(ApplyNow).click();
        		Thread.sleep(2000);
        		driver.navigate().back();
        		Thread.sleep(2000);
        		driver.findElement(ApplyNow1).click();
        		Thread.sleep(2000);
        		driver.navigate().back();
        		Thread.sleep(2000);
        		driver.findElement(Applynow2).click();
        		Thread.sleep(2000);
        		PageURL =driver.getCurrentUrl();
                if (PageURL.contains(ApplyNow_url)) 
                {
                	URL_Pass_Status_Update(PageURL,"B23","B", "C23", "C");
                	PageName=driver.findElement(ApplyNowEle).getText();
                	if(PageName.contains(ApplyNow_Text)) {
                		driver.navigate().back();
                		Thread.sleep(2000);
                	}
                }
                else
    	        {
                	ScreenShot.getscreenshot(driver, "ApplyNow");
    	        	URL_Fail_Status_Update(PageURL,"B23","C", "C23", "C");
    	        }
        	
        	}
        }
        else
        {
        	ScreenShot.getscreenshot(driver, "Work Hear");
        	URL_Fail_Status_Update(PageURL,"B37","C", "C37", "C");
        }
	}
	@Test(priority=3)
	public void SmartData_lunchLearn()throws Exception{
		driver.findElement(MainMenu).click();
		Thread.sleep(2000);
		driver.findElement(Lunch_Learn).click();
		Thread.sleep(2000);
		PageURL =driver.getCurrentUrl();
        if (PageURL.contains(Lunch_Learn_url)) 
        {
        	URL_Pass_Status_Update(PageURL,"B24","B", "C24", "C");
        	PageName=driver.findElement(Lunch_LearnEle).getText();
        	if(PageName.contains(Lunch_Learn_Text)) {
        		driver.findElement(Event1).click();
        		Thread.sleep(2000);
        		driver.navigate().back();
        		Thread.sleep(2000);
        		driver.findElement(Event2).click();
        		Thread.sleep(2000);
        		driver.navigate().back();
        		Thread.sleep(2000);
        		List<List<Object>> values =TestGoogleSheet.LunchLearn();
      		  if (values == null || values.isEmpty()) {
      				System.out.println("No data found.");
      			} else {
      				for (List row : values) {
      					driver.findElement(Name).sendKeys(row.get(0).toString());
      					Thread.sleep(2000);
      					driver.findElement(Lunch_Email).sendKeys(row.get(1).toString());
      					Thread.sleep(2000);
      					driver.findElement(Lunch_Message).sendKeys(row.get(2).toString());
      					Thread.sleep(2000);
      					}
      				}
      				
      				JavascriptExecutor js = (JavascriptExecutor) driver;
  			        js.executeScript("window.scrollBy(0,2000)");
  			        driver.findElement(OldEntries).click();
  			        Thread.sleep(2000);
  			        WebElement Nextentries = driver.findElement(NextEntries);
  			      JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("arguments[0].click();", Nextentries);
  			        Thread.sleep(2000);
        	}
        }
        else
        {
        	ScreenShot.getscreenshot(driver, "Lunch_Learn");
        	URL_Fail_Status_Update(PageURL,"B24","C", "C24", "C");
        }
        
	}
	@Test(priority=4)
	public void smartData_AboutUs()throws Exception{
		driver.findElement(MainMenu).click();
		Thread.sleep(2000);
		driver.findElement(AboutUs).click();
		Thread.sleep(2000);
		PageURL =driver.getCurrentUrl();
        if (PageURL.contains(AboutUs_url)) 
        {
        	URL_Pass_Status_Update(PageURL,"B25","B", "C25", "C");
        	PageName=driver.findElement(AboutUsEle).getText();
        	if(PageName.contains(AboutUs_Text)) {
        		driver.findElement(Ravi_Manchala).click();
        		Thread.sleep(2000);
        		tabs = new ArrayList (driver.getWindowHandles());
        		driver.switchTo().window((String) tabs.get(1));
        		driver.close();
        		driver.switchTo().window((String) tabs.get(0));
        		Thread.sleep(2000);
        		driver.findElement(Michael_martin).click();
        		Thread.sleep(2000);
        		tabs = new ArrayList (driver.getWindowHandles());
        		driver.switchTo().window((String) tabs.get(1));
        		driver.close();
        		driver.switchTo().window((String) tabs.get(0));
        		Thread.sleep(2000);
        		driver.findElement(Don_Kennedy).click();
        		Thread.sleep(2000);
        		tabs = new ArrayList (driver.getWindowHandles());
        		driver.switchTo().window((String) tabs.get(1));
        		driver.close();
        		driver.switchTo().window((String) tabs.get(0));
        		Thread.sleep(2000);
        		driver.findElement(Taylor_Britain).click();
        		Thread.sleep(2000);
        		tabs = new ArrayList (driver.getWindowHandles());
        		driver.switchTo().window((String) tabs.get(1));
        		driver.close();
        		driver.switchTo().window((String) tabs.get(0));
        		Thread.sleep(2000);
        		driver.findElement(Jay_Brown).click();
        		Thread.sleep(2000);
        		tabs = new ArrayList (driver.getWindowHandles());
        		driver.switchTo().window((String) tabs.get(1));
        		driver.close();
        		driver.switchTo().window((String) tabs.get(0));
        		Thread.sleep(2000);
        		driver.findElement(Jon_Greene).click();
        		Thread.sleep(2000);
        		tabs = new ArrayList (driver.getWindowHandles());
        		driver.switchTo().window((String) tabs.get(1));
        		driver.close();
        		driver.switchTo().window((String) tabs.get(0));
        		Thread.sleep(2000);
        		driver.findElement(Katie_indoe).click();
        		Thread.sleep(2000);
        		tabs = new ArrayList (driver.getWindowHandles());
        		driver.switchTo().window((String) tabs.get(1));
        		driver.close();
        		driver.switchTo().window((String) tabs.get(0));
        		Thread.sleep(2000);
        		driver.findElement(Srikant_Sunkara).click();
        		Thread.sleep(2000);
        		tabs = new ArrayList (driver.getWindowHandles());
        		driver.switchTo().window((String) tabs.get(1));
        		driver.close();
        		driver.switchTo().window((String) tabs.get(0));
        		Thread.sleep(2000);
        		driver.findElement(Rajesh_chintakunta).click();
        		Thread.sleep(2000);
        		tabs = new ArrayList (driver.getWindowHandles());
        		driver.switchTo().window((String) tabs.get(1));
        		driver.close();
        		driver.switchTo().window((String) tabs.get(0));
        		Thread.sleep(2000);
        		
        	}
        }
        else
        {
        	ScreenShot.getscreenshot(driver, "AboutUs");
        	URL_Fail_Status_Update(PageURL,"B25","C", "C25", "C");
        }
       
        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,1000)");
	        driver.switchTo().parentFrame();
	        driver.findElement(Cincinnati).click();
	        Thread.sleep(2000);
	        driver.findElement(Louisville).click();
	        Thread.sleep(2000);
	        driver.findElement(Hyderabad).click();
	        Thread.sleep(2000);
	        List<List<Object>> values =TestGoogleSheet.GetContactUs();
			  if (values == null || values.isEmpty()) {
					System.out.println("No data found.");
				} else {
					for (List row : values) {
						 driver.switchTo().frame(FrameID);
						 Thread.sleep(2000);
						 driver.findElement(AboutUs_Email).sendKeys(row.get(0).toString());
						 Thread.sleep(2000);
						 driver.findElement(FirstName).sendKeys(row.get(1).toString());
						 Thread.sleep(2000);
						 driver.findElement(LastName).sendKeys(row.get(2).toString());
						 Thread.sleep(2000);
						 driver.findElement(Message).sendKeys(row.get(3).toString());
						 Thread.sleep(2000);
					}
				}
	}
	@Test(priority=5)
	public void SmartData_ContactUs() throws  Exception 
	{
		driver.navigate().refresh();
		driver.findElement(MainMenu).click();
		Thread.sleep(2000);
		driver.findElement(ContactUs).click();
		Thread.sleep(2000);
		
		List<List<Object>> values =TestGoogleSheet.GetContactUs();
		  if (values == null || values.isEmpty()) {
				System.out.println("No data found.");
			} else {
				for (List row : values) {
					 PageURL =driver.getCurrentUrl();
				        if (PageURL.contains(contactus_url)) 
				        {
				        	URL_Pass_Status_Update(PageURL,"B26","B", "C26", "C");
				        	PageName=driver.findElement(ContactusEle).getText();
				        	if(PageName.contains(Contact_Us)) {
				        		driver.switchTo().frame(FrameID);		
      					driver.findElement(Email).sendKeys(row.get(0).toString());
      					Thread.sleep(2000);
      					driver.findElement(FirstName).sendKeys(row.get(1).toString());
      					Thread.sleep(2000);
      					driver.findElement(LastName).sendKeys(row.get(2).toString());
      					Thread.sleep(2000);
      					driver.findElement(Message).sendKeys(row.get(3).toString());
      					Thread.sleep(2000);
      					JavascriptExecutor js = (JavascriptExecutor) driver;
      			        js.executeScript("window.scrollBy(0,1000)");
      			        driver.switchTo().parentFrame();
      			        driver.findElement(Cincinnati).click();
      			        Thread.sleep(2000);
      			        driver.findElement(Louisville).click();
      			        Thread.sleep(2000);
      			        driver.findElement(Hyderabad).click();
      			        Thread.sleep(2000);
      				}
      			}
				        else
				        {
				        	ScreenShot.getscreenshot(driver, "Contact Us");
				        	URL_Fail_Status_Update(PageURL,"B26","B", "C26", "C");
				        }
        	}
        }
		
	}
	@Test(priority=6)
	public void SmartData_Footer()throws Exception
	{
		driver.findElement(Healthcare).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(SalesForce).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(staffing).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(AgilConsulting).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(Whoweare).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(workhere).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(LunchLearn).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(Contact).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(partner).click();
		Thread.sleep(2000);
		Page_Scroll_Down("250");
		driver.findElement(CNBS).click();
		Thread.sleep(2000);
		PageURL =driver.getCurrentUrl();
        if (PageURL.contains(CNBS_url)) 
        {
        	URL_Pass_Status_Update(PageURL,"B27","B", "C27", "C");
        	PageName=driver.findElement(CNBSEle).getText();
        	if(PageName.contains(CNBS_Text)) {
        		driver.navigate().back();
        		Thread.sleep(2000);
        	}
        }
        else
        {
        	ScreenShot.getscreenshot(driver, "CNBS");
        	URL_Fail_Status_Update(PageURL,"B27","C", "C27", "C");
        }
        try 
        {
        	Page_Scroll_Down("250");
        	 driver.findElement(AWS).click();
		}
        catch (Exception e)
        {
        	System.out.println(e.getLocalizedMessage());
        	System.out.println(e.getMessage());
        }
     
        Thread.sleep(2000);
        PageURL =driver.getCurrentUrl();
        if (PageURL.contains(AWS_url)) 
        {
        	
        	URL_Pass_Status_Update(PageURL,"B28","B", "C28", "C");
        	PageName=driver.findElement(AWSEle).getText();
        	if(PageName.contains(AWS_Text)) {
        		driver.navigate().back();
        		Thread.sleep(2000);
        	}
        }
        else
        {
        	ScreenShot.getscreenshot(driver, "AWS");
        	URL_Fail_Status_Update(PageURL,"B28","C", "C28", "C");
        }
        Page_Scroll_Down("250");
        driver.findElement(SalesForce_Company).click();
        Thread.sleep(2000);
        PageURL =driver.getCurrentUrl();
        if (PageURL.contains(SalesForce_Company_url)) 
        {
        	URL_Pass_Status_Update(PageURL,"B29","B", "C29", "C");
        	PageName=driver.findElement(SaleForce_CompanyEle).getText();
        	if(PageName.contains(SalesForce_Company_Text)) {
        		driver.navigate().back();
        		Thread.sleep(2000);
        	}
        }
        else
        {
        	ScreenShot.getscreenshot(driver, "Sales Force Company");
        	URL_Fail_Status_Update(PageURL,"B29","C", "C29", "C");
        }
        try
        {
        	Page_Scroll_Down("100");
        	 driver.findElement(GoogleCloud).click();
		}
        catch (Exception e) 
        {
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getMessage());
			
		}
       
        Thread.sleep(2000);
        PageURL =driver.getCurrentUrl();
        if (PageURL.contains(GoogleCloud_url)) 
        {
        	URL_Pass_Status_Update(PageURL,"B30","B", "C30", "C");
        	PageName=driver.findElement(GoogleCloudEle).getText();
        	if(PageName.contains(GoogleCloud_Text)) {
        		driver.navigate().back();
        		Thread.sleep(2000);
        	}
        }
        else
        {
        	ScreenShot.getscreenshot(driver, "Google Cloud");
        	URL_Fail_Status_Update(PageURL,"B30","C", "C30", "C");
        }
        Page_Scroll_Down("100");
        driver.findElement(Ascend).click();
        Thread.sleep(2000);
        PageURL =driver.getCurrentUrl();
        if (PageURL.contains(Ascend_url)) 
        {
        	URL_Pass_Status_Update(PageURL,"B31","B", "C31", "C");
        	PageName=driver.findElement(AscendEle).getText();
        	if(PageName.contains(Ascend_Text)) {
        		driver.navigate().back();
        		Thread.sleep(2000);
        	}
        }
        else
        {
        	ScreenShot.getscreenshot(driver, "Ascend");
        	URL_Fail_Status_Update(PageURL,"B31","C", "C31", "C");
        }
        Page_Scroll_Down("100");    
        driver.findElement(costrategix).click();
        Thread.sleep(2000);
        PageURL =driver.getCurrentUrl();
        if (PageURL.contains(costrategix_url)) 
        {
        	URL_Pass_Status_Update(PageURL,"B32","B", "C32", "C");
        	PageName=driver.findElement(costrategixEle).getText();
        	if(PageName.contains(costrategix_Text)) {
        		driver.navigate().back();
        		Thread.sleep(2000);
        	}
        }
        else
        {
        	ScreenShot.getscreenshot(driver, "Costrategix");
        	URL_Fail_Status_Update(PageURL,"B32","C", "C32", "C");
        }
        Page_Scroll_Down("100");
        driver.findElement(F1Studio).click();
        Thread.sleep(2000);
        PageURL =driver.getCurrentUrl();
        if (PageURL.contains(F1Studio_url)) 
        {
        	URL_Pass_Status_Update(PageURL,"B33","B", "C33", "C");
        	PageName=driver.findElement(F1StudioEle).getText();
        	if(PageName.contains(F1Studio_Text)) 
        	{
        		driver.navigate().back();
        		Thread.sleep(2000);
        	}
        }
        else
        {
        	ScreenShot.getscreenshot(driver, "F1 Studio");
        	URL_Fail_Status_Update(PageURL,"B33","C", "C33", "C");
        }
        Page_Scroll_Down("100");
        driver.findElement(keptraining).click();
        Thread.sleep(2000);
        PageURL =driver.getCurrentUrl();
        if (PageURL.contains(keptraining_url)) 
        {
        	URL_Pass_Status_Update(PageURL,"B34","C", "C34", "C");
        	PageName=driver.findElement(keptrainingEle).getText();
        	if(PageName.contains(keptraining_Text)) 
        	{
        		driver.navigate().back();
        		Thread.sleep(2000);
        	}
        }
        else
        {
        	ScreenShot.getscreenshot(driver, "Keptraining");
        	URL_Fail_Status_Update(PageURL,"B34","C", "C34", "C");
        }
        try 
        {
        	Page_Scroll_Down("100");
        	 driver.findElement(zendesk).click();
		} 
        catch (Exception e)
        {
        	System.out.println(e.getLocalizedMessage());
        	System.out.println(e.getMessage());
		}
       
        Thread.sleep(2000);
        PageURL =driver.getCurrentUrl();
        if (PageURL.contains(zendesk_url)) 
        {
        	URL_Pass_Status_Update(PageURL,"B35","B", "C35", "C");
        	PageName=driver.findElement(zendeskEle).getText();
        	if(PageName.contains(zendesk_Text)) {
        		driver.navigate().back();
        		Thread.sleep(5000);
        	}
        }
        else
        {
        	ScreenShot.getscreenshot(driver, "Zendesk");
        	URL_Fail_Status_Update(PageURL,"B35","C", "C35", "C");
        }
        Page_Scroll_Down("100");
        driver.findElement(Blogs).click();
        Thread.sleep(2000);
        PageURL =driver.getCurrentUrl();
        if (PageURL.contains(Blogs_url)) 
        {
        	URL_Pass_Status_Update(PageURL,"B36","B", "C36", "C");
        	PageName=driver.findElement(BlogsEle).getText();
        	if(PageName.contains(Blogs_Text)) {
        		
        		driver.findElement(Blog1).click();
        		Thread.sleep(2000);
        		driver.navigate().back();
        		Thread.sleep(2000);
        		driver.findElement(Blog2).click();
        		Thread.sleep(2000);
        		driver.navigate().back();
        		Thread.sleep(2000);
        		driver.findElement(Blog3).click();
        		Thread.sleep(2000);
        		driver.navigate().back();
        		Thread.sleep(2000);
        		driver.findElement(Blog4).click();
        		Thread.sleep(2000);
        		driver.navigate().back();
        		Thread.sleep(2000);
        		driver.findElement(Blog5).click();
        		Thread.sleep(2000);
        		driver.navigate().back();
        		Thread.sleep(2000);
        		driver.findElement(Blog6).click();
        		Thread.sleep(2000);
        		driver.navigate().back();
        		Thread.sleep(2000);
        		JavascriptExecutor js1 = (JavascriptExecutor) driver;
    	        js1.executeScript("window.scrollBy(0,1000)");
        		WebElement OlderEntries = driver.findElement(Older_Entries);
        		JavascriptExecutor js2 = (JavascriptExecutor) driver;
				js2.executeScript("arguments[0].click();", OlderEntries);
				WebElement NextEntries = driver.findElement(Next_Entries);
				JavascriptExecutor js3 = (JavascriptExecutor) driver;
				js3.executeScript("arguments[0].click();", NextEntries);
        	}
        }
        else
        {
        	ScreenShot.getscreenshot(driver, "Blogs");	
        	URL_Fail_Status_Update(PageURL,"B36","C", "C36", "C");
        }
	}
	public void Page_Scroll_Down(String Value)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+Value+")");
	}
	
	@AfterSuite
	public void Driver_Close()
	{
		driver.quit();
	}
}
