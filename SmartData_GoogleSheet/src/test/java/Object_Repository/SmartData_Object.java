package Object_Repository;

import org.openqa.selenium.By;

public class SmartData_Object 
{
	public String url = "https://www.smartdata.net/";
	public By MainMenu = By.xpath("//div[@id='free-sticky-wrapper']/div/div/div/div[3]/div/a/span");
	public By WhoWeAre = By.linkText("WHO WE ARE");
	public By JobOpening = By.xpath(".//*[@class='et_pb_button et_pb_custom_button_icon et_pb_button_1 et_pb_bg_layout_light' and text()='Job Openings']");
	public String WhoWeAreURL = "https://www.smartdata.net/who-we-are/";
	public String WhoWeAreText = "Who We Are";
	public By WhoWeAreEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	public By Lets_Talk = By.xpath("(//a[contains(@href, 'https://www.smartdata.net/contact-us/')])[7]");
	
	public By Service = By.xpath("//ul[@id='menu-primary-menu-4']/li[2]/ul/li/a/span[2]");
	public By DigitalTransformation = By.xpath("(//a[contains(text(),'Digital Transformation')])[3]");
	public String DigitalTransformation_url = "https://www.smartdata.net/digital-transformation/";
	public String DigitalTransformation_Text = "Digital Transformation";
	public By DigitalTransformationEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	public By EnterpriseApp = By.xpath("//span[contains(.,'Enterprise Application Development')]");
	public By CloudDev = By.xpath("//span[contains(.,'Cloud Development')]");
	public By MobileApp = By.xpath("//span[contains(.,'Mobile App Development')]");
	public By Agile = By.xpath("//span[contains(.,'Dev-Ops/Agile Consulting')]");
	
	public By Enterprise = By.xpath("(//a[contains(text(),'Enterprise Application Development')])[3]");
	public String Enterprise_url = "https://www.smartdata.net/enterprise-application-development/";
	public String Enterprise_Text = "Enterprise Application Development";
	public By EnterpriseEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	
	public By CloudDevlopment = By.xpath("(//a[contains(text(),'Cloud Development')])[3]");
	public String CloudDevelopment_url = "https://www.smartdata.net/cloud-platform-development/";
	public String Clouddevelopment_Text = "Cloud Development";
	public By CloudDevelopmentEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	
	public By MobileApplication = By.xpath("(//a[contains(text(),'Mobile App Development')])[3]");
	public String MobileApplication_url ="https://www.smartdata.net/mobile-app-development/";
	public String MobileApplication_Text = "Mobile App Development";
	public By MobileApplicationEle =  By.xpath(".//*[@class='et_pb_text_inner']/h1");
	
	public By SalesforceDev = By.xpath("(//a[contains(text(),'Salesforce Development')])[3]");
	public String  SalesforeDev_url ="https://www.smartdata.net/salesforce-development/";
	public String SalesforceDev_Text = "Salesforce Development Company";
	public By SalesforceDevEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	public By SalesforceImplementation = By.xpath("//span[contains(.,'Salesforce Implementation')]");
	public By Salesforcecertification = By.xpath("//*[@id=\"post-224476\"]/div/div/div/div[5]/div[2]/div/div/a/span");
	public String Salesforcecertification_url = "https://appexchange.salesforce.com/appxConsultingListingDetail?listingId=a0N3A00000FR4dnUAD";
	public String Salesforcecertification_Text = "Smart Data";
	public By SalesforcecertificationEle = By.id("consulting-header-bar-title-id");
	public By Salesforce_sales_Cloud = By.xpath("//span[contains(.,'Salesforce Sales Cloud')]");
	public String SalesforceCloud_url = "https://www.smartdata.net/salesforce-development/salesforce-sales-cloud/";
	public String SalesforceCloud_Text = "What is Salesforce Sales Cloud?";
	public By SalesforceCloudEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	public By Salesforce_ReadMore = By.xpath("(//a[contains(@href, 'https://www.smartdata.net/hybrid-model-case-study/')])[2]");
	public String Salesforce_ReadMore_url = "https://www.smartdata.net/hybrid-model-case-study/";
	public String  Salesforce_ReadMore_Text = "Case Study � Hybrid Model";
	public By Salesforce_ReadMoreEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	
	public By Staffing = By.xpath("(//a[contains(text(),'Staffing Solutions')])[3]");
	public String Staffing_url = "https://www.smartdata.net/staffing/";
	public String Staffing_Text = "Staffing";
	public By  StaffingEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	public By letstalk = By.xpath("(//a[contains(@href, 'https://www.smartdata.net/contact-us/')])[7]");
	public By Staffing_ReadMore = By.xpath(".//a[contains(text(),'Read mORE')]");
	
