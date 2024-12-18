package seprate_test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class luma_site {


	@Test
	void test() throws Exception
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");

		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("akshukla.shukla2@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Admin123");
		driver.findElement(By.xpath("//button[@id='send2']//span[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//button[@class='action switch']")).click();
		driver.findElement(By.linkText("My Account")).click();
		Thread.sleep(5000);
//		driver.findElement(By.xpath("//a[text()='Address Book']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Address Book')]")).click();
//		driver.findElement(By.linkText("Address Book")).click();
//		driver.findElement(By.xpath("//div[@id='block-collapsible-nav']//strong[contains(text(),'Address Book')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='action primary add']")).click();
		
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("carls");
		
//		driver.findElement(By.linkText("Sign Out")).click();
	//And close browser  	
		
	}

}

