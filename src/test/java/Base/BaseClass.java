package Base;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.StudentPageElements;
import PageObjects.homePageElements;
import PageObjects.loginPageElements;
import utilities.ApplicationUtils;
import utilities.ReadConfig;

public class BaseClass 
{
	
	public static WebDriver driver;
	static ReadConfig config = new ReadConfig();
	public static Logger log = LogManager.getLogger("BaseClass.java");
	
	public static ResourceBundle configPropertiesFile = ResourceBundle.getBundle("ReadConfig");
	
	public static String homeUrl = configPropertiesFile.getString("Home_url");
	public static String loginUrl = configPropertiesFile.getString("Login_url");
	public static String browserName = configPropertiesFile.getString("browser");
	public static String ValidUserName = configPropertiesFile.getString("Valid_User");
	public static String ValidPassword = configPropertiesFile.getString("Valid_Pwd");
	public static String InvalidLMSURL = configPropertiesFile.getString("Invalid_url");
		
	public static homePageElements hpe = new homePageElements();
	public static loginPageElements lpe = new loginPageElements();
	public static ApplicationUtils au = new ApplicationUtils();
	public static StudentPageElements studentPage = new StudentPageElements();
	
	public void tearDown() 
	{
		log.info("---------- Base Class - teadDown Started ----------");
		driver.quit();
		log.info("---------- Base Class - teadDown Completed ----------");
	}

}
