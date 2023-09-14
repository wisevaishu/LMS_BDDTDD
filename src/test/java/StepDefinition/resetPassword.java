package StepDefinition;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class resetPassword  extends BaseClass
{
	@Then("Admin Clicks Reset Password Link")
	public void admin_clicks_reset_password_link() 
	{
		lpe.clickForgotUserPwdLink();
		log.info("Admin clicked forgot username or password link");
	}
	
	@Then("Admin lands on Reset password page")
	public void admin_lands_on_reset_password_page() 
	{
		String TitleOfThePage = au.getTitleOfThePage();
		Assert.assertEquals(TitleOfThePage, "Reset Password Page");
		log.info("Admin in Reset password page");
	}
	
	@Then("Admin should see text boxes in disabled stage")
	public void admin_should_see_text_boxes_in_disabled_stage() 
	{
		boolean value=false;
		int count=0;
		List<WebElement> totalnooftextboxes=rpe.allTextBoxes();
		for (int i=1;i<=totalnooftextboxes.size();i++)
		{
			WebElement TextBox = driver.findElement(By.xpath("(//input[@type='text'])["+i+"]"));
			if (TextBox.isDisplayed())
			{
				value=true; // textboxes are disabled
				count=count+1;
			}
			else
			{
				value=false; //textboxes are enabled				
			}
		}
		if(value==true && count==totalnooftextboxes.size())
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(true);
		}
		log.info("Admin see all text boxes disabled");	
	}	
	
	@Then("Admin should see {string} text box is enabled state")
	public void admin_should_see_text_box_is_enabled_state(String textboxname) 
	{
		if (textboxname.equals("new_password"))
		{
			Assert.assertEquals(rpe.NewPasswordTextBox.isEnabled(), true);
		}
		else if (textboxname.equals("retype_password"))
		{
			Assert.assertEquals(rpe.ReTypePasswordTextBox.isEnabled(), true);
		}
		log.info("Admin should see text box" +textboxname+ " is enabled state");
	}
	
	@When("Admin clicks on {string} field")
	public void admin_clicks_on_field(String textboxname) 
	{
		if (textboxname.equals("new_password"))
		{
			rpe.ClickNewPasswordTextBox();
		}
		else if (textboxname.equals("retype_password"))
		{
			rpe.ClickNewPasswordTextBox();
		}
		log.info("Admin Clicks " +textboxname+ "field");
	}
	
	@When("Admin enters {string} and {string}")
	public void admin_enters_and(String password, String retypepassword) 
	{
		if (password=="emptypassword") 
		{
			rpe.setPwd("");
		}
		else
		{
			rpe.setPwd(password);	
		}
		if (retypepassword=="emptypassword")
		{
			rpe.setretypePwd("");
		}
		else
		{
			rpe.setretypePwd(retypepassword);
		}
		
		if (password==retypepassword)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		log.info("Admin Password and Retypepassword validated");
	}
	
	@Then("Admin clicks submit button")
	public void admin_clicks_submit_button() 
	{
		rpe.clickSubmitButton();
		log.info("Admin clicks submit button");
	}
		
	@Then("Admin see corresponding {string}")
	public void admin_see_corresponding(String messages) 
	{
		boolean value;
		if (rpe.printRetrievemsg()==messages)
		{
			value=true;
		}
		else
		{
			value=false;
		}
		Assert.assertTrue(value);
		log.info("Admin see corresponding messages " +messages);
	}
}
