package StepDefinition;

import org.testng.Assert;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageProgram_Step extends BaseClass 
{
	@Given("Admin is logged on the LMS portal")
	public void admin_is_logged_on_the_lms_portal() 
	{
		programPage.LMSlogin();
		log.info("Admin clicking login button from home page");
	}

	@Given("Admin is on dashboard page after login LMS portal")
	public void admin_is_on_dashboard_page_after_login_lms_portal() 
	{
		log.info("Admin is on dashboard page after login LMS portal");
	}

	@When("Admin clicks {string} on the navigation bar to navigate proram page")
	public void admin_clicks_on_the_navigation_bar_to_navigate_proram_page(String string) 
	{
		programPage.ValidateProgramURL();
	}

	
	@Then("Admin should see URL with \"Manage Program\"	page on program page")
	public void admin_should_see_url_with_manage_program_page_on_program_page() 
	{
		String getURL = driver.getCurrentUrl();
		Assert.assertEquals(getURL, "CurrentUrl");
		log.info("Admin is seeing manage program page along with URL");
	}


	@Then("Admin should see a heading with text {string} on the program page")
	public void admin_should_see_a_heading_with_text_on_the_program_page(String string) 
	{
		programPage.validatePageHeader();
		String Headings = driver.getTitle();
		Assert.assertEquals(Headings, "Manage Program");
		log.info("Admin is seeing page title - Manage Program ");
	}

@Then("Admin should see the text as {string} along with pagination icon below the table on program table")
public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table_on_program_table(String string) {
   
programPage.validatePaginationIcon();
log.info("Admin can see the Pagination Icon with Starting record number,ending record number and Total record number ");
}

@Then("Admin should see the footer as {string} on the manage program page")
public void admin_should_see_the_footer_as_on_the_manage_program_page(String string) {
 
programPage.validateTotalRecords();
log.info("Admin can see Total number Records in pagination icon");

}

@Given("Admin is on dashboard page after login for program page")
public void admin_is_on_dashboard_page_after_login_for_program_page() {
   
log.info("Admin is on Manage Program page after click Program Link");
}

@Then("Admin should see a Delete button on the top left hand side as Disabled on manage program page")
public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled_on_manage_program_page() {
 
programPage.validateDisabledDeleteIcon();
log.info("Admin can able to see the disabled delete button on the left side of the page");
}

@Then("Admin should see a {string} button on the program page above the data table")
public void admin_should_see_a_button_on_the_program_page_above_the_data_table(String string) {
   
programPage.validateAddNewProgram();
log.info("Admin sees the +A New Program icon is displayed on top of the Data table");
}

@Then("Admin should see the number of records \\(rows of data in the table) displayed on the page are {int} on manage program page")
public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are_on_manage_program_page(Integer int1) {
 
programPage.ValidateNumberOfRecords();
log.info("Admin sees 5 Records are displayed on the page");

}

@Then("Admin should see data table on the Manager Program page with following column headers: Program Name,Program Description,Program Status,Edit,Delete")
public void admin_should_see_data_table_on_the_manager_program_page_with_following_column_headers_program_name_program_description_program_status_edit_delete() {
 
programPage.validateHeaders();
String headers = driver.getTitle();
Assert.assertEquals(headers, "Program Name,Program Description,Program Status,Edit,Delete");
log.info("Admin can see the headers of data table");

}

@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
   
programPage.ValidateHeaderSortIcons();
log.info("Admin is validating the sort arrow icon of the column headers");
}

@Then("Admin should see check box on the left side in all rows of the data table on manage program page")
public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table_on_manage_program_page() {
   
programPage.ValidateCheckBox();
log.info("Admin is seeing the check box on the left side of the data table row");
}

@Then("Admin should see the Edit and Delete button on each row of the data table on manage program page")
public void admin_should_see_the_edit_and_delete_button_on_each_row_of_the_data_table_on_manage_program_page() {
 
programPage.ValidateEditDeleteIcon();
     log.info("Admin is seeing the Edit and Delete icon on right side of the data table on each rows");
}

@Then("Admin should see the search bar with text as {string} on manage program page")
public void admin_should_see_the_search_bar_with_text_as_on_manage_program_page(String string) {
 
programPage.ValidateSearchbox();
log.info("Admin sees the search box on top of the data table");
}

@Given("Admin is on Manage Program Page")
public void admin_is_on_manage_program_page() {
 
log.info("Admin is on manage program page");
}

@When("Admin enters {string} in the search box on manage program page")
public void admin_enters_in_the_search_box_on_manage_program_page(String string) {
   
programPage.SearchProgramByName();
}

@Then("Admin should see the programs displayed based on the Program Name")
public void admin_should_see_the_programs_displayed_based_on_the_program_name() {
   
log.info("Admin is seeing the list of program name from the  data table");
}

@Then("Admin should see the programs displayed based on the Program Description")
public void admin_should_see_the_programs_displayed_based_on_the_program_description() {
   
programPage.SearchProgramByDescription();
log.info("Admin is seeing the list of program Description from the  data table ");

}

@Then("Admin should see the programs displayed based on the Program Status")
public void admin_should_see_the_programs_displayed_based_on_the_program_status() {
   
programPage.SearchProgramByStatus();
log.info("Admin is seeing the list of program status from the data table");
}

@When("Admin enters the keywords not present in the data table on the Search box on manage program page")
public void admin_enters_the_keywords_not_present_in_the_data_table_on_the_search_box_on_manage_program_page() {
   
programPage.SearchByInvalidData();
}

@Then("Admin should see Zero enteries on the data table on manage program page")
public void admin_should_see_zero_enteries_on_the_data_table_on_manage_program_page() {
 
log.info("Admin is getting No data found on the data table");
}

}