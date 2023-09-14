package StepDefinition;

import org.openqa.selenium.WebDriver;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditUserStep_Def extends BaseClass {
	
	WebDriver driver;
	@Given("The edit icon on row level in data table is enabled in user module")
	public void the_edit_icon_on_row_level_in_data_table_is_enabled_in_user_module() {
		upe.verifyEditIconenable();
	}

	@When("Admin clicks the edit icon in user module")
	public void Admin_clicks_the_edit_icon_in_user_module() {
		upe.ClickEditIcon();
	}

	@Then("A new pop up with User details appears")
	public void a_new_pop_up_with_user_details_appears() throws InterruptedException {
		upe.PopUpAppearance();
	}

	
	@When("Update the fields with valid values and click submit")
	public void Update_the_fields_with_valid_values_and_click_submit() {
		upe.UpdateFields();
	}

	@Then("The updated user details should appear on the data table")
	public void the_updated_user_details_should_appear_on_the_data_table(  ) {
		upe.UpFieldsAppearancce();
	}

	@When("Update the fields with invalid values and click submit")
	public void update_the_fields_with_invalid_values_and_click_submit(String FN, String LN, String Loc) {
		upe.InvalidInputFieldsAndSubmit();
	}

	@Then("Error message should appear")
	public void error_message_should_appear() {
		upe.invalidCredentialMessg();
	}

	@When("Erase data from mandatory field in user module")
	public void Erase_data_from_mandatory_field_in_user_module() {
		upe.deleteUserMandatory();
	}

	@When("Erase data from description field in user module")
	public void Erase_data_from_description_field_in_user_module() {
		upe.deleteUserDescription();
	}

	

}