	public By AgileConsulting = By.xpath("(//a[contains(text(),'Dev-Ops/Agile Consulting')])[3]");
	public String AgileConsulting_url = "https://www.smartdata.net/agile/";
	public String AgileConsulting_Text = "Dev-Ops/Agile Consulting";
	public By AgileConsultingEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	
	public By DataScience = By.xpath("(//a[contains(text(),'Data Science')])[3]");
	public String DataScience_url = "https://www.smartdata.net/data-science/";
	public String DataScience_Text = "Data Science ";
	public By DataScienceEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");	
	
	public By Automation = By.xpath("(//a[contains(text(),'Automation')])[3]");
	public String Automation_url = "https://www.smartdata.net/automation/";
	public String Automation_Text = "Automation";
	public By AutomationEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	
	public By OffShore = By.xpath("(//a[contains(text(),'Offshore Software Development')])[3]");
	public String OffShore_url = "https://www.smartdata.net/offshore-software-development/";
	public String OffShore_Text ="Offshore Software Development Services";
	public By OffShoreEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	public By talk_with_an_expert = By.xpath("//a[contains(text(),'talk with an expert')]");
	public By OffShore_ReadMore = By.xpath("//a[contains(text(),'Read mORE')][1]");
	public By Hybrid_ReadMore = By.xpath("(//a[contains(text(),'Read mORE')])[2]");
	
	public By Industries = By.xpath("//ul[@id='menu-primary-menu-4']/li[2]/ul/li[2]/a/span[2]");
	public By HealthCare = By.xpath("(//a[contains(text(),'Healthcare')])[3]");
	public String HealthCare_url = "https://www.smartdata.net/healthcare/";
	public String HelathCare_Text ="Healthcare";
	public By HealthCareEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	public By HealthCare_viewmore = By.xpath("//a[contains(text(),'VIEW MORE')]");
	
	public By Retail = By.xpath("(//a[contains(text(),'Retail')])[3]");
	public String Retail_url = "https://www.smartdata.net/retail/";
	public String Retail_Text = "Retail";
	public By RetailEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	
	public By Manufacturing = By.xpath("(//a[contains(text(),'Manufacturing & Logistics')])[3]");
	public String Manufacturing_url ="https://www.smartdata.net/manufacturing/";
	public String Manufacturing_Text = "Manufacturing & Logistics";
	public By ManufacturingEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	
	public By Insurance = By.xpath("(//a[contains(text(),'Insurance & Banking')])[3]");
	public String Insurance_url ="https://www.smartdata.net/finance/";
	public String Insurance_Text = "Insurance & Banking";
	public By InsuranceEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	
	public By Products = By.xpath("//ul[@id='menu-primary-menu-4']/li[2]/ul/li[3]/a/span[2]");
	public By BeyondPod = By.xpath("(//a[contains(text(),'BeyondPod')])[3]");
	public String BeyondPod_url = "https://www.smartdata.net/beyondpod/";
	public String BeyondPod_Text = "BeyondPod";
	public By BeyondPodEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	
	public By SBN = By.xpath("(//a[contains(text(),'SBN Custom Website')])[3]");
	public String SBN_url = "https://www.smartdata.net/sbn-custom-websites/";
	public String SBN_Text = "SBN Custom Websites";
	public By SBNEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	public By SBN_ContactUs = By.xpath("//a[contains(text(),'Contact US')]");
	
