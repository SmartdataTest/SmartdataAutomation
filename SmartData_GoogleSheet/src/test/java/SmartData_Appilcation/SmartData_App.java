package SmartData_Appilcation;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.annotations.Test;


import Object_Repository.SmartData_Object;
import SmartData_GoogleSheet.TestGoogleSheet;
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
	 String htmlReportPath = "D:\\Selenium_Automation\\Smart_ticket\\SmartTicket_GoogleSheet\\test-output\\testReport.html";
	 TakeScreenshot TS = new TakeScreenshot();
	 String PageName =null;
	 String PageURL = null;
	 ArrayList tabs;
	@BeforeSuite
	public void Driver_Int()
	{
		 htmlReporter = new ExtentHtmlReporter(htmlReportPath);
	     extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
		 System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Automation\\Smart_ticket\\smartticketupgrade\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 driver.manage().window().maximize();
	}
	
	@Test(priority=0)
	public void SmartData_Whoweare()throws Exception{
		driver.get(url); 
		Thread.sleep(2000);
		driver.findElement(MainMenu).click();
		Thread.sleep(2000);
		driver.findElement(WhoWeAre).click();
		Thread.sleep(2000);
		PageURL =driver.getCurrentUrl();
        if (PageURL.contains(WhoWeAreURL)) {
        	PageName=driver.findElement(WhoWeAreEle).getText();
        	if(PageName.contains(WhoWeAreText)) {
        		driver.findElement(Lets_Talk).click();
        		Thread.sleep(2000);
        		PageURL =driver.getCurrentUrl();
		        if (PageURL.contains(contactus_url)) {
		        	PageName=driver.findElement(ContactusEle).getText();
		        	if(PageName.contains(Contact_Us)) {
		        		driver.navigate().back();
		        		Thread.sleep(2000);
		        	}
		        }
        		driver.findElement(JobOpening).click();
        		Thread.sleep(2000);
        	}
        }
	}
	@Test(priority=1)
	public void WhatWeDo()throws Exception{
		driver.findElement(MainMenu).click();
		Thread.sleep(2000);
		driver.findElement(Service).click();
		Thread.sleep(2000);
		driver.findElement(DigitalTransformation).click();
		Thread.sleep(2000);
		PageURL =driver.getCurrentUrl();
        if (PageURL.contains(DigitalTransformation_url)) {
        	PageName=driver.findElement(DigitalTransformationEle).getText();
        	if(PageName.contains(DigitalTransformation_Text)) {
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
        driver.findElement(MainMenu).click();
		Thread.sleep(2000);
		driver.findElement(Service).click();
		Thread.sleep(2000);
		driver.findElement(Enterprise).click();
		Thread.sleep(2000);
		 PageURL =driver.getCurrentUrl();
	        if (PageURL.contains(Enterprise_url)) {
	        	PageName=driver.findElement(EnterpriseEle).getText();
	        	if(PageName.contains(Enterprise_Text)) {
	        		System.out.println("Enterprise Application Development");
	        	}
	        }
	        driver.findElement(MainMenu).click();
			Thread.sleep(2000);
			driver.findElement(Service).click();
			Thread.sleep(2000);
			driver.findElement(SalesforceDev).click();
			Thread.sleep(2000);
			PageURL =driver.getCurrentUrl();
	        if (PageURL.contains(SalesforeDev_url)) {
	        	PageName=driver.findElement(SalesforceDevEle).getText();
	        	if(PageName.contains(SalesforceDev_Text)) {
	        		driver.findElement(SalesforceImplementation).click();
	        		Thread.sleep(2000);
	        		driver.navigate().back();
	        		Thread.sleep(2000);
	        	}
	        }
	        		driver.findElement(Salesforcecertification).click();
	        		Thread.sleep(2000);
	        		PageURL =driver.getCurrentUrl();
	    	        if (PageURL.contains(Salesforcecertification_url)) {
	    	        	PageName=driver.findElement(SalesforcecertificationEle).getText();
	    	        	if(PageName.contains(Salesforcecertification_Text)) {
	    	        		driver.navigate().back();
	    	        		Thread.sleep(2000);
	    	        	}
	    	        }
	        		driver.findElement(Salesforce_sales_Cloud).click();
	        		Thread.sleep(2000);
	        		PageURL =driver.getCurrentUrl();
	    	        if (PageURL.contains(SalesforceCloud_url)) {
	    	        	PageName=driver.findElement(SalesforceCloudEle).getText();
	    	        	if(PageName.contains(SalesforceCloud_Text)) {
	    	        		driver.navigate().back();
	    	        		Thread.sleep(2000);
	    	        	}
	    	        }
	    	        driver.findElement(Salesforce_ReadMore).click();
	    	        Thread.sleep(2000);
	    	        PageURL =driver.getCurrentUrl();
	    	        if (PageURL.contains(Salesforce_ReadMore_url)) {
	    	        	PageName=driver.findElement(Salesforce_ReadMoreEle).getText();
	    	        	if(PageName.contains(Salesforce_ReadMore_Text)) {
	    	        		System.out.println("SalesForce Development");
	    	        	}
	    	        }
	    	        driver.findElement(MainMenu).click();
	    			Thread.sleep(2000);
	    			driver.findElement(Service).click();
	    			Thread.sleep(2000);
	    	        driver.findElement(Staffing).click();
	    	        Thread.sleep(2000);
	    	        PageURL =driver.getCurrentUrl();
	    	        if (PageURL.contains(Staffing_url)) {
	    	        	PageName=driver.findElement(StaffingEle).getText();
	    	        	if(PageName.contains(Staffing_Text)) {
	    	        		driver.findElement(letstalk).click();
	    	        		Thread.sleep(2000);
	    	        		driver.navigate().back();
	    	        		Thread.sleep(2000);
	    	        		driver.findElement(Staffing_ReadMore).click();
	    	        		Thread.sleep(2000);
	    	        	}
	    	        }
	    	        driver.findElement(MainMenu).click();
	    			Thread.sleep(2000);
	    			driver.findElement(Service).click();
	    			Thread.sleep(2000);
	    			driver.findElement(AgileConsulting).click();
	    			Thread.sleep(2000);
	    			 PageURL =driver.getCurrentUrl();
		    	        if (PageURL.contains(AgileConsulting_url)) {
		    	        	PageName=driver.findElement(AgileConsultingEle).getText();
		    	        	if(PageName.contains(AgileConsulting_Text)) {
		    	        		System.out.println("Dev-Ops/Agile Consulting");
		    	        	}
		    	        }
		    	        driver.findElement(MainMenu).click();
		    			Thread.sleep(2000);
		    			driver.findElement(Service).click();
		    			Thread.sleep(2000);
		    			driver.findElement(DataScience).click();
		    			Thread.sleep(2000);
		    			 PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(DataScience_url)) {
			    	        	PageName=driver.findElement(DataScienceEle).getText();
			    	        	if(PageName.contains(DataScience_Text)) {
			    	        		System.out.println("Data Science ");
			    	        	}
			    	        }
			    	        driver.findElement(MainMenu).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Service).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Automation).click();
			    			Thread.sleep(2000);
			    			PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(Automation_url)) {
			    	        	PageName=driver.findElement(AutomationEle).getText();
			    	        	if(PageName.contains(Automation_Text)) {
			    	        		System.out.println("Automation ");
			    	        	}
			    	        }
			    	        driver.findElement(MainMenu).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Service).click();
			    			Thread.sleep(2000);
			    			driver.findElement(OffShore).click();
			    			Thread.sleep(2000);
			    			PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(OffShore_url)) {
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
			    	        driver.findElement(MainMenu).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Industries).click();
			    			Thread.sleep(2000);
			    			driver.findElement(HealthCare).click();
			    			Thread.sleep(2000);
			    			PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(HealthCare_url)) {
			    	        	PageName=driver.findElement(HealthCareEle).getText();
			    	        	if(PageName.contains(HelathCare_Text)) {
			    	        		driver.findElement(HealthCare_viewmore).click();
			    	        		Thread.sleep(2000);
			    	        		driver.navigate().back();
			    	        		Thread.sleep(2000);
			    	        	}
			    	        }
			    	        driver.findElement(MainMenu).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Industries).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Retail).click();
			    			Thread.sleep(2000);
			    			PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(Retail_url)) {
			    	        	PageName=driver.findElement(RetailEle).getText();
			    	        	if(PageName.contains(Retail_Text)) {
			    	        		System.out.println("Retail");
			    	        	}
			    	        }
			    	        driver.findElement(MainMenu).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Industries).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Manufacturing).click();
			    			Thread.sleep(2000);
			    			PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(Manufacturing_url)) {
			    	        	PageName=driver.findElement(ManufacturingEle).getText();
			    	        	if(PageName.contains(Manufacturing_Text)) {
			    	        		System.out.println("Manufacturing & Logistics");
			    	        	}
			    	        }
			    	        driver.findElement(MainMenu).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Industries).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Insurance).click();
			    			Thread.sleep(2000);
			    			PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(Insurance_url)) {
			    	        	PageName=driver.findElement(InsuranceEle).getText();
			    	        	if(PageName.contains(Insurance_Text)) {
			    	        		System.out.println("Insurance & Banking");
			    	        	}
			    	        }
			    	        driver.findElement(MainMenu).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Products).click();
			    			Thread.sleep(2000);
			    			driver.findElement(BeyondPod).click();
			    			Thread.sleep(2000);
			    			PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(BeyondPod_url)) {
			    	        	PageName=driver.findElement(BeyondPodEle).getText();
			    	        	if(PageName.contains(BeyondPod_Text)) {
			    	        		System.out.println("BeyondPod");
			    	        	}
			    	        }
			    	        driver.findElement(MainMenu).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Products).click();
			    			Thread.sleep(2000);
			    			driver.findElement(SBN).click();
			    			Thread.sleep(2000);
			    			PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(SBN_url)) {
			    	        	PageName=driver.findElement(SBNEle).getText();
			    	        	if(PageName.contains(SBN_Text)) {
			    	        		driver.findElement(SBN_ContactUs).click();
			    	        		Thread.sleep(2000);
			    	        	}
			    	        }
			    	        driver.findElement(MainMenu).click();
			    			Thread.sleep(2000);
			    			driver.findElement(Products).click();
			    			Thread.sleep(2000);
			    			driver.findElement(SmartTicket).click();
			    			Thread.sleep(2000);
			    			PageURL =driver.getCurrentUrl();
			    	        if (PageURL.contains(SmartTicket_url)) {
			    	        	PageName=driver.findElement(SmartTicketEle).getText();
			    	        	if(PageName.contains(SmartTicket_Text)) {
			    	        		System.out.println("SmartTicket");
			    	        	}
			    	        }
	}
	@Test(priority=2)
	public void SmartData_WorkHere()throws Exception{
		driver.findElement(MainMenu).click();
		Thread.sleep(2000);
		driver.findElement(WorkHere).click();
		Thread.sleep(2000);
		PageURL =driver.getCurrentUrl();
        if (PageURL.contains(WorkHere_url)) {
        	PageName=driver.findElement(WorkHereEle).getText();
        	if(PageName.contains(WorkHere_Text)) {
        		driver.findElement(WorkHere_ContactUs).click();
        		Thread.sleep(2000);
        		PageURL =driver.getCurrentUrl();
                if (PageURL.contains(WorkHere_ContactUs_url)) {
                	PageName=driver.findElement(WorkHere_ContactUsEle).getText();
                	if(PageName.contains(WorkHere_ContactUs_Text)) {
                		driver.navigate().back();
                		Thread.sleep(2000);
                	}
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
                if (PageURL.contains(ApplyNow_url)) {
                	PageName=driver.findElement(ApplyNowEle).getText();
                	if(PageName.contains(ApplyNow_Text)) {
                		driver.navigate().back();
                		Thread.sleep(2000);
                	}
                }
        	
        	}
        }
	}
	@Test(priority=3)
	public void smartData_lunchLearn()throws Exception{
		driver.findElement(MainMenu).click();
		Thread.sleep(2000);
		driver.findElement(Lunch_Learn).click();
		Thread.sleep(2000);
		PageURL =driver.getCurrentUrl();
        if (PageURL.contains(Lunch_Learn_url)) {
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
        
	}
	@Test(priority=4)
	public void smartData_AboutUs()throws Exception{
		driver.findElement(MainMenu).click();
		Thread.sleep(2000);
		driver.findElement(AboutUs).click();
		Thread.sleep(2000);
		PageURL =driver.getCurrentUrl();
        if (PageURL.contains(AboutUs_url)) {
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
	public void SmartData_ContactUs() throws  Exception {
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
				        if (PageURL.contains(contactus_url)) {
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
        	}
        }
		
	}
	@Test(priority=6)
	public void SmartData_Footer()throws Exception{
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
		driver.findElement(CNBS).click();
		Thread.sleep(2000);
		PageURL =driver.getCurrentUrl();
        if (PageURL.contains(CNBS_url)) {
        	PageName=driver.findElement(CNBSEle).getText();
        	if(PageName.contains(CNBS_Text)) {
        		driver.navigate().back();
        		Thread.sleep(2000);
        	}
        }
        driver.findElement(AWS).click();
        Thread.sleep(2000);
        PageURL =driver.getCurrentUrl();
        if (PageURL.contains(AWS_url)) {
        	PageName=driver.findElement(AWSEle).getText();
        	if(PageName.contains(AWS_Text)) {
        		driver.navigate().back();
        		Thread.sleep(2000);
        	}
        }
        driver.findElement(SalesForce_Company).click();
        Thread.sleep(2000);
        PageURL =driver.getCurrentUrl();
        if (PageURL.contains(SalesForce_Company_url)) {
        	PageName=driver.findElement(SaleForce_CompanyEle).getText();
        	if(PageName.contains(SalesForce_Company_Text)) {
        		driver.navigate().back();
        		Thread.sleep(2000);
        	}
        }
        driver.findElement(GoogleCloud).click();
        Thread.sleep(2000);
        PageURL =driver.getCurrentUrl();
        if (PageURL.contains(GoogleCloud_url)) {
        	PageName=driver.findElement(GoogleCloudEle).getText();
        	if(PageName.contains(GoogleCloud_Text)) {
        		driver.navigate().back();
        		Thread.sleep(2000);
        	}
        }
        driver.findElement(Ascend).click();
        Thread.sleep(2000);
        PageURL =driver.getCurrentUrl();
        if (PageURL.contains(Ascend_url)) {
        	PageName=driver.findElement(AscendEle).getText();
        	if(PageName.contains(Ascend_Text)) {
        		driver.navigate().back();
        		Thread.sleep(2000);
        	}
        }
        driver.findElement(costrategix).click();
        Thread.sleep(2000);
        PageURL =driver.getCurrentUrl();
        if (PageURL.contains(costrategix_url)) {
        	PageName=driver.findElement(costrategixEle).getText();
        	if(PageName.contains(costrategix_Text)) {
        		driver.navigate().back();
        		Thread.sleep(2000);
        	}
        }
        driver.findElement(F1Studio).click();
        Thread.sleep(2000);
        PageURL =driver.getCurrentUrl();
        if (PageURL.contains(F1Studio_url)) {
        	PageName=driver.findElement(F1StudioEle).getText();
        	if(PageName.contains(F1Studio_Text)) {
        		driver.navigate().back();
        		Thread.sleep(2000);
        	}
        }
        driver.findElement(keptraining).click();
        Thread.sleep(2000);
        PageURL =driver.getCurrentUrl();
        if (PageURL.contains(keptraining_url)) {
        	PageName=driver.findElement(keptrainingEle).getText();
        	if(PageName.contains(keptraining_Text)) {
        		driver.navigate().back();
        		Thread.sleep(2000);
        	}
        }
        driver.findElement(zendesk).click();
        Thread.sleep(2000);
        PageURL =driver.getCurrentUrl();
        if (PageURL.contains(zendesk_url)) {
        	PageName=driver.findElement(zendeskEle).getText();
        	if(PageName.contains(zendesk_Text)) {
        		driver.navigate().back();
        		Thread.sleep(2000);
        	}
        }
        driver.findElement(Blogs).click();
        Thread.sleep(2000);
        PageURL =driver.getCurrentUrl();
        if (PageURL.contains(Blogs_url)) {
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
	}
	
	@AfterSuite
	public void Driver_Close()
	{
		driver.quit();
	}
}
