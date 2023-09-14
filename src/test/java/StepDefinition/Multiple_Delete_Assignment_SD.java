package StepDefinition;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Multiple_Delete_Assignment_SD extends BaseClass{
	String searchId = " ";
	@Given("Admin is on Manage Assignment Page")
	public void admin_is_on_manage_assignment_page() {
	   driver.get(assignmentUrl);
	}

	



}
