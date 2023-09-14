package StepDefinition;

import java.sql.DriverManager;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Base.BaseClass;
import PageObjects.BatchPageValidationEle;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BatchPageValStep_Def extends BaseClass {
	    WebDriver driver;
	     
	@Given("Admin is on LMS dashboard page after login")
	public void admin_is_on_LMS_dashboard_page_after_login()
	{
		
	  driver.get(managebatchurl);
	}
	   
    @When("Admin clicks {string} button from navigation bar")
	public void Admin_clicks_Batch_button_from_navigation_bar(String string) {
		String TitleOfThePage = au.getTitleOfThePage();
		Assert.assertEquals(TitleOfThePage, "ManageBatch Page");
		log.info("Admin in Batch in page");
    }
	@Then("Admin should be able to see {string} page in the LMSApplication")
	public void Admin_should_be_able_to_see_ManageBatch_page_in_the_LMSApplication(String string) {
		bpe.verifyManageBatchTitle();
	   
	}
    @Then("Admin should see the {string} in the header")
	public void admin_should_see_the_in_the_header(String string) {
		bpe.verifyBatchHeader();
	}

	@Then("Admin should see the pagination controls under the data table in batch module")
	public void admin_should_see_the_pagination_controls_under_the_data_table_in_batch_module() {
		//bpe.verifyBatchPageNext();
		bpe.verifyBatchPageNext();
		bpe.verifyBatchPrevious();
	}

	@Then("Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete")
	public void admin_should_see_the_data_table_with_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
		
		bpe.verifyTableHeader();
	   }
	      
    @Then("Admin should be able to see the {string} icon button that is disabled")
	public void admin_should_be_able_to_see_the_icon_button_that_is_disabled(String string) {
    	bpe.verifyDeleteIcon();
	}

	@Then("Admin should be able to see the {string} button")
	public void admin_should_be_able_to_see_the_button(String string) {
		bpe.verifyNewBatch();
	}

	@Then("Each row in the data table should have a checkbox")
	public void each_row_in_the_data_table_should_have_a_checkbox() {
		bpe.verifyCheckBox();
	}

	@Then("Each row in the data table should have a edit icon that is enabled")
	public void Each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
		bpe.verifyEditIcon();
	}
	
	@Then("Each row in the data table should have a delete icon that is enabled")
	public void Each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() {
		bpe.verifyDeleteIcon();
	}
	 

	

	@When("Admin clicks {string} button")
	public void admin_clicks_button(String string) {
		//bpe.clicknewbatch();
	    
	}


}
