package TestRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class testRun 
{
	@CucumberOptions
	(		
		features = 
			{
				"src/test/resources/Features",
				
			},
		plugin = {"pretty", "html:target/SystemTestReports/index.html",  
				  "junit:target/SystemTestReports/junit/report.xml",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"				  
				  },
		monochrome=true,	
		dryRun=false,
		glue = {"StepDefinition", "Hooks" }
	)
	
	public class TestRun extends AbstractTestNGCucumberTests
	{
		@Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() 
		{				
			return super.scenarios();
	    }
	}
}
