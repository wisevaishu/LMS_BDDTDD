package StepDefinition;

import org.testng.Assert;

import Base.BaseClass;
import PageObjects.ProgramPageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultipleDeleteProgram_Step extends BaseClass {

@Given("Admin is in Manage Program Page")
public void admin_is_in_manage_program_page() {
   
log.info("Admin is on Manage Program Page");
}

@When("Admin clicks any checkbox is in data table on manage program page")
public void admin_clicks_any_checkbox_is_in_data_table_on_manage_program_page() {
 
programPage.ValidateDeleteButton();
}

@Then("Admin should see common delete option enabled under header Manage Program")
public void admin_should_see_common_delete_option_enabled_under_header_manage_program() {
   
log.info("Admin sees common delete option enabled under header Manage Program");
}

@Given("Admin is on Confirm Deletion alert on program page")
public void admin_is_on_confirm_deletion_alert_on_program_page() {
   
String TitleOfThePage = au.getTitleOfThePage();
Assert.assertEquals(TitleOfThePage, "Confirm");

log.info("Admin is on Confirm deletion alert");

}

@Then("Admin should land on Manage Program page and can see the selected program is deleted from the data table")
public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_deleted_from_the_data_table() {
   
programPage.DeleteconfirmationAlert();
}

@Then("Admin should land on Manage Program page and can see the selected program is not deleted from the data table")
public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_not_deleted_from_the_data_table() {
   
programPage.DeleteDismissAlert(true);
}

@Then("Admin should land on Manage Program page and can see the selected programs are deleted from the data table")
public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_deleted_from_the_data_table() {
 
programPage.MultiDeletionProgram();
programPage.DeleteconfirmationAlert();
}
}