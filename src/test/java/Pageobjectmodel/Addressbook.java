package Pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Addressbook {

	
	public WebDriver CurrentDriver;
	
	public Addressbook(WebDriver RemoteDriver)
	{
		CurrentDriver=RemoteDriver;
		
		PageFactory.initElements(RemoteDriver, this);
	}
// find web element on  the web page
	
	@FindBy(xpath = "//button[@class='action switch']") WebElement clickdropedown;
	
	@FindBy(linkText = "My Account") WebElement clickonmyaccount;
	
	@FindBy(xpath = "//a[contains(text(),'Address Book')]") WebElement click_addbook;
	
	
	@FindBy(xpath = "//button[@class='action primary add']") WebElement addnew;
	
	@FindBy(xpath = "//input[@id='firstname']") WebElement firstname;
	
	@FindBy(xpath = "//input[@id='lastname']") WebElement lastname;
	
	@FindBy(xpath="//input[@id='company']") WebElement company1;
	
	@FindBy(xpath="//input[@id='telephone']") WebElement phoneno;
	
	@FindBy(xpath="//input[@id='street_1']") WebElement streetaddress;
	
	@FindBy(xpath="//input[@id='street_2']") WebElement streetaddress2;
	
	@FindBy(xpath="//input[@id='street_3']") WebElement streetaddress3;
	
	@FindBy(xpath="//input[@id='city']") WebElement addcity;
	
	
	@FindBy(xpath="//select[@id='region_id']")  WebElement state;
	
	
	
	@FindBy(xpath = "//input[@id='zip']") WebElement zip;
	
	@FindBy(xpath= "//select[@id='country']") WebElement country;
	
	@FindBy(xpath="//button[@class='action save primary']") WebElement saveaddress;
	
	//WebElement e1 =driver.findElement(By.tagName("select"));
	//Select sc = new Select(e1);  // e1 ko pass kia
	
	public String getpagetitle()
	{
		return CurrentDriver.getTitle();
	}
	
	public void clickon_drop()
	{
		clickdropedown.click();
	}
	
	public void clickon_myaccount()
	{
		clickonmyaccount.click();
	}
	
	
	
	public void clickonaddbook()
	{
		click_addbook.click();
	}
	
	public void enter_addbook() 
	{
		
		addnew.click();
	}
	
	
	//////////////////////////////////
	
	public void first_name()
	{
		firstname.clear();
		firstname.sendKeys("jack");
	}
	public void last_name()
	{
		lastname.clear();
		lastname.sendKeys("sparrow");
	}
	public void company_1()
	{
		company1.sendKeys("json");
	}
	public void phone_no()
	{
		phoneno.sendKeys("9407895623");
	}
	public void streetaddress_1()
	{
		streetaddress.sendKeys("phase 3");
	}
	public void streetaddress_2()
	{
		streetaddress2.sendKeys("mahadev temple");
	}
	public void streetaddress_3()
	{
		streetaddress3.sendKeys("uttarkashi");
	}
	public void add_city()
	{
		addcity.sendKeys("delhi");
	}
	public void state_1()///////-------------------------------------select
	{
		Select sc= new Select(state);
		state.sendKeys("Delhi");
		
		
	}
	public void zip_1()
	{
		
		zip.sendKeys("110001");
	}
	public void country_1()//---------------------------------select
	{
		Select sc= new Select(country);
		country.sendKeys("India");
	}
	
	
	public void save_address()
	{
		saveaddress.click();
	}
	
}
//WebElement e1 =driver.findElement(By.tagName("select"));
//Select sc = new Select(e1);  // e1 ko pass kia
