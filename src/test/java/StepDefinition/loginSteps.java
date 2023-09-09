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

	@Then("Admin in Login Page")
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
}
