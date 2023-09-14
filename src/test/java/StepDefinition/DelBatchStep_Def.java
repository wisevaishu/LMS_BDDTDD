package StepDefinition;

import org.openqa.selenium.WebDriver;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DelBatchStep_Def extends BaseClass  {
	
	WebDriver driver;
	@Given("The delete icon on row level in data table is enabled")
	public void the_delete_icon_on_row_level_in_data_table_is_enabled() {
		bpe.verifyDeleteicon();
	}

	



	@When("You click yes option")
	public void you_click_yes_option() {
	    bpe.YesBtn();
	}

	@Then("Batch deleted alert pops and batch is no more available in data table")
	public void batch_deleted_alert_pops_and_batch_is_no_more_available_in_data_table() {
		bpe.BatchDeletedAlert();
	}

	@When("you click No option")
	public void you_click_no_option() {
	    bpe.NoBtn();
	}

	@Then("Batch is still listed in data table")
	public void batch_is_still_listed_in_data_table() {
	    bpe.BatchAvailable();
	}


}
