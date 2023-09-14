package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;
import utilities.ApplicationUtils;

public class forgotUserPasswordElements extends BaseClass 
{
	public forgotUserPasswordElements()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='email']")
	public WebElement emailTextbox;
	
	@FindBy(xpath = "//button[@name='sendlink']")
	public WebElement SendLinkButton;
	
	@FindBy(xpath = "//label[contains('Forgot Username or Password')]")
	public WebElement ForgotUserPwdHeading;
	
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement retrievemsg;
	
	public String getEmailTextcolor()
	{
		return emailTextbox.getCssValue("color");		
	}
	
	public String getEmailText()
	{
		return emailTextbox.getText();
	}
	
	public String getLinkButtonText()
	{
		return SendLinkButton.getText();
	}
	
	public String getForgotUserPwdHeadingText()
	{
		return ForgotUserPwdHeading.getText();
	}
	
	public void setEmail(String Email)
	{				
		ApplicationUtils.enterText(emailTextbox, Email);
	}
	
	public void clickSendLinkButton()
	{			
		ApplicationUtils.clickOper(SendLinkButton);
	}
	
	public String printRetrievemsg() 
	{
		return retrievemsg.getText();		
	}
}
