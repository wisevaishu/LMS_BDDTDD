package StepDefinition;

import org.testng.Assert;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class forgotUserPwd extends BaseClass
{
	@Then("Admin should see {string} and {string} in text field")
	public void admin_should_see_and_in_text_field(String elementtext, String symbol) 
	{
		Assert.assertEquals(fup.getEmailText(), elementtext);
		Assert.assertEquals(fup.getEmailText().contains(symbol), elementtext);
		log.info("Admin should see email in text field");
	}

	@Then("Admin Clicks Forgot Username or Password Link")
	public void admin_clicks_forgot_username_or_password_link() 
	{
		lpe.clickForgotUserPwdLink();
		log.info("Admin clicked forgot username or password link");
	}
	
	@When("Admin enter {string}")
	public void admin_enter(String validemail) 
	{
		fup.setEmail(validemail);
		log.info("Admin enter valid email");
	}
	
	@Then("Admin clicks send link button")
	public void admin_clicks_send_link_button() 
	{
		fup.clickSendLinkButton();
		log.info("Admin clicks send link button");
	}

	@Then("Admin should receive link in mail for reset username or password")
	public void admin_should_receive_link_in_mail_for_reset_username_or_password() 
	{
		Assert.assertEquals(lpe.printRetrievemsg(), "Mail Sent for reset username or password");
	}
	
	@Then("Admin should not receive link in mail for reset username or password")
	public void admin_should_not_receive_link_in_mail_for_reset_username_or_password() 
	{
		Assert.assertEquals(lpe.printRetrievemsg(), "Invalid email, Please check you email");
	}

	@Then("Admin lands on forgot username or password page")
	public void admin_lands_on_forgot_username_or_password_page() 
	{
		String TitleOfThePage = au.getTitleOfThePage();
		Assert.assertEquals(TitleOfThePage, "Forgot Username or Password Page");
		log.info("Admin in forgot username or password page");
	}
}