	public By SmartTicket = By.xpath("(//a[contains(text(),'SmartTicket')])[3]");
	public String SmartTicket_url = "https://www.smartdata.net/smartticket/";
	public String SmartTicket_Text = "SmartTicket";
	public By SmartTicketEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	
	public By WorkHere = By.linkText("WORK HERE");
	public String WorkHere_url = "https://www.smartdata.net/work-here/";
	public String WorkHere_Text = "Work Here";
	public By WorkHereEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	public By WorkHere_ContactUs = By.xpath("(//a[contains(text(),'CONTACT US')])[7]");
	public String WorkHere_ContactUs_url = "https://www.smartdata.net/contact-us/";
	public String WorkHere_ContactUs_Text ="Contact Us";
	public By WorkHere_ContactUsEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	public By ApplyNow = By.xpath("//a[contains(text(),'Apply Now')][1]");
	public By ApplyNow1 = By.xpath("(//a[contains(text(),'Apply Now')])[2]");
	public By Applynow2 = By.xpath("(//a[contains(text(),'Apply Now')])[3]");
	public String ApplyNow_url = "https://joblist.smartdata.net/";
	public String ApplyNow_Text ="Current Openings";
	public By ApplyNowEle = By.xpath("//*[@id=\"job_postings_filter\"]/div[2]/div/div[2]/div[1]/div[1]/span");
	
	public By Lunch_Learn = By.linkText("LUNCH+LEARN");
	public String Lunch_Learn_url ="https://www.smartdata.net/lunch/";
	public String Lunch_Learn_Text = "Lunch & Learn";
	public By Lunch_LearnEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	public By Event1 = By.xpath(".//div[1]/div[2]/div/article/h2/a");
	public By Event2 = By.xpath(".//div[2]/div[2]/div/article/h2/a");
	public By Name = By.id("et_pb_contact_name_0");
	public By Lunch_Email = By.id("et_pb_contact_email_0");
	public By Lunch_Message = By.id("et_pb_contact_message_0");
	public By OldEntries = By.xpath("//a[contains(text(),'� Older Entries')]");
	public By NextEntries = By.xpath("//a[contains(text(),'Next Entries �')]");
	
	public By AboutUs = By.linkText("ABOUT US");
	public String AboutUs_url ="https://www.smartdata.net/about-us/";
	public String AboutUs_Text = "About Us";
	public By AboutUsEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	public By Ravi_Manchala = By.xpath("//a[contains(@href, 'https://www.linkedin.com/in/ravi-manchala-3660134/')]");
	public By Michael_martin = By.xpath("//a[contains(@href, 'https://www.linkedin.com/in/themichaelmartin/')]");
	public By Don_Kennedy = By.xpath("//a[contains(@href, 'https://www.linkedin.com/in/donken/')]");
	public By Taylor_Britain = By.xpath("//a[contains(@href, 'https://www.linkedin.com/in/taylor-britain/')]");
	public By Jay_Brown = By.xpath("//a[contains(@href, 'https://www.linkedin.com/in/jaybrownlv/')]");
	public By Jon_Greene = By.xpath("//a[contains(@href, 'https://www.linkedin.com/in/greenejonathan/')]");
	public By Katie_indoe = By.xpath("//a[contains(@href, 'https://www.linkedin.com/in/katie-indoe-91248226/')]");
	public By Srikant_Sunkara = By.xpath("//a[contains(@href, 'https://www.linkedin.com/in/srikantsunkara/')]");
	public By Rajesh_chintakunta = By.xpath("//a[contains(@href, 'https://www.linkedin.com/in/rajjeshc/')]");
	public By AboutUs_Email= By.xpath(".//*[@type='email' and @name='email']");

	
	public By ContactUs = By.linkText("CONTACT US");
	public String contactus_url = "https://www.smartdata.net/contact-us/";
	public By ContactusEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	public String Contact_Us = "Contact Us";
	public String FrameID = "hs-form-iframe-0";
	public By Email = By.name("email");
	public By FirstName = By.xpath(".//*[@type='text' and @name='firstname']");
	public By LastName = By.xpath(".//*[@type='text' and @name='lastname']");
	public By Message = By.xpath(".//*[@class='hs-input' and @name='message']");
	public By Cincinnati = By.xpath("//*[@class=\"et_pb_toggle_title\" and text()='Cincinnati, Ohio']");
	public By Louisville = By.xpath("//*[@class=\"et_pb_toggle_title\" and text()='Louisville, Kentucky']");
	public By Hyderabad = By.xpath("//*[@class=\"et_pb_toggle_title\" and text()='Hyderabad, India ']");
	
