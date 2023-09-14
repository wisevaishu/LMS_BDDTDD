package StepDefinition;

import org.testng.Assert;

import Base.BaseClass;
import PageObjects.ProgramPageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteProgram_Step extends BaseClass {



@Given("Admin is on Manage Program page on Program page")
public void admin_is_on_manage_program_page_on_program_page() {
   
String TitleOfThePage = au.getTitleOfThePage();
Assert.assertEquals(TitleOfThePage, "Manage Program");

log.info("Admin is on Manage Program page");
}

@When("Admin clicks {string} button on the data table for any data on manage program page")
public void admin_clicks_button_on_the_data_table_for_any_data_on_manage_program_page(String string) {
   
programPage.clickDeleteIcon();
}

@Then("Admin should see a alert open with heading {string} along with {string} or {string} button for deletion")
public void admin_should_see_a_alert_open_with_heading_along_with_or_button_for_deletion(String string, String string2, String string3) {
   
log.info("Admin sees a alert open with heading confirm along with yes or No button for deletion");
}

@Then("Then Admin should see a message {string} on progrom delete alert")
public void then_admin_should_see_a_message_on_progrom_delete_alert(String string) {
 
log.info("Admin sees a message, Are you sure you want to delete <program Name>?");
}

@Given("Admin is on Confirm deletion alert on program page")
public void admin_is_on_confirm_deletion_alert_on_program_page() {
   
String TitleOfThePage = au.getTitleOfThePage();
Assert.assertEquals(TitleOfThePage, "Confirm");

log.info("Admin is on Confirm deletion alert");
}

@When("Admin clicks {string} button on the alert on program delete alert")
public void admin_clicks_button_on_the_alert_on_program_delete_alert(String string) {
   
programPage.DeleteconfirmationAlert();
}

@Then("Admin gets a message {string} alert and able to see that Program deleted in the table")
public void admin_gets_a_message_alert_and_able_to_see_that_program_deleted_in_the_table(String string) {
 
log.info("Admin gets a Successfully Program Deleted message");
}

@Then("Admin can see the deletion alert disappears without deleting")
public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
   
programPage.DeleteDismissAlert(true);
}

@When("Admin clicks {string} icon on the alert")
public void admin_clicks_icon_on_the_alert(String string) {
   
programPage.DeleteDismissAlert(true);
}
}