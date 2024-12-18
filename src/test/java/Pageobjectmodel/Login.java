package Pageobjectmodel;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	
public WebDriver CurrentDriver;
	
	public Login(WebDriver RemoteDriver)
	{
		CurrentDriver = RemoteDriver;
		PageFactory.initElements(RemoteDriver, this);
		
	}
	
	
	@FindBy(linkText = "Sign In") WebElement emailclick; 
	
	@FindBy(xpath = "//input[@id='email']") WebElement  email;
	
	@FindBy(xpath="//input[@id='pass']") WebElement pass;
	
	@FindBy(xpath="//button[@id='send2']//span[contains(text(),'Sign In')]") WebElement login;
	
	@FindBy(xpath = "//button[@class='action switch']") WebElement logoutclick;
	
	@FindBy(linkText =  "Sign Out") WebElement logout;
	
	
	public void enteremail_click()  //action method
	{

		emailclick.click();
	}
	
	
	public void enteremail(String emailadd)  
	{

		email.sendKeys(emailadd);
	}
	public void enterpass(String passadd)
	{  

		pass.sendKeys(passadd);
	}
	public void enterlogin()
	{
		login.click();
		
		
	    
	}
	public void enterlogout_click()
	{
		logoutclick.click();
	}
	public void enterlogout()
	{
		logout.click();
	}
	
//	-------------------------------
	
	
}

