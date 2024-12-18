package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions
 (
		features = {".//Features/Addressbook.feature", ".//Features/cuc.feature"},
		glue = "Stepdefinitionfile",
		dryRun = false,
		monochrome = true, 
//		tags= "@regression or @Sanity",
		plugin = {"pretty","html:target/Cucumber-reports/reports1.html"}
				
 )

//tags="@regression and @Sanity"
//tags="@regression and not  @Sanity"
//plugin = {"pretty","junit:target/Cucumber-reports/reports_xml.xml"}
//plugin =  {"pretty","html:target/Cucumber-reports/reports1.html"}
//plugin = {"pretty","json:target/Cucumber-reports/reports_json.json"}

public class Runner extends AbstractTestNGCucumberTests {

}
