package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class homePageElements extends BaseClass 
{
	public homePageElements()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "Login")
	WebElement loginButton;
	
	public void loginButtonClick()
	{
		au.clickOper(loginButton);
	}
}
