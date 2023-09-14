package StepDefinition;

import org.openqa.selenium.WebDriver;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteUserStep_Def extends BaseClass {
	
	WebDriver driver;
	
	

	@Then("Alert appears with yes and No option")
	public void alert_appears_with_yes_and_no_option() {
		upe.verifyDeleteAlert();
	}

	@Given("Admin clicks the delete icon")
	public void Admin_clicks_the_delete_icon() {
		upe.Deleteicon();
	}

	@When("Admin click yes option")
	public void admin_click_yes_option() throws InterruptedException {
		upe.YesBtn();
	}

	@Then("User deleted alert pops and user is no more available in data table")
	public void user_deleted_alert_pops_and_user_is_no_more_available_in_data_table() {
		upe.UserDeletedAlert();
	}

	@When("Admin click No option")
	public void Admin_click_no_option() throws InterruptedException  {
		upe.NoBtn();
	}

	@Then("User is still listed in data table")
	public void user_is_still_listed_in_data_table() {
		upe.UserNotDeleted();
	}
}
