package StepDefinition;

import org.testng.Assert;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AddNewAttendanceSD extends BaseClass {
	@Given("Admin clicks the {string} button after reaching the Attendance details popup window")
	public void admin_clicks_the_button_after_reaching_the_attendance_details_popup_window(String string) {
		 log.info("Admin clicks the '" + string + "' button after reaching the Attendance details popup window.");
	        mape.clickButton(string);
	}

	@When("Admin fills all the values and clicks save")
	public void admin_fills_all_the_values_and_clicks_save() {
		log.info("Admin fills all values and clicks save.");
		mape.fillProgramName("Sample Program");
        mape.fillClassName("Sample Class");
        mape.fillStudentName("Sample Student");
        mape.fillAttendance("Present");
        mape.fillAttendanceDate("2023-09-20"); // Example date
      mape.clickSaveButton();
	}

	@Then("Admin should see success message in popup window and sees new attendance details in manage attendance details DB")
	public void admin_should_see_success_message_in_popup_window_and_sees_new_attendance_details_in_manage_attendance_details_db() {
		String successMessage = mape.getSuccessMessage();
        Assert.assertEquals("Success message is not displayed", successMessage.contains("Success"));
        // Implement logic to verify new attendance details in the database
        log.info("Admin sees the success message and new attendance details in the DB.");
    }
	

	@When("Admin fills the values missing and clicks save")
	public void admin_fills_the_values_missing_and_clicks_save() {
		log.info("Admin fills missing values and clicks save.");
       mape.fillProgramName(""); // Example: Leaving Program Name empty
       mape.fillClassName(""); // Example: Leaving Class Name empty
       mape.fillStudentName(""); // Example: Leaving Student Name empty
       mape.fillAttendance(""); // Example: Leaving Attendance empty
       mape.fillAttendanceDate(""); // Example: Leaving Attendance Date empty
       mape.clickSaveButton();
	}

	@Then("Admin should see Invalid attendance date")
	public void admin_should_see_invalid_attendance_date() {
		String errorMessage = mape.getErrorMessage();
        Assert.assertEquals("Invalid attendance date error message is not displayed", errorMessage.contains("Invalid attendance date"));
        log.info("Admin sees the 'Invalid attendance date' error message.");
	}

}
