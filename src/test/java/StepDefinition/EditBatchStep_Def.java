package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditBatchStep_Def extends BaseClass {
	
	WebDriver driver;
	
	@Given("The edit icon on row level in data table is enabled")
	public void the_edit_icon_on_row_level_in_data_table_is_enabled() {
		  bpe.verifyEditIcon();
		log.info("----Edit icon is enabled----");
		
	}
	
	@When("Admin clicks the edit icon")
	public void Admin_clicks_the_edit_icon() {
	    bpe.EditiconClick();
	}
	

	

	@When("Update the fields with valid values and click save")
	public void update_the_fields_with_valid_values_and_click_save() {
	    bpe.BatchformfillFields();
	}

	@Then("The updated batch details should appear on the data table in batch module")
	public void the_updated_batch_details_should_appear_on_the_data_table_in_batch_module() {
	    bpe.UpdatedBatchDetails();
	}

	@When("Update the fields with invalid values and click save")
	public void update_the_fields_with_invalid_values_and_click_save() {
	    bpe.InvalidValues();
	}

	@Then("Error message should appear in user module")
	public void error_message_should_appear_in_user_module() {
	    bpe.InvalidErrMsg();
	}

	@When("Erase data from mandatory field")
	public void erase_data_from_mandatory_field() {
	    bpe.deleteMandatory();
	}

	@When("Erase data from description field")
	public void Erase_data_from_description_field() {
	    bpe.deleteDescription();
	}
	@Then("The updated batch details should appear on the data table")
    public void The_updated_batch_details_should_appear_on_the_data_table() {
	bpe.BatchformfillFields();
	log.info("The batch table is displayed with updated details");
	}
	}
