package Base;

import java.time.Duration;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import PageObjects.*;
import utilities.ApplicationUtils;


import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass 
{
	
	public static WebDriver driver;
	//static ReadConfig config = new ReadConfig();
	public static Logger log = LogManager.getLogger("BaseClass.java");
	
	public static ResourceBundle configPropertiesFile = ResourceBundle.getBundle("ReadConfig");
	
	public static String homeUrl = configPropertiesFile.getString("Home_url");
	public static String loginUrl = configPropertiesFile.getString("Login_url");
	public static String browserName = configPropertiesFile.getString("browser");
	public static String ValidUserName = configPropertiesFile.getString("Valid_User");
	public static String ValidPassword = configPropertiesFile.getString("Valid_Pwd");
	public static String InvalidLMSURL = configPropertiesFile.getString("Invalid_url");
	public static String ForgotUsernamePasswordURL = configPropertiesFile.getString("ForgotUsernamePassword_url");
	public static String StudentPage_URL = configPropertiesFile.getString("StudentPage_url");
	public static String ManageProgram_URL = configPropertiesFile.getString("ManageProgram_url");
	public static String dashboardUrl = configPropertiesFile.getString("dashboardUrl");
	public static String classUrl = configPropertiesFile.getString("classUrl");
	public static String batchUrl = configPropertiesFile.getString("batchUrl");
	public static String userUrl = configPropertiesFile.getString("userUrl");
	public static String assignmentUrl = configPropertiesFile.getString("assignmentUrl");
	public static String attendanceUrl = configPropertiesFile.getString("attendanceUrl");
	public static String  assignmentURL = configPropertiesFile.getString("assignment_url");
	public static String  managebatchurl = configPropertiesFile.getString("managebatchurl");
	
	public static String excelpath = "\\src\\test\\resources\\LMS_ExcelSheet\\LMSExcel.xlsx";
			
	public static homePageElements hpe = new homePageElements();
	public static loginPageElements lpe = new loginPageElements();
	public static ApplicationUtils au = new ApplicationUtils();
	public static StudentPageElements studentPage = new StudentPageElements();
	public static forgotUserPasswordElements fup = new forgotUserPasswordElements();
	public static resetPasswordElements rpe = new resetPasswordElements();
	public static manageProgramElements mpe = new manageProgramElements();
	public static dashboardElements dbe = new dashboardElements();
	public static ProgramPageElements programPage = new ProgramPageElements();
	public static classPageElements cpe = new classPageElements();	
	public static AttendancePageElements mape= new AttendancePageElements();
	public static assignmentPageElements ape = new  assignmentPageElements();
	public static BatchPageValidationEle bpe = new BatchPageValidationEle();
	public static UserPageElements upe = new UserPageElements();
	
	public static String mainWindow = driver.getWindowHandle(); 
	public static SoftAssert softAssert = new SoftAssert();
	
	public static long start_time = 0, end_time = 0, time_taken = 0;
	public static int size = 0;
	public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	public void tearDown() 
	{
		log.info("---------- Base Class - teadDown Started ----------");
		driver.quit();
		log.info("---------- Base Class - teadDown Completed ----------");
	}

}
