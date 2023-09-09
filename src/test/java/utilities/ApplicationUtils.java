package utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplicationUtils extends BaseClass 
{
	protected static WebDriverWait wait;
	
	public ApplicationUtils() 
	{
		PageFactory.initElements(driver, this);
	}

//	public static void Login(String username, String passwordEle) 
//	{
//		WebElement email = driver.findElement(By.id("email_field"));
//		email.sendKeys(username);
//		WebElement password = driver.findElement(By.id("password_field"));
//		password.sendKeys(passwordEle);
//		WebElement button = driver.findElement(By.tagName("button"));
//		button.click();
//	}

	public static void clickOper(WebElement ele) 
	{
		ele.click();
		System.out.println("pass: tex");
	}

	public static void enterText(WebElement element, String text) 
	{
		waitUntilVisible(element);
		if (element.isDisplayed()) 
		{
			if (text != null) 
			{
				element.sendKeys(text);
				System.out.println("pass: text entered " + text);
			}
		} 
		else 
		{
			System.out.println("fail: element not displayed");
		}
	}

	public static void waitUntilVisible(WebElement element) 
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void ImplicitWait() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public static void waitUntilAlertIsPresent() 
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void AcceptAlert() 
	{
		waitUntilAlertIsPresent();
		Alert alert = driver.switchTo().alert();
		System.out.println("alert text=" + alert.getText());
		alert.accept();
	}

	public static void close() 
	{
		driver.close();
	}

	public String getTitleOfThePage() 
	{
		return driver.getTitle();
	}

	public static String Asserting(String text) 
	{
		return text;
	}
	
	public static void checkVisible(WebElement element) 
	{
		element.isDisplayed();
	}
}
