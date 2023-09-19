package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;	

import org.junit.runner.RunWith;
 
@RunWith(Cucumber.class)

@CucumberOptions
(
		
		plugin = {"pretty", "html:target/SystemTestReports/index.html",  
				  "junit:target/SystemTestReports/junit/report.xml",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				 		 
				  },
		monochrome = true, 
		dryRun = true, 
		features = "src/test/resources/Features", 
		glue = {"StepDefinition", "Hooks" }
)

public class Runner  
{
	
}
