package StepDefinition;

import org.openqa.selenium.WebDriver;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DelMultipleBatchStep_Def  extends BaseClass{
	
	         WebDriver driver;
	@Given("None of the checkboxes in data table are selected")
	public void none_of_the_checkboxes_in_data_table_are_selected() {
	    bpe.verifyNoCheckboxSelected();
	}

	@Then("The delete icon under the {string} header should be disabled")
	public void the_delete_icon_under_the_header_should_be_disabled(String string) {
		bpe.verifyDeleteIconMB();
	}

	@Given("One of the checkbox or row is selected")
	public void one_of_the_checkbox_or_row_is_selected() {
		bpe.checkboxsel();
	}
	@When("Click delete icon below {string} header")
	public void click_delete_icon_below_header(String string) {
			bpe.DeleteIcon();
	}

	@Then("The respective row in the data table is deleted")
	public void the_respective_row_in_the_data_table_is_deleted() {
		bpe.RowTableDel();
	}

	@Given("Two or more checkboxes or row is selected")
	public void two_or_more_checkboxes_or_row_is_selected() {
		bpe.TwoRowsSelected();
	}

}
