package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;
import utilities.ApplicationUtils;

public class homePageElements extends BaseClass 
{
	public homePageElements()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "Login")
	public WebElement loginButton;
	
	@FindBy(xpath="//img[@src=/path/to/image.png\\")
	WebElement LogoImage;
	
	public void loginButtonClick()
	{
		ApplicationUtils.clickOper(loginButton);
	}
	
	public String getLogoSRC()
	{
		return LogoImage.getAttribute("src");
	}
	
	
}
