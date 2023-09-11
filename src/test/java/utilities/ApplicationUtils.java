package utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
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

import java.net.HttpURLConnection;

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
	
	public static boolean spellCheck(String input, String[] dic)
	{
		String CurrentCheck ="";
		boolean noErrors = true;
		Scanner spellChecker = new Scanner(input);
		spellChecker.useDelimiter("\\s+");
		while (spellChecker.hasNext())
		{
			CurrentCheck=spellChecker.next();
			if(!isSpecial(CurrentCheck))
			{
				if(!checkWork(CurrentCheck, dic))
				{
					noErrors=false;
				}
			}
		}
		return noErrors;
	}
	
	public static boolean isSpecial(String input)
	{
		Pattern pattern = Pattern.compile("[^a-z0-9 ]",Pattern.CASE_INSENSITIVE);
		Matcher match = pattern.matcher(input);
		return match.find();
	}
	
	public static boolean checkWork(String input, String[] dic)
	{
		boolean valid=false;
		int length =dic.length;
		int i=0;
		while(!valid && i<length)
		{
			if (input.trim().equalsIgnoreCase(dic[i]))
			{
				valid=true;
			}
			i++;
		}
		return valid;
	}
	
	public static boolean isClickable(WebElement element)
	{
		try
		{ 
			wait.until(ExpectedConditions.elementToBeClickable(element));
		   return true;
		 }
		catch (Exception e)
		{
			return false;
		}
	}
	
	public static boolean checkVisible(WebElement element) 
	{
		boolean value;
		try 
		{
			value=element.isDisplayed();
			return value;
		}
		catch (Exception e)
		{
			return false;
		}		
	}
	
	public int CheckHTTPResponse(String url) throws IOException
	{
		HttpURLConnection httpURLConnection;
		URL link = new URL(url);
		httpURLConnection= (HttpURLConnection) link.openConnection();
		httpURLConnection.setConnectTimeout(3000); 
		httpURLConnection.connect();
		return httpURLConnection.getResponseCode();
	}
	
	
}
