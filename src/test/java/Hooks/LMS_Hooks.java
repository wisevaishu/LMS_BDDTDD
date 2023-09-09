package Hooks;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Base.BaseClass;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LMS_Hooks extends BaseClass 
{
	@Before
	public synchronized void setup()
	{
		if (browserName=="chrome")
		{
			System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();			
		}
		
		else  if (browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();			
		}
		
		driver.get(homeUrl);
		driver.manage().window().maximize();
	}
}
