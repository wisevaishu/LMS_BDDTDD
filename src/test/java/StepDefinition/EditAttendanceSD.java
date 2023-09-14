package StepDefinition;

import org.testng.Assert;

import Base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditAttendanceSD extends BaseClass {
	@When("Admin fills all values with filled and clicks save")
	public void admin_fills_all_values_with_filled_and_clicks_save() {
		log.info("Admin fills all values with filled and clicks save");
        mape.fillProgramName("Sample Program");
        mape.fillClassName("Sample Class");
        mape.fillStudentName("Sample Student");
        mape.fillAttendance("Present");
        mape.fillAttendanceDate("2023-09-20"); // Example date
        mape.clickSaveButton();
	}

	@Then("Admin should see success message and DB")
	public void admin_should_see_success_message_and_db() {
		String successMessage = mape.getSuccessMessage();
        Assert.assertEquals("Success message is not displayed", successMessage.contains("Success"));
        // Implement DB validation as needed
        log.info("Admin sees the success message and DB changes.");
	}

	@When("Admin fills program name with \\(empty) and clicks save")
	public void admin_fills_program_name_with_empty_and_clicks_save() {
		log.info("Admin fills program name with (empty) and clicks save");
        mape.fillProgramName("");
        mape.clickSaveButton();
	}

	@Then("Admin should see Program name is missing")
	public void admin_should_see_program_name_is_missing() {
		String errorMessage = mape.getErrorMessage();
        Assert.assertEquals("Program name missing error message is not displayed", errorMessage.contains("Program name is missing"));
        log.info("Admin sees the 'Program name is missing' error message.");
	}

	@When("Admin fills class name with \\(empty) and clicks save")
	public void admin_fills_class_name_with_empty_and_clicks_save() {
		log.info("Admin fills class name with (empty) and clicks save");
        mape.fillClassName("");
mape.clickSaveButton();
	}

	@Then("Admin should see Class name is missing")
	public void admin_should_see_class_name_is_missing() {
		String errorMessage = mape.getErrorMessage();
        Assert.assertEquals("Class name missing error message is not displayed", errorMessage.contains("Class name is missing"));
        log.info("Admin sees the 'Class name is missing' error message.");
	}

	@When("Admin fills student name with \\(empty) and clicks save")
	public void admin_fills_student_name_with_empty_and_clicks_save() {
		log.info("Admin fills student name with (empty) and clicks save");
       mape.fillStudentName("");
        mape.clickSaveButton();
	}

	@Then("Admin should see Student name is missing")
	public void admin_should_see_student_name_is_missing() {
		String errorMessage = mape.getErrorMessage();
        Assert.assertEquals("Student name missing error message is not displayed", errorMessage.contains("Student name is missing"));
        log.info("Admin sees the 'Student name is missing' error message.");
	}

	@When("Admin fills attendance with \\(empty) and clicks save")
	public void admin_fills_attendance_with_empty_and_clicks_save() {
		log.info("Admin fills attendance with (empty) and clicks save");
        mape.fillAttendance("");
        mape.clickSaveButton();
	}

	@Then("Admin should see Attendance is missing")
	public void admin_should_see_attendance_is_missing() {
		String errorMessage = mape.getErrorMessage();
        Assert.assertEquals("Attendance missing error message is not displayed", errorMessage.contains("Attendance is missing"));
        log.info("Admin sees the 'Attendance is missing' error message.");
	}


	@When("Admin fills attendance date with \\(empty) and clicks save")
	public void admin_fills_attendance_date_with_empty_and_clicks_save() {
		log.info("Admin fills attendance date with (empty) and clicks save");
        mape.fillAttendanceDate("");
        mape.clickSaveButton();
	}


    @Then("Admin should see Attendance date is missing")
    public void admin_should_see_attendance_date_is_missing() {
        String errorMessage = mape.getErrorMessage();
        Assert.assertEquals("Attendance date missing error message is not displayed", errorMessage.contains("Attendance date is missing"));
        log.info("Admin sees the 'Attendance date is missing' error message.");
    }

    @When("Admin fills attendance date with future date and clicks save")
    public void admin_fills_attendance_date_with_future_date_and_clicks_save() {
        log.info("Admin fills attendance date with future date and clicks save");
        mape.fillAttendanceDate("2024-12-31"); // Example future date
        mape.clickSaveButton();
    }

    @Then("Admin should see Invalidate attendance date")
    public void admin_should_see_invalidate_attendance_date() {
        String errorMessage = mape.getErrorMessage();
        Assert.assertEquals("Invalid attendance date error message is not displayed", errorMessage.contains("Invalidate attendance date"));
        log.info("Admin sees the 'Invalidate attendance date' error message.");
    }
}



