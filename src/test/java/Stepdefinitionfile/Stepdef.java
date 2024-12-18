package Stepdefinitionfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import Pageobjectmodel.Addressbook;
import Pageobjectmodel.Login;
import Utilities.Readconfiguration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class Stepdef extends Baseclass {

//	public	WebDriver driver;
//	public Login lg;
//	public Addressbook adb;


	@Before
	public void setup() throws Exception
	{
		readconfig = new Readconfiguration();    //initialize
		
		log= LogManager.getLogger("Stepdef");
		
		String browser= readconfig.getbrowser();
		switch(browser.toLowerCase())
		{
		case "chrome":
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			driver= new FirefoxDriver();
			break;
			
		case "msedge":
			driver = new EdgeDriver();
			break;
			
		default:
			driver= null;
			break;
			
		}
		
//		System.out.println("setup method executed");   //not neede bec we shifted in switch case
//		driver=new ChromeDriver();
		log.info("setup executed....");
		
	}
	
	@Given("user launch the webbrowser")
	public void user_launch_the_webbrowser() {

//		driver=new ChromeDriver();  //bec in @before method
		lg=new Login(driver);
		adb = new Addressbook(driver);
		log.info("chrome browser launch...");
	}

	@When("user open url {string}")
	public void user_open_url(String url) {
		driver.get(url);
		log.info("url opened.......");
	}

	@When("user enter the usernam  {string} and password  {string}")
	public void user_enter_the_usernam_and_password(String email, String pass) {
		lg.enteremail_click();
		lg.enteremail(email);
		lg.enterpass(pass);
		log.info("email and password entered");
	}

	@When("click on login button")
	public void click_on_login_button()  {
		lg.enterlogin();
		log.info("login click....");

		///////////////////////////  


	}

	@Then("page title should be {string}")
	public void page_title_should_be(String Exptitle) {
		String acttitle=driver.getTitle();

		//		Assert.assertEquals(Exptitle, acttitle);

		if(acttitle.equals(Exptitle))
		{	
			log.warn("Test passed: Login feature  : page title matched...");
			
			Assert.assertTrue(true);
		}
		else
		{	
			log.warn("Test passed : Login feature  : page title matched...");
			Assert.assertTrue(false);
		}
	}

	@When("user click on logout button")
	public void user_click_on_logout_button() {
		lg.enterlogout_click();
		lg.enterlogout();
		log.info("logout click....");
	}
	

	/*@Then("close browser")
	public void close_browser() {
		driver.close();
//		driver.quit();   //bec @After method is running
		log.info("browser closed..");
	}*/


	//////////////////////////////////////address book////////////////////////////
	//My Account


	@Then("user can view dashboard")
	public void user_can_view_dashboard() {
		String acttitle = adb.getpagetitle();
		String exptitle= "Home Page";
		Assert.assertEquals(exptitle, acttitle);
		log.info("user can view dashboard");

	}

	@When("user click on my account option")
	public void user_click_on_my_account_option() {
		adb.clickon_drop();
		adb.clickon_myaccount();
		log.info("user can view account page");

	}

	@When("click on Address book")
	public void click_on_address_book() {
		adb.clickonaddbook();
		adb.enter_addbook();
		log.info("user can view address book...");
	}

	@Then("user can view add address book details as title {string}")
	public void user_can_view_add_address_book_details_as_title(String exptitle) {

		String acttitle=driver.getTitle();
		Assert.assertEquals(exptitle, acttitle);
		log.info("user can view addressbook details.");
	}

	@When("user enter address information")
	public void user_enter_address_information() {

		adb.first_name();
		adb.last_name();
		adb.company_1();
		adb.phone_no();
		adb.streetaddress_1();
		adb.streetaddress_2();
		adb.streetaddress_3();
		adb.add_city();
		adb.country_1();
		adb.state_1();
		adb.zip_1();
		log.info("user entered details...");



	}

	@When("click on save address")
	public void click_on_save_address() {

		adb.save_address();
		log.info("user saved details");
	}

	@Then("user can view confirmation message as {string}")
	public void user_can_view_confirmation_message_as(String expconfirmationmsg) {

		String bodytagtext = driver.findElement(By.tagName("Body")).getText();
		if(bodytagtext.contains(expconfirmationmsg))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

	//screenshot-------------------------------------------

	@After
	public void teardown(Scenario sc)
	{
		System.out.println("setup method stop");
		if(sc.isFailed()==true)
		{
			String Path="C:\\Users\\hp\\eclipse-workspace\\CucumberFramework1\\Screenshot\\failed_screenshot.png";
			TakesScreenshot src= ((TakesScreenshot)driver);
			
			//call getscreenshot method to create image file
			File srcfile=src.getScreenshotAs(OutputType.FILE);
			
			//move image file to new destination
			File Desfile=new File(Path);
			
			//copy file at destination
			try {
				FileUtils.copyFile(srcfile, Desfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}     //commons io package
			
		}
		driver.quit();
	}



}
