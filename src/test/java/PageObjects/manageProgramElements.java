package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class manageProgramElements extends BaseClass 
{
	public manageProgramElements()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[contains('Manage Program')]")
	public WebElement ManageProgramSpanText;
	
	public String getManageProgramSpanText()
	{
		return ManageProgramSpanText.getText();
	}
	
	
}
