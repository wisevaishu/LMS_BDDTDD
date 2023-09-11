package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;
import utilities.ApplicationUtils;

public class loginPageElements extends BaseClass
{
	public loginPageElements()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h5[contains(text(), 'Please login to LMS application')]")
	WebElement loginpagetitle;
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement userTextbox;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement PwdTextbox;	
	
	@FindBy(xpath = "//input[@name='login']")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[contains('Please login to LMS application')]")
	WebElement loginpageHeadingLink;
	
	@FindBy(xpath = "//a[contains('Forgot Username or Password')]")
	WebElement ForgotUserPwdLink;
	
	@FindBy(xpath = "//a[contains('Reset Password')]")
	WebElement ResetPwdLink;
	
	@FindBy(xpath = "//span[text='Note : UI Screens in this PPT is for ADMIN Role']")
	WebElement BottomSpanText;
	
	public void loginPageTitleVisiblity()
	{
		ApplicationUtils.checkVisible(loginpagetitle);
	}
	
	public void setUser(String UserName)
	{				
		ApplicationUtils.enterText(userTextbox, UserName);
	}
	
	public void setPwd(String pwd)
	{
		ApplicationUtils.enterText(PwdTextbox, pwd);
	}
	
	public void clickLoginButton()
	{			
		ApplicationUtils.clickOper(loginButton);
	}
	
	public String getUserText()
	{
		return userTextbox.getText();
	}
	
	public String getPasswordText()
	{
		return PwdTextbox.getText();
	}
	
	public String getHeaderLineText()
	{
		return loginpageHeadingLink.getText();
	}
	
	public String getLoginButtonText()
	{
		return loginButton.getText();
	}
	
	public String getForgotUserPwdText()
	{
		return ForgotUserPwdLink.getText();
	}
	
	public String getResetPwdText()
	{
		return ResetPwdLink.getText();
	}
	
	public String getBottomSpanText()
	{
		return BottomSpanText.getText();
	}
}
