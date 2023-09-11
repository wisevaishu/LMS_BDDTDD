package StepDefinition;



import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import utilities.ApplicationUtils;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.methods.HttpUriRequest;

public class homepage extends BaseClass
{
	public int statuscode;
	public HttpURLConnection httpURLConnection;
	
	@Given("Admin launch browser")
	public void admin_launch_browser()
	{
		if (browserName=="chrome")
		{
			System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();			
		}
		log.info("Admin launch browser");
	}
	
	@When("Admin gives the correct LMS")
	public void admin_gives_the_correct_lms() 
	{
		driver.get(homeUrl);
		driver.manage().window().maximize();
		log.info("Admin gives the correct LMS");
	}
	
	@Then("Admin should land on home page")
	public void admin_should_land_on_home_page() 
	{
		String TitleOfThePage = au.getTitleOfThePage();
		Assert.assertEquals(TitleOfThePage, "Home Page");
		log.info("Admin should land on home page");
	}	
	

	@When("HTTP response >= {int} the {string} is broken")
	public void http_response_the_is_broken(Integer statuscodefromfeature, String url) 
	{
		try
		{
			if (url=="homeurl")
			{
				statuscode = au.CheckHTTPResponse(homeUrl);	
			}
			else if (url=="loginurl")
			{
				statuscode = au.CheckHTTPResponse(loginUrl);
			}
			else if (url=="invalidurl")
			{
				statuscode = au.CheckHTTPResponse(InvalidLMSURL);
			}
			
			if (statuscode>=statuscodefromfeature) 
			{				
				log.info(homeUrl + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
			}			
		}
		catch (Exception e) 
		{
			 e.printStackTrace();
		}	
	}
	
	@When("Admin gives Invalid URL")
	public void admin_gives_invalid_url() 
	{
		driver.get(InvalidLMSURL);
		driver.manage().window().maximize();
		log.info("Admin gives the Wrong LMS URL website");
	}
	
	@Then("Admin checks corresponding {string}")
	public void admin_checks_corresponding(String appearancesCriteria) throws IOException, TesseractException 
	{
		//Checking spelling mistakes in image
		if (appearancesCriteria.equals("text_spelling"))
		{
			//Take screenshot of screen and get text
			String Stepname="LogoImage";
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
			String path = ".\\src\\test\\resources\\Screenshots\\"+Stepname+".jpeg";
			File destFile = new File (path);
			FileUtils.copyFile(srcFile,destFile);
			ITesseract tesseract = new Tesseract();
			String text = tesseract.doOCR(destFile);
			
			//compare text with our dic
			String[] wordlist = new String[7];
			wordlist[0]="L";
			wordlist[1]="M";
			wordlist[2]="S";
			wordlist[3]="Learning";
			wordlist[4]="Management";
			wordlist[5]="System";
			
			if (ApplicationUtils.spellCheck(text, wordlist))
			{
				Assert.assertEquals(ApplicationUtils.spellCheck(text, wordlist), true);
				log.info("No Spelling mistakes");
			}
			
			else
			{
				Assert.assertEquals(ApplicationUtils.spellCheck(text, wordlist), false);
				log.info("Spelling mistakes there");
			}
		}	
		
		//checking correct logo present or not
		else if (appearancesCriteria.equals("logo"))
		{
			String LogoSRC = hpe.getLogoSRC();
			URL imageURL = new URL(LogoSRC);
			BufferedImage saveImage = ImageIO.read(imageURL);
			ImageIO.write(saveImage, "png", new File("LMSLogo"+".png"));
			
			String LogoFromUrl = "give LMSLogo.png path";
			String LogoFromdir="give image location of logo which pasted already in dir for testing";
			
			 BufferedImage expectedImage = ImageIO.read(new File(LogoFromUrl));
		     BufferedImage actualImage = ImageIO.read(new File(LogoFromdir));

		     ImageDiffer imgDiff = new ImageDiffer();
		     ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		     
		     if(diff.hasDiff()==true)
		     {
		    	 log.info("Images are not same");
		     }
		     else
		     {
		    	 log.info("Images are same");
		     }
		}
		
		// Checking for broken logo image
		else if (appearancesCriteria.equals("Broken_Logo_Image"))
		{
			String LogoSRC = hpe.getLogoSRC();
			
			 try
			 { 
				 HttpClient client = HttpClientBuilder.create().build();
				 HttpUriRequest httpUriRequest = new 
				 HttpGet(LogoSRC);
				 
				 statuscode = au.CheckHTTPResponse(InvalidLMSURL);
				 
				 HttpResponse response = client.execute(httpUriRequest);
				 				  
			    if (response.getStatusLine().getStatusCode() != 200) 
			    {  
			    	  log.info("Image is broken");
			    } 
			 }
			 catch (Exception e)
			 {
				 e.printStackTrace();
			 }
		}
		
		// Login Button Visiblity
		else if (appearancesCriteria.equals("login_button_Visiblity"))
		{			
			Assert.assertEquals(ApplicationUtils.checkVisible(hpe.loginButton),true);
			log.info("Check visiblity of login button in main page");
		}	
		
		// Login button clickable
		else if  (appearancesCriteria.equals("login_button_clickable")) 
		{
			Assert.assertEquals(ApplicationUtils.isClickable(hpe.loginButton), false);
			log.info("Checking Login Button is clicakable or not");
		}
	}
}

