package StepDefinition;

import io.cucumber.java.en.Given;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ApplicationUtils;

import org.openqa.selenium.support.Color;
import org.testng.Assert;


import Base.BaseClass;

public class loginSteps extends BaseClass
{	
	@Given("Admin click Login button from Home Page")
	public void admin_click_login_button_from_home_page() 
	{
		hpe.loginButtonClick();
		log.info("Admin clicking login button from home page");
	}

	@Given("Admin in Login Page")
	public void admin_in_login_page() 
	{
		String TitleOfThePage = au.getTitleOfThePage();
		Assert.assertEquals(TitleOfThePage, "Login Page");
		log.info("Admin in log in page");
	}

	@Given("Admin enter ValidUser and Password")
	public void admin_enter_valid_user_and_password() 
	{	
		lpe.setUser(ValidUserName);
		lpe.setPwd(ValidPassword);
		log.info("Admin entering valid username and valid password");
	}
	
	@When("Admin click Login button")
	public void admin_click_login_button() 
	{
		lpe.clickLoginButton();
		log.info("Admin clicking login button in login page");
	}
	
	@Then("Admin lands on Dashboard Page")
	public void admin_lands_on_dashboard_page() 
	{
		String TitleOfThePage = au.getTitleOfThePage();
		Assert.assertEquals(TitleOfThePage, "Dashboard Page");
		log.info("Admin lands on dashboard page");
	}
	
	@Then("Admin see {string} in the header")
	public void admin_see_in_the_header(String LoginHeader) 
	{
		String TitleOfThePage = au.getTitleOfThePage();
		Assert.assertEquals(TitleOfThePage, LoginHeader);
		log.info("Admin lands on Login page and see Header of that page");
	}
	

	@Then("Admin should see correct spellings in all fields in {string}")
	public void admin_should_see_correct_spellings_in_all_fields_in(String modulename) 
	{
		if (modulename=="LoginPage")
		{
			Assert.assertEquals(lpe.getUserText(), "User*");
			Assert.assertEquals(lpe.getPasswordText(), "Password*");
			Assert.assertEquals(lpe.getHeaderLineText(), "Please login to LMS Application");
			Assert.assertEquals(lpe.getLoginButtonText(), "Login");
			Assert.assertEquals(lpe.getForgotUserPwdText(), "Forgot Username or Password");
			Assert.assertEquals(lpe.getResetPwdText(), "Reset Password");
			Assert.assertEquals(lpe.getBottomSpanText(), "Note : UI Screens in this PPT is for ADMIN Role");
			
		}		
		else if (modulename=="ForgotUserPasswordPage") 
		{
			Assert.assertEquals(fup.getEmailText(), "Email*");
			Assert.assertEquals(fup.getForgotUserPwdHeadingText(), "Forgot Username or Password Page*");
			Assert.assertEquals(fup.getLinkButtonText(), "Send Link");
		}
		else if (modulename=="ResetPasswordPage")
		{
			Assert.assertEquals(rpe.getResetPasswordLabelText(), "Reset Password Page");
			Assert.assertEquals(rpe.getSendLinkButtonText(), "Submit");
			Assert.assertEquals(rpe.getTypeInNewPasswordLabelText(), "Type in new password");			
			Assert.assertEquals(rpe.getReTypePasswordText(), "ReType Password");
		}
		log.info("Admin Verified correct spellings in all fields in this" + modulename);
	}
	
	@Then("Admin should see {int} text field in {string} page")
	public void admin_should_see_text_field_in_page(Integer nooftextboxes, String modulename) 
	{
		int totaltextboxes = 0;
		if (modulename=="Login") 
		{
			totaltextboxes=lpe.TotalTextboxesCount();			
		}
		
		else if (modulename=="ResetSubmit") 
		{
			totaltextboxes=rpe.TotalTextboxesCount();			
		}
		
		if (totaltextboxes==nooftextboxes)
		{
			Assert.assertEquals(true,true);	
		}
		else
		{
			Assert.assertEquals(false,false);
		}
		log.info("Admin should validate 2 textboxes");	
	}

