package StepDefinition;

import org.openqa.selenium.WebDriver;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewBatchSte_Def extends BaseClass {
	      WebDriver driver;
	
	
	
	@Given("A new pop up with Batch details appears")
	public void a_new_pop_up_with_batch_details_appears() {
		bpe.verifyPopUpAppearance();
		log.info("----Popup details can able to see----");
	}

	@Then("The pop up should include the fields Name, Number of classes and Description as text box,Program Name as drop down Status as radio buttonNumber of classes as text box")
	public void the_pop_up_should_include_the_fields_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_status_as_radio_buttonnumber_of_classes_as_text_box() {
	    
	    bpe.verifyPopUpFields();
	}

	@When("Fill in all the fields except description with valid values and click save")
	public void fill_in_all_the_fields_except_description_with_valid_values_and_click_save() {
		bpe.batchFieldsdetails();
	}

	@Then("The newly added batch should be present in the data table in Manage Batch page")
	public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page() {
	    bpe.verifyNewBatchInDataTable();
	}
	@When("Fill in all the fields with valid values and click save")
	public void fill_in_all_the_fields_with_valid_values_and_click_save() {
	    bpe.BatchformfillFields();
	}

	@When("any of the fields have invalid values")
	public void any_of_the_fields_have_invalid_values() {
	    bpe.InvalidValues();
	}

	

	@When("Any of the mandatory fields are blank")
	public void any_of_the_mandatory_fields_are_blank() {
	    bpe.ValidateMissingMandatoryField();
	}
}

	
	
	
