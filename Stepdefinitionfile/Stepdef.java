package Stepdefinitionfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import Pageobjectmodel.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class Stepdef {

   public	WebDriver driver;
	public Login lg;
	
	@Given("user launch the webbrowser")
	public void user_launch_the_webbrowser() {
//		WebDriverManager.chromedriver().setup();   //not needed
	    driver=new ChromeDriver();
	    lg=new Login(driver);
	}

	@When("user open url {string}")
	public void user_open_url(String url) {
		driver.get(url);
	   
	}

	@When("user enter the usernam {string} and password {string}")
	public void user_enter_the_usernam_and_password(String username, String pass) {
	    lg.enteremail(username);
        lg.enterpass(pass);	
	}

	@When("click on login button")
	public void click_on_login_button() throws Exception {
	    lg.enterlogin();
//	    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Widget containing a Cloudflare security challenge']")));
//	    Thread.sleep(5000);
//	    driver.findElement(By.cssSelector("cb-i")).click();
//	    driver.switchTo().defaultContent();
	    
	    
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String Exptitle) {
		String acttitle=driver.getTitle();
	    Assert.assertEquals(Exptitle, acttitle);
	}

	@When("user click on logout button")
	public void user_click_on_logout_button() {
	   lg.enterlogout();
	}

	@Then("close browser")
	public void close_browser() {
	    driver.close();
	    driver.quit();
	}
}
