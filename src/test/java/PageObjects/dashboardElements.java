package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;
import utilities.ApplicationUtils;

public class dashboardElements extends BaseClass
{
	public dashboardElements()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[contains('LMS - Learning Management System')]")
	public WebElement LMSTitle;
	
	@FindBy(xpath = "//body/div[@id='navigation']/div[1]/nav[1]/div[1]/ul/li")
	public List<WebElement> NavigationMenuList;
	
	@FindBy(xpath = "//a[contains(text(), 'Logout')]")
	public WebElement LogoutLink;
		
	@FindBy(xpath = "//div[@id='nav-bar-links-area']")
	public WebElement LMSNavigationBar;
		
	public String getLMSTitleText()
	{
		return LMSTitle.getText();
	}	
	
	public void clickLogout()
	{
		ApplicationUtils.clickOper(LogoutLink);
	}
}
