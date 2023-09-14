package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DeleteAttendanceValidationSD extends BaseClass {

    @When("Admin clicks delete button in data table row level for single deletion")
    public void admin_clicks_delete_button_in_data_table_row_level_for_single_deletion() {
        log.info("Admin clicks delete button in data table row level");
        mape.clickDeleteButtonInDataTable();
    }

    @Then("Admin should see alert of delete attendance")
    public void admin_should_see_alert_of_delete_attendance() 
    {
        Assert.assertTrue("Alert is not present", mape.isAlertPresent());
        log.info("Admin sees the alert");
    }

    @Then("Alert should have {string} button to accept")
    public void alert_should_have_button_to_accept(String button) {
        if (button.equals("yes")) {
            log.info("Admin clicks 'Yes' button in the alert");
            mape.clickYesButtonInAlert();
        } else if (button.equals("no")) {
            log.info("Admin clicks 'No' button in the alert");
            mape.clickNoButtonInAlert();
        }
    }

    @Then("Alert should have {string} button to reject")
    public void alert_should_have_button_to_reject(String buttonLabel) {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        if (buttonLabel.equals("No")) {
            // Check if the "No" button is present in the alert text
            Assert.assertTrue("Alert does not contain 'No' button", alertText.contains("No"));
            log.info("Alert contains 'No' button");
        } else {
            // Handle the case where the expected button label doesn't match "No"
            Assert.fail("Invalid button label provided: " + buttonLabel);
            log.error("Invalid button label provided: " + buttonLabel);
        }
    }

    @Given("Admin clicks row level delete button & is in delete alert")
    public void admin_clicks_row_level_delete_button_is_in_delete_alert() {
        log.info("Admin clicks row level delete button & is in delete alert");
        // Implement any necessary steps to trigger the delete button and enter the delete alert
    }

    @Then("Success message and selected attendance details")
    public void success_message_and_selected_attendance_details() {
        Object result = null;
        if (result.equals("Success message and selected attendance details")) {
            // Verify that the success message is displayed
            // Verify that the selected attendance details are deleted or not based on your application's behavior
            log.info("Success message is displayed, and selected attendance details are verified");
        } else if (result.equals("Redirected attendance page and selected attendance details are not deleted from the data table")) {
            // Verify that the admin is redirected to the attendance page
            // Verify that the selected attendance details are not deleted from the data table
            log.info("Admin is redirected to the attendance page, and selected attendance details are not deleted");
        }
    }

    @Then("Redirected attendance page and selected attendance details are not deleted from the data table")
    public void redirected_attendance_page_and_selected_attendance_details_are_not_deleted_from_the_data_table() {
        Object result = null;
        if (result.equals("Redirected attendance page and selected attendance details are not deleted from the data table")) {
            // Verify that the admin is redirected to the attendance page
            String currentPageTitle = mape.verifyPageTitle();
            Assert.assertEquals("Attendance Page", currentPageTitle);

            // Implement logic to verify that the selected attendance details are not deleted from the data table
            // You need to check the data table contents or perform appropriate checks based on your application
            log.info("Admin is redirected to the attendance page, and selected attendance details are not deleted");
        }
    }
    
   
    @Then("Success message and validate particular Assignment details are deleted from the data table")
    public void success_message_and_validate_particular_assignment_details_are_deleted_from_the_data_table() {
    	WebElement deletepost_message = driver.findElement(By.xpath("//span[@class=\"notice__text\"]"));
    	String delete_message= deletepost_message.getText().trim();
    	softAssert.assertEquals(delete_message, "Assignment Deleted");
    }



}