	@Then("Admin should see input field on the center of page")
	public void admin_should_see_input_field_on_the_center_of_page() 
	{
		
	}
	
	@Then("Admin should see the {string} button")
	public void admin_should_see_the_button(String buttonname) 
	{
		boolean value = false;
		if (buttonname=="login")
		{
			value=ApplicationUtils.checkVisible(lpe.loginButton);			
		}
		else if (buttonname=="sendlink")
		{
			value=ApplicationUtils.checkVisible(fup.SendLinkButton);
		}
		else if (buttonname=="ResetSubmit") 
		{
			value=ApplicationUtils.checkVisible(rpe.SubmitButton);
		}
		if (value==false)
		{
			Assert.assertEquals(value, false);
			log.info("Admin not able to see login button");
		}		
		else
		{
			Assert.assertEquals(value, true);
			log.info("Admin able to see login button");
		}
	}
		
	@Then("Admin should see forgot username or password link")
	public void admin_should_see_forgot_username_or_password_link() 
	{
		boolean value=ApplicationUtils.checkVisible(lpe.ForgotUserPwdLink);
		if (value==false)
		{
			log.info("Admin not able to see forgot username or password link");
		}
		else
		{
			log.info("Admin able to see forgot username or password link");
		}	
	}

	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() 
	{
		String hex=Color.fromString(lpe.getUserTextcolor()).asHex();
		if (hex=="#808080")
		{
			Assert.assertTrue(true);
			log.info("Admin should see user in gray color");
		}
		else
		{
			Assert.assertTrue(false);
			log.info("Admin seeing other color");
		}		
	}

	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() 
	{
		String hex=Color.fromString(lpe.getPasswordTextcolor()).asHex();
		if (hex=="#808080")
		{
			Assert.assertTrue(true);
			log.info("Admin should see password in gray color");
		}
		else
		{
			Assert.assertTrue(false);
			log.info("Admin seeing other color");
		}
	}	

	@Then("Admin should see {string} in gray color")
	public void admin_should_see_in_gray_color(String elementname) 
	{
		String hex = null;
		if (elementname=="user")
		{
			hex=Color.fromString(lpe.getUserTextcolor()).asHex();
			
		}			
		else if (elementname=="password")
		{
			hex=Color.fromString(lpe.getPasswordTextcolor()).asHex();
		}
		
		else if (elementname=="Email")
		{
			hex=Color.fromString(fup.getEmailTextcolor()).asHex();
		}
		
		if (hex=="#808080")
		{
			Assert.assertTrue(true);
			log.info("Admin should see user in gray color");
		}
		else
		{
			Assert.assertTrue(false);
			log.info("Admin seeing other color");
		}	
	}
	
	//Login Credentials Feature
	@Then("Admin click Home Page Login")
	public void admin_click_home_page_login() 
	{
		hpe.loginButtonClick();
	}
	
	@Given("Admin enter {string} and {string}")
	public void admin_enter_and(String username, String password) 
	{
		if (username.contains("empty"))
		{
			lpe.setUser("");
			lpe.setPwd(password);
		}
		else if (password.contains("empty"))
		{
			lpe.setUser(username);
			lpe.setPwd("");
		}
		else
		{
			lpe.setUser(username);
			lpe.setPwd(password);
		}
	}
	
	@Then("Admin should see {string} in Login Module")
	public void admin_should_see_in_login_module(String errormessages) 
	{
		Assert.assertEquals(lpe.printRetrievemsg(), errormessages);
	}

	@When("Admin click Login button through keyboard")
	public void admin_click_login_button_through_keyboard() 
	{
		lpe.LoginButtonEnterthroughKeyboard();
		log.info("Admin clicked login button through keyboard");
	}
	
	@When("Admin click Login button through Action Click")
	public void admin_click_login_button_through_action_click() 
	{
		 Actions ob = new Actions(driver);
		 ob.click(lpe.loginButton);
	}
	
	
}
