package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;
import utilities.ApplicationUtils;

public class resetPasswordElements extends BaseClass 
{
	public resetPasswordElements()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//label[contains('Reset Password Page')]")
	WebElement ResetPasswordLabel;
	
	@FindBy(xpath = "//label[contains('Type in new Password')]")
	WebElement TypeInNewPasswordLabel;
	
	@FindBy(xpath = "//label[contains('ReType Password')]")
	WebElement RetypePasswordLabel;
	
	@FindBy(xpath = "//input[@name='newpassword']")
	public WebElement NewPasswordTextBox;
	
	@FindBy(xpath = "//input[@name='retypepassword']")
	public WebElement ReTypePasswordTextBox;
	
	@FindBy(xpath = "//button[@name='Submit']")
	public WebElement SubmitButton;
	
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement retrievemsg;
	
	List<WebElement> totalTextboxes = driver.findElements(By.xpath("//input[@type='text']"));
	
	public String getResetPasswordLabelText()
	{
		return ResetPasswordLabel.getText();
	}
	
	public String getTypeInNewPasswordLabelText()
	{
		return TypeInNewPasswordLabel.getText();
	}
	
	public String getReTypePasswordText()
	{
		return RetypePasswordLabel.getText();
	}
	
	public String getSendLinkButtonText()
	{
		return SubmitButton.getText();
	}
	
	public int TotalTextboxesCount()
	{
		return totalTextboxes.size();
	}
	
	public List<WebElement> allTextBoxes()
	{
		return totalTextboxes;
	}
	
	public void ClickNewPasswordTextBox()
	{
		ApplicationUtils.isClickable(NewPasswordTextBox);
	}
	
	public void ClickRePasswordTextBox()
	{
		ApplicationUtils.isClickable(ReTypePasswordTextBox);
	}
	
	public void setPwd(String pwd)
	{
		ApplicationUtils.enterText(NewPasswordTextBox, pwd);
	}
	
	public void setretypePwd(String retypepwd)
	{
		ApplicationUtils.enterText(ReTypePasswordTextBox, retypepwd);
	}
	
	public void clickSubmitButton()
	{
		ApplicationUtils.isClickable(SubmitButton);
	}
	
	public String printRetrievemsg() 
	{
		return retrievemsg.getText();		
	}
}
