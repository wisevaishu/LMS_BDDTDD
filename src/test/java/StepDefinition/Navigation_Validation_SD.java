package StepDefinition;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Navigation_Validation_SD extends BaseClass{
	@Given("Admin is on Manage assignment Page")
	public void admin_is_on_manage_assignment_page() {
	    driver.getCurrentUrl();
	}

	

}