	public By Healthcare = By.linkText("Healthcare");
	public By SalesForce = By.linkText("SalesForce");
	public By staffing = By.linkText("Staffing");
	public By AgilConsulting = By.linkText("Agile Consulting");
	public By Whoweare = By.linkText("Who We Are");
	public By workhere = By.linkText("Work Here");
	public By LunchLearn = By.linkText("Lunch+Learn");
	public By Contact = By.linkText("Contact");
	public By partner = By.linkText("Partners");
	public By CNBS = By.xpath("//span[contains(.,'CNBS Software')]");
	public String CNBS_url = "https://www.cnbssoftware.com/";
	public String CNBS_Text = "eCommerce, Accounts Receivable and Fiori solutions for SAP";
	public By CNBSEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	public By AWS = By.xpath("//span[contains(.,'AWS')]");
	public String AWS_url ="https://aws.amazon.com/";
	public String AWS_Text ="Click here to return to Amazon Web Services homepage";
	public By AWSEle = By.xpath("//*[@id=\"m-nav\"]/div[1]/div[1]/div/a/span");
	public By SalesForce_Company = By.xpath("//div[3]/div/div/div[2]/h4/span");
	public String SalesForce_Company_url = "https://www.salesforce.com/in/?ir=1";
	public String SalesForce_Company_Text ="000 800 001 6000";
	public By SaleForce_CompanyEle = By.xpath("//*[@id=\"globalnavbar-header-container\"]/div[2]/div/div[2]/div/a/span[2]");
	public By GoogleCloud = By.xpath("//span[contains(.,'Google Cloud')]");
	public String GoogleCloud_url = "https://cloud.google.com/";
	public String GoogleCloud_Text = "Solve more with Google Cloud";
	public By GoogleCloudEle = By.id("solve-more-with-google-cloud");
	public By Ascend = By.xpath("//span[contains(.,'Ascend Innovations')]");
	public String Ascend_url = "https://ascend-innovations.com/";
	public String Ascend_Text = "ASCEND";
	public By AscendEle = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/header/div/a/h1/span[1]");
	public By costrategix = By.xpath("//a[contains(text(),'costrategix')]");
	public String costrategix_url= "https://www.costrategix.com/";
	public String costrategix_Text = "ABOUT COSTRATEGIX";
	public By costrategixEle = By.linkText("ABOUT COSTRATEGIX");
	public By F1Studio = By.xpath("//span[contains(.,'F1 Studioz')]");
	public String F1Studio_url = "https://www.f1studioz.com/#/home";
	public String F1Studio_Text = "Start Your Project";
	public By F1StudioEle = By.xpath(".//*[@class='primaryBtnLink']");
	public By keptraining = By.xpath("//span[contains(.,'Keptraining')]");
	public String keptraining_url = "https://keptraining.com/";
	public String keptraining_Text ="Knowledge � Education � Performance";
	public By keptrainingEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	public By zendesk = By.xpath("//div[4]/div[3]/div/div/div[2]/h4/span");
	public String zendesk_url="https://www.zendesk.com/";
	public String zendesk_Text = "Zendesk. Be the company your customers want you to be.";
	public By zendeskEle = By.xpath(".//*[@class='zendesk-logo']");
	public By Blogs = By.linkText("Blog");
	public String Blogs_url = "https://www.smartdata.net/blog/";
	public String Blogs_Text = "Smart Data Blog";
	public By BlogsEle = By.xpath(".//*[@class='et_pb_text_inner']/h1");
	public By Blog1 = By.xpath("(//div[1]/article/h2/a)[1]");
	public By Blog2 = By.xpath("//div[2]/article/h2/a");
	public By Blog3 = By.xpath("(//div[1]/article[2]/h2/a)[1]");
	public By Blog4 = By.xpath("//div[2]/article[2]/h2/a");
	public By Blog5 = By.xpath("//div[1]/article[3]/h2/a");
	public By Blog6 = By.xpath("//div[2]/article[3]/h2/a");
	public By Older_Entries = By.xpath("//a[contains(text(),'� Older Entries')]");
	public By Next_Entries = By.xpath("//a[contains(text(),'Next Entries �')]");
	
	
}
