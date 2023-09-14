package StepDefinition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AttendanceDetailsPopupSD extends BaseClass {
	@When("Admin clicks the {string} button")
	public void admin_clicks_the_button(String buttonName) {
		  if (buttonName.equals("+ Add New Attendance")) {
	            mape.getAddNewAttendanceButton();
	        }
	}

	@Then("Admin should see Correct spellings in the labels")
	public void admin_should_see_correct_spellings_in_the_labels() {
		// Use Selenium WebDriver to locate the labels and their expected spellings.
	    WebElement programLabel = mape.getProgramLabel(); // Replace with actual WebElement locator.
	    WebElement classLabel = mape.getClassLabel();       // Replace with actual WebElement locator.
	    WebElement studentLabel = mape.getStudentLabel(); // Replace with actual WebElement locator.
	    WebElement attendanceLabel = mape.getAttendanceLabel(); // Replace with actual WebElement locator.
	    WebElement dateLabel = mape.getDateLabel();       // Replace with actual WebElement locator.

	    // Define the expected spellings for each label.
	    String expectedProgramLabel = "Program name";
	    String expectedClassLabel = "Class Name";
	    String expectedStudentLabel = "Student Name";
	    String expectedAttendanceLabel = "Attendance";
	    String expectedDateLabel = "Attendance Date";

	    // Verify that the labels have the correct spellings.
	    Assert.assertEquals(expectedProgramLabel, programLabel.getText());
	    Assert.assertEquals(expectedClassLabel, classLabel.getText());
	    Assert.assertEquals(expectedStudentLabel, studentLabel.getText());
	    Assert.assertEquals(expectedAttendanceLabel, attendanceLabel.getText());
	    Assert.assertEquals(expectedDateLabel, dateLabel.getText());
	}

	@Then("Admin should see {int} dropdowns should be present")
	public void admin_should_see_dropdowns_should_be_present(Integer expectedDropdownCount) {
		// Use Selenium WebDriver to locate all dropdown elements on the page.
	    List<WebElement> dropdowns = driver.findElements(By.xpath("//select")); // Replace with your actual locator strategy.

	    // Get the actual count of dropdowns.
	    int actualDropdownCount = dropdowns.size();

	    // Compare the actual count with the expected count.
	    Assert.assertEquals(expectedDropdownCount.intValue(), actualDropdownCount);
	}

	@Then("Admin should see Close button should be present on the popup window")
	public void admin_should_see_close_button_should_be_present_on_the_popup_window() {
	    //WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed.
	    WebElement closeButton = mape.getCloseButton();

	    // Use WebDriverWait to wait for the element to be visible.
	    //wait.until(ExpectedConditions.visibilityOf(closeButton));

	    // Verify that the Close button is present.
	    Assert.assertTrue("Close button should be present on the popup window", closeButton.isDisplayed());
	}

	@Then("Admin should see Close button should be in the top right corner")
	public void admin_should_see_close_button_should_be_in_the_top_right_corner() {
		WebElement closeButton = mape.getCloseButton();

        // Get the position of the Close button relative to the top-left corner of the page.
        Point closeButtonLocation = closeButton.getLocation();

        // Verify that the Close button is in the top right corner (e.g., x-coordinate close to the window width).
        int windowWidth = driver.manage().window().getSize().getWidth();
        int closeButtonX = closeButtonLocation.getX();

        Assert.assertTrue("Close button should be in the top right corner", closeButtonX > windowWidth - 50);
        // You can adjust the value (50 in this case) based on your specific design.
	}

	@Then("Admin should see The first dropdown box should have the text {string}")
	public void admin_should_see_the_first_dropdown_box_should_have_the_text(String expectedText) {
		WebElement programDropdown = mape.getProgramDropdown();

        // Get the selected option's text from the dropdown.
        String actualText = ((Select) programDropdown).getFirstSelectedOption().getText();

        // Verify that the actual text matches the expected text.
        Assert.assertEquals(expectedText, actualText);
	}

	@Then("Admin should see The second dropdown box should have the text {string}")
	public void admin_should_see_the_second_dropdown_box_should_have_the_text(String expectedText) {
		Select classDropdown = mape.getClassDropdown1();

        // Get the selected option's text from the second dropdown.
        String actualText = classDropdown.getFirstSelectedOption().getText();

        // Verify that the actual text matches the expected text.
        Assert.assertEquals(expectedText, actualText);
    
	}

	@Then("Admin should see The third dropdown box should have the text {string}")
	public void admin_should_see_the_third_dropdown_box_should_have_the_text(String expectedText) {
		Select studentDropdown = (Select) mape.getStudentDropdown();

        // Get the selected option's text from the third dropdown.
        String actualText = studentDropdown.getFirstSelectedOption().getText();

        // Verify that the actual text matches the expected text.
        Assert.assertEquals(expectedText, actualText);
	}

	@Then("Admin should see The fourth dropdown box should have the text {string}")
	public void admin_should_see_the_fourth_dropdown_box_should_have_the_text(String expectedText) {
		WebElement attendanceDropdown = mape.getAttendanceDropdown();

        // Get the selected option's text from the fourth dropdown.
        String actualText = ((Select) attendanceDropdown).getFirstSelectedOption().getText();

        // Verify that the actual text matches the expected text.
        Assert.assertEquals(expectedText, actualText);
	}

	@Then("Admin should see Text in gray color")
	public void admin_should_see_text_in_gray_color() {
		WebElement grayTextElement = mape.getGrayTextElement();

        
        //WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed.
        //wait.until(ExpectedConditions.visibilityOf(grayTextElement));

        // Get the CSS color attribute of the element.
        String textColor = grayTextElement.getCssValue("color");

        // Verify that the text color is gray (hex code or rgba value for gray color).
        // You may need to adjust the color value based on your application's styling.
        Assert.assertTrue("Text should be displayed in gray color", isGrayColor(textColor));
	}

	private boolean isGrayColor(String textColor) {
		// TODO Auto-generated method stub
		return false;
	}

	 @Then("Admin should see Save button should be present in the popup window")
	    public void admin_should_see_save_button_should_be_present_in_the_popup_window() {
	        WebElement saveButtonpopup =mape.getSaveButtonpopup();
	        Assert.assertTrue("Save button should be present in the popup window", saveButtonpopup.isDisplayed());
	    }

	    @Then("Admin should see Cancel button should be present in the popup window")
	    public void admin_should_see_cancel_button_should_be_present_in_the_popup_window() {
	        WebElement cancelButton = mape.getCancelButton();
	        Assert.assertTrue("Cancel button should be present in the popup window", cancelButton.isDisplayed());
	    }

	    @Then("Admin should see The order of the labels should be Program name, Class Name, Student Name, Attendance, Attendance Date.")
	    public void admin_should_see_the_order_of_the_labels_should_be_program_name_class_name_student_name_attendance_attendance_date() {
	        // Add logic to retrieve the labels and verify their order.
	        String labelOrder = mape.getLabelOrder(); // You need to implement this method.
	        String expectedLabelOrder = "Program name, Class Name, Student Name, Attendance, Attendance Date";
	        Assert.assertEquals(expectedLabelOrder, labelOrder);
	    }

	    @When("Admin clicks Program Name dropdown")
	    public void admin_clicks_program_name_dropdown() {
	       mape.clickProgramNameDropdown();
	    }

	    @Then("Program Name in the dropdown should match with Program Name in the respective page table")
	    public void program_name_in_the_dropdown_should_match_with_program_name_in_the_respective_page_table() {
	        String selectedProgramName = mape.getSelectedProgramName(); 
	        String programNameInTable = mape.getCurrentPageTitle(); // You need to implement this method.
	        Assert.assertEquals(programNameInTable, selectedProgramName);
	    }
	    @When("Admin clicks Class Name dropdown")
	    public void admin_clicks_class_name_dropdown() {
	       mape.clickClassNameDropdown();
	    }

	    @Then("Class Name in the dropdown should match with Class Name in the respective page table")
	    public void class_name_in_the_dropdown_should_match_with_class_name_in_the_respective_page_table() {
	        String selectedClassName =mape.getSelectedProgramName(); // You need to implement this method.
	        String classNameInTable = mape.getSelectedClassName(); // You need to implement this method.
	        Assert.assertEquals(classNameInTable, selectedClassName);
	    }
	    @When("Admin clicks Attendance dropdown")
	    public void admin_clicks_attendance_dropdown() {
	        mape.getAttendanceDropdown();
	    }

	    @Then("Attendance in the dropdown should match with Attendance in the respective page table")
	    public void attendance_in_the_dropdown_should_match_with_attendance_in_the_respective_page_table() {
	        String selectedAttendance =mape.getSelectedAttendance(); // You need to implement this method.
	        String attendanceInTable = mape.getAttendanceInTable(); // You need to implement this method.
	        Assert.assertEquals(attendanceInTable, selectedAttendance);
	    }

	@Then("the Attendance field should have keywords such as present, absent, late, excused")
	public void the_attendance_field_should_have_keywords_such_as_present_absent_late_excused() {
		String attendanceFieldText = mape.getAttendanceFieldText();
        // Implement logic to check if the attendanceFieldText contains the required keywords.
        String[] keywords = {"present", "absent", "late", "excused"};
        for (String keyword : keywords) {
            Assert.assertTrue("Keyword '" + keyword + "' should be present in the Attendance field text",
                    attendanceFieldText.contains(keyword));
        }
	}

	@Then("Admin should see correct spellings in dropdown text")
	public void admin_should_see_correct_spellings_in_dropdown_text() {
	    
	}
	@When("Admin clicks date from date picker in attendance module")
    public void admin_clicks_date_from_date_picker_in_attendance_module() {
        mape.getDatePicker();
    }

    @Then("the selected date should be in the given format")
    public void the_selected_date_should_be_in_the_given_format() {
        String selectedDate = mape.getSelectedDate();
        // Implement logic to check if selectedDate matches the mm/dd/yyyy format using regular expressions.
        Assert.assertTrue("Selected date should be in mm/dd/yyyy format",
                selectedDate.matches("\\d{2}/\\d{2}/\\d{4}"));
    }
    @When("Admin clicks right arrow arrow in the date picker near month")
    public void admin_clicks_right_arrow_arrow_in_the_date_picker_near_month() {
        mape.clickNextMonthArrow();
    }

    @Then("Next month month calendar should be visible")
    public void next_month_month_calendar_should_be_visible() {
        boolean isNextMonthVisible =  mape.isNextMonthCalendarVisible();
        Assert.assertTrue("Next month calendar should be visible", isNextMonthVisible);
    }
        @When("Admin clicks left arrow arrow in the date picker near month")
        public void admin_clicks_left_arrow_arrow_in_the_date_picker_near_month() {
           mape.clickPreviousMonthArrow();
        }

        @Then("Previous month month calendar should be visible")
        public void previous_month_month_calendar_should_be_visible() {
            boolean isPreviousMonthVisible =mape.isPreviousMonthCalendarVisible();
            Assert.assertTrue("Previous month calendar should be visible", isPreviousMonthVisible);
        }
        @When("Admin clicks date picker button in attendance module")
        public void admin_clicks_date_picker_button_in_attendance_module() {
            mape.clickDatePickerButton();
        }

        @Then("Admin should see the current date highlighted in the date picker")
        public void admin_should_see_the_current_date_highlighted_in_the_date_picker() {
            String currentDate = getCurrentDateInMMddyyyyFormat();
            boolean isDateHighlighted = mape.isDateHighlighted(currentDate);
            Assert.assertTrue("Current date should be highlighted in the date picker", isDateHighlighted);
        }

        @When("Admin clicks date picker button and selects a future date")
        public void admin_clicks_date_picker_button_and_selects_a_future_date() {
            String futureDate = "09/30/2023"; // Replace with the date you want to select.
           mape.selectDateFromDatePicker(futureDate);
        }

        @Then("Admin should see the selected date highlighted in the date picker")
        public void admin_should_see_the_selected_date_highlighted_in_the_date_picker() {
            String selectedDate = "09/30/2023"; // Replace with the date you selected in the previous step.
            boolean isDateHighlighted = mape.isDateHighlighted(selectedDate);
            Assert.assertTrue("Selected date should be highlighted in the date picker", isDateHighlighted);
        }

        private String getCurrentDateInMMddyyyyFormat() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date currentDate = new Date();
            return dateFormat.format(currentDate);
        }

}
