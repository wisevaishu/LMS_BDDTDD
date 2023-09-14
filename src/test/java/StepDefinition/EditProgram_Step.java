package StepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;

public class EditProgram_Step extends BaseClass {



String EditName = "Name";
String EditDescription = "Description";

@Given("Admin is on Manage Program page")
public void admin_is_on_manage_program_page() {
   
String TitleOfThePage = au.getTitleOfThePage();
Assert.assertEquals(TitleOfThePage, "Manage Program");
log.info("Admin is on Manage Program page");
}

@When("Admin clicks {string} button on the data table for any row on manage program page")
public void admin_clicks_button_on_the_data_table_for_any_row_on_manage_program_page(String string) {
   
programPage.clickCheckBox();
}

@Then("Admin should see a popup open for Program details to edit")
public void admin_should_see_a_popup_open_for_program_details_to_edit() {

log.info("Admin redirected to Program details popup window");
}

@When("Admin enters the sheetname {string} and row number {int} to edit program")
public void admin_enters_the_sheetname_and_row_number_to_edit_program(String string, Integer int1) throws EncryptedDocumentException, IOException {
   
ExcelReader reader = new ExcelReader();
   List<Map<String, String>> testdata = reader.getData(excelpath,string);

EditName = testdata.get(int1).get("Name");
EditDescription = testdata.get(int1).get("Description");

log.info("User Enter Program Name as \" " + EditName + "User Enter Program Description as \" " + EditDescription);

if (EditName != null || EditDescription != null)
{
programPage.setProgramName(EditName);
programPage.setProgramDescription(EditDescription);
}
}

@Then("Admin gets a message {string} and able to see the update name in the data table for that particular Program")
public void admin_gets_a_message_and_able_to_see_the_update_name_in_the_data_table_for_that_particular_program(String string) {
   
log.info("Admin is able to see the updated name in the data table for that particular data");
}

@Then("Admin gets a message {string} and able to see the update description in the data table for that particular Program")
public void admin_gets_a_message_and_able_to_see_the_update_description_in_the_data_table_for_that_particular_program(String string, Integer int1) throws EncryptedDocumentException, IOException {
   
log.info("Admin is able to see the updated description in the data table for that particular data");
}

@When("Admin change the {string} and clicks {string} button on program details edit popup")
public void admin_change_the_and_clicks_button_on_program_details_edit_popup(String string, String string2) {
   
programPage.clickStatus();
}

@Then("Admin gets a message {string} and able to see the update Status in the data table for that particular Program")
public void admin_gets_a_message_and_able_to_see_the_update_status_in_the_data_table_for_that_particular_program(String string) {
   
log.info("Admin is able to see the updated status in the data table for that particular data");
}

@Then("Admin gets a Error message alert on program details popup window")
public void admin_gets_a_error_message_alert_on_program_details_popup_window() {
   
programPage.GetErrorMsg();
}

@When("Admin clicks {string} button on Program Edit popup")
public void admin_clicks_button_on_program_edit_popup(String string) {
   
programPage.clickCancelButton();
}

@Then("Admin can see the program details popup disappear without creating any program on edit program")
public void admin_can_see_the_program_details_popup_disappear_without_creating_any_program(String string) {
   
String TitleOfThePage = au.getTitleOfThePage();
Assert.assertEquals(TitleOfThePage, "Manage Program");

log.info("Admin redirect to Manage Program page after clicking cancel button without editing");
}
}