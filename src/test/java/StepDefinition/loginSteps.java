package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
	
	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() 
	{
		Assert.assertEquals(lpe.getUserText(), "User*");
		Assert.assertEquals(lpe.getPasswordText(), "Password*");
		Assert.assertEquals(lpe.getHeaderLineText(), "Please login to LMS Application");
		Assert.assertEquals(lpe.getLoginButtonText(), "Login");
		Assert.assertEquals(lpe.getForgotUserPwdText(), "Forgot Username or Password");
		Assert.assertEquals(lpe.getResetPwdText(), "Reset Password");
		Assert.assertEquals(lpe.getBottomSpanText(), "Note : UI Screens in this PPT is for ADMIN Role");
		log.info("Admin Verified correct spellings in all fields");
	}
}
