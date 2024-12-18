package Stepdefinitionfile;

import io.cucumber.java.en.Then;

public class Closestep extends Baseclass{   //base isparent class and rest child class

	@Then("close browser")
	public void close_browser() {
		driver.close();
//		driver.quit();   //bec @After method is running
		log.info("browser closed..");
	}
}
