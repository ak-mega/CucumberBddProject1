package Stepdefinitionfile;



import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import Pageobjectmodel.Addressbook;
import Pageobjectmodel.Login;
import Utilities.Readconfiguration;

public class Baseclass {

	
	public static WebDriver driver;
	public Login lg;
	public Addressbook adb;
	public static Logger log;
	
	public Readconfiguration readconfig;
	
	//generate unique email id
 public String generateEmailid()
 {
	return  (RandomStringUtils.randomAlphabetic(5));
 }
 
}
