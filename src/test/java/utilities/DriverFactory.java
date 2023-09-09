package utilities;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import Base.BaseClass;

public class DriverFactory extends BaseClass 
{
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static Properties prop;
	
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	@Before(order = 0)
	public void Launch()
	{
		System.out.println("Initializing the driver from driver factory");
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			driver = new ChromeDriver(chromeOptions);
		}
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxBinary firefoxBinary = new FirefoxBinary();
			FirefoxOptions options = new FirefoxOptions();
			options.setBinary(firefoxBinary);
			//options.setHeadless(true);
			driver = new FirefoxDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		tdriver.set(driver);
	}	
	
	public static synchronized WebDriver getDriver() 
	{
		return tdriver.get();
	}
	
	@After(order = 1)
	public void closeDriver() 
	{
		driver.quit();
	}
}
