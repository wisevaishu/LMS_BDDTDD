package StepDefinition;

import org.openqa.selenium.WebDriver;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class DelMultipleUserStep_Def extends BaseClass {
	      WebDriver driver;
	      
	
	      

	@Then("The delete icon under the {string} header should be disabled in user module")
	public void the_delete_icon_under_the_header_should_be_disabled_in_user_module(String string) {
		upe.VerifyDeleteIconMU();
	}

	@Given("One of the checkbox or row is selected in user module")
	public void One_of_the_checkbox_or_row_is_selected_in_user_module() {
		upe.checkboxselec();
	}
	@When("Click delete icon below header")
	public void click_delete_icon_below_header(String string) {
		upe.clickdeleteicon();
	}

	@Then("The respective row in the data table is deleted in user module")
	public void the_respective_row_in_the_data_table_is_deleted_in_user_module() {
		upe.RowTableDelete();
	}

	@Given("Two or more checkboxes or row is selected in user module")
	public void two_or_more_checkboxes_or_row_is_selected_in_user_module() {
		upe.TwoRowSelected();
	}



}
