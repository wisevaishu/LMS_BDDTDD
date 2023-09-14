package StepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DeleteMultipleAttendanceValidationSD extends BaseClass {

    @Given("Admin is in manage attendance page")
    public void admin_is_in_manage_attendance_page() {
        log.info("Admin is in Manage Attendance page");
        mape.navigateToAttendance();
        String title = mape.verifyPageTitle();
        log.info("Title of current page is : " + title);
        assertEquals(title, "Manage Attendance", "Title does not match");
    }

    @When("Admin clicks single row level checkbox in the data table")
    public void admin_clicks_single_row_level_checkbox_in_the_data_table() {
        mape.clickRowLevelCheckbox(0);
        log.info("Admin clicks single row level checkbox in the data table");
    }

    @Then("Admin should see delete icon below the header is enabled in attendance module")
    public void admin_should_see_delete_icon_below_the_header_is_enabled_in_attendance_module() {
        boolean isDeleteIconEnabled = mape.isDeleteIconEnabled();
        log.info("Admin should see delete icon below the header is enabled: " + isDeleteIconEnabled);

        // Use an assertion to check if it's enabled
        Assert.assertTrue("Delete icon below the header is enabled.", isDeleteIconEnabled);
    }

    @When("Admin clicks multiple row level checkbox in the data table")
    public void admin_clicks_multiple_row_level_checkbox_in_the_data_table() {
        mape.clickMultipleRowLevelCheckboxes();
        log.info("Admin clicks multiple row level checkboxes in the data table");
    }

    @Then("Admin should see tick mark in checkbox")
    public void admin_should_see_tick_mark_in_checkbox() {
        boolean areCheckboxesTicked = mape.areRowLevelCheckboxesTicked();
        log.info("Admin should see tick mark in checkbox: " + areCheckboxesTicked);
    }

    @When("Admin clicks single row level checkboxes in the data table")
    public void admin_clicks_single_row_level_checkboxes_in_the_data_table() {
        mape.clickSingleRowLevelCheckboxes();
        log.info("Admin clicks single row level checkboxes in the data table");
    }

    @Then("Admin should see tick marks in checkboxes of the selected rows")
    public void admin_should_see_tick_marks_in_checkboxes_of_the_selected_rows() {
        boolean areSelectedCheckboxesTicked = mape.areSelectedRowLevelCheckboxesTicked();
        log.info("Admin should see tick marks in checkboxes of the selected rows: " + areSelectedCheckboxesTicked);
    }

    @When("Admin clicks multiple row level checkboxes in the data table")
    public void admin_clicks_multiple_row_level_checkboxes_in_the_data_table() {
        mape.clickMultipleRowLevelCheckboxes();
        log.info("Admin clicks multiple row level checkboxes in the data table");
    }

    @Given("Admin clicks delete button under header after selecting the single checkboxes in the data table & Admin is in delete alert")
    public void admin_clicks_delete_button_under_header_after_selecting_the_single_checkboxes_in_the_data_table_admin_is_in_delete_alert() {
        mape.clickHeaderDeleteButton();
        log.info("Admin clicks delete button under header after selecting the single checkboxes in the data table & Admin is in delete alert");
    }

    @When("Admin clicks yes button of delete alert popup")
    public void admin_clicks_yes_button_of_delete_alert_popup() {
        mape.clickYesButtonInDeleteAlert();
        log.info("Admin clicks yes button");
    }

    @Then("Success message and selected attendance detail are deleted from the data table")
    public void success_message_and_selected_attendance_detail_are_deleted_from_the_data_table() {
        // Implement logic to verify that the success message is displayed
        String successMessage = mape.getSuccessMessage();
        log.info("Success message: " + successMessage);

        // Implement logic to verify that the selected attendance detail is deleted
        // You may need to check the data table contents
    }

    @Given("Admin clicks delete button under header after selecting the multiple checkboxes in the data table & Admin is in delete alert")
    public void admin_clicks_delete_button_under_header_after_selecting_the_multiple_checkboxes_in_the_data_table_admin_is_in_delete_alert() {
        mape.clickHeaderDeleteButton();
        log.info("Admin clicks delete button under header after selecting the multiple checkboxes in the data table & Admin is in delete alert");
    }

    @When("Admin clicks no button from attendance module")
    public void admin_clicks_no_button_from_attendance_module() {
        mape.clickNoButtonInDeleteAlert();
        log.info("Admin clicks no button");
    }

    @Then("Redirected to the attendance page and selected attendance details are not deleted from the data table")
    public void redirected_to_the_attendance_page_and_selected_attendance_details_are_not_deleted_from_the_data_table() {
        // Verify that the admin is redirected to the attendance page
        String currentPageTitle = mape.verifyPageTitle();
        log.info("Current page title: " + currentPageTitle);
        assertEquals("Attendance Page", currentPageTitle); // Update with the actual title

        // Verify that the selected attendance details are not deleted from the data table
        // You can implement logic to check the data table contents
        // For example, check if the attendance details that were selected for deletion are still present
        boolean areSelectedDetailsPresent = mape.areSelectedAttendanceDetailsPresent();
        log.info("Selected attendance details are not deleted from the data table: " + areSelectedDetailsPresent);
    }
}
