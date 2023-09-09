package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

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
	
	public void loginPageTitleVisiblity()
	{
		au.checkVisible(loginpagetitle);
	}
	
	public void setUser(String UserName)
	{				
		au.enterText(userTextbox, UserName);
	}
	
	public void setPwd(String pwd)
	{
		au.enterText(PwdTextbox, pwd);
	}
	
	public void clickLoginButton()
	{			
		au.clickOper(loginButton);
	}
}
