package StepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import Base.BaseClass;
import PageObjects.ProgramPageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;

public class AddNewProgram_Step extends BaseClass {



String ProgramName;
String ProgramDescription;

@Given("Admin is on Manage Program Page after clicks Program on the navigation bar")
public void admin_is_on_manage_program_page_after_clicks_program_on_the_navigation_bar() {
   
log.info("Admin is on Manage Program page");
}

@When("Admin clicks {string} button on manage program page")
public void admin_clicks_button_on_manage_program_page(String string) {
 
programPage.ClickAddNewProgram();
}

@Then("Admin should see a popup open for Program Details with empty form along with {string} and {string} button {string} icon on the top right corner")
public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_and_button_icon_on_the_top_right_corner(String string, String string2, String string3) {
   
String TitleOfThePage = au.getTitleOfThePage();
Assert.assertEquals(TitleOfThePage, "Program details");
log.info("Admin is navigate to program details pop up window with empty fiels and Save, Cancel and Close button");
}

@Then("Admin should see two input fields and their respective text boxes in the program details window")
public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() {
 
programPage.ValidateFields();
log.info("Admin is seeing Name and Description and their text boxes");
}

@Then("Admin should see two radio button for Program Status")
public void admin_should_see_two_radio_button_for_program_status() {
 
programPage.ValidateRadioButton();
log.info("Admin is seeing Active and Inactive radio button");
}

@Given("Admin is on Program Details popup window")
public void admin_is_on_program_details_popup_window() {
   
log.info("Admin is on Program Details Popup window");
}

@When("Admin clicks {string} button without entering any data on program details popup")
public void admin_clicks_button_without_entering_any_data_on_program_details_popup(String string) {
 
programPage.ClickSaveButton();
}

@Then("Admin gets a Error Message alert")
public void admin_gets_a_error_message_alert() {
   
programPage.GetErrorMsg();
log.info("Admin is getting error Msg after clicking Save button with all empty fields");
}

@When("Admin enters the sheetname {string} and row number {int} on program")
public void admin_enters_the_sheetname_and_row_number_on_program(String string, Integer int1) throws EncryptedDocumentException, IOException 
{
	ExcelReader reader = new ExcelReader();
	List<Map<String, String>> testdata = reader.getData(excelpath,string);

	ProgramName = testdata.get(int1).get("Name");
	ProgramDescription = testdata.get(int1).get("Description");

	log.info("User Enter Program Name as \" " + ProgramName + " \"and Description as \" " + ProgramDescription);
	if (ProgramName != null || ProgramDescription != null)
	{
			programPage.setProgramName(ProgramName);
				programPage.setProgramDescription(ProgramDescription);
	}
}

@Then("Admin should get a message alert {string} on program details popup")
public void admin_should_get_a_message_alert_on_program_details_popup(String string) {
   
programPage.ClickSaveButton();
programPage.warningName();
log.info("Admin is seeing warning message");
}

@When("Admin enters only {string} in the text box and click {string} button")
public void admin_enters_only_in_the_text_box_and_click_button(String string, String string2) {
   
programPage.ClickSaveButton();
programPage.warningDescription();
log.info("Admin is seeing warning message");
}

@When("Admin selects only {string} and click {string} button on program details popup")
public void admin_selects_only_and_click_button_on_program_details_popup(String string, String string2) {
 
programPage.clickStatus();
programPage.ClickSaveButton();
programPage.warningName();
programPage.warningDescription();

log.info("Admin is seeing warning message");
}

@When ("Admin enters the sheetname {string} and row number {int} on add program")
public void admin_enters_the_sheetname_and_row_number_on_add_program(String string, Integer int1) throws EncryptedDocumentException, IOException {
   
ExcelReader reader = new ExcelReader();
   List<Map<String, String>> testdata = reader.getData(excelpath,string);

ProgramName = testdata.get(int1).get("Name");
ProgramDescription = testdata.get(int1).get("Description");

log.info("User Enter Program Name as \" " + ProgramName + " \"and Description as \" " + ProgramDescription);
if (ProgramName != null || ProgramDescription != null)
{
programPage.setProgramName(ProgramName);
programPage.setProgramDescription(ProgramDescription);
}
}

@Then("Admin gets a Error message alert on program page")
public void admin_gets_a_error_message_alert_on_program_page() {
   
programPage.GetErrorMsg();
log.info("Admin is getting error message");
}

@When("Admin clicks {string} icon on Program Details form")
public void admin_clicks_icon_on_program_details_form(String string) {
 
programPage.clickCloseButton();
}

@Then("Program details popup window should be closed without saving")
public void program_details_popup_window_should_be_closed_without_saving() {
 
String TitleOfThePage = au.getTitleOfThePage();
Assert.assertEquals(TitleOfThePage, "Manage Program");

log.info("Admin redirect to Manage Program page after clicking cancel button without saving");
}

@When ("Admin enters the sheetname {string} and row number {int} on program module")
public void admin_enters_the_sheetname_and_row_number_on_program_module(String string, Integer int1) throws EncryptedDocumentException, IOException {
   
ExcelReader reader = new ExcelReader();
   List<Map<String, String>> testdata = reader.getData(excelpath,string);

ProgramName = testdata.get(int1).get("Name");
ProgramDescription = testdata.get(int1).get("Description");

log.info("User Enter Program Name as \" " + ProgramName + " \"and Description as \" " + ProgramDescription);
if (ProgramName != null || ProgramDescription != null)
{
programPage.setProgramName(ProgramName);
programPage.setProgramDescription(ProgramDescription);
}
}

@Then("Admin gets a message {string} and able to see the new program added on the data table")
public void admin_gets_a_message_and_able_to_see_the_new_program_added_on_the_data_table(String string) {
   
programPage.validateSuccessMessage(string);
programPage.ValidateNewProgram();
log.info("Admin can see successfully add messge");
}

@Then("Admin can see the program details popup disappear without creating any program")
public void admin_can_see_the_program_details_popup_disappear_without_creating_any_program() {
   
programPage.ClickAddNewProgram();
programPage.clickCancelButton();
}
}