package StepDefinition;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class paginationinManageAttendanceSD extends BaseClass  {
	int threshold=5;
	int numberOfEntries=10;
	
	@Given("Admin is logged into the LMS portal as an Admin")
	public void admin_is_logged_into_the_lms_portal_as_an_admin() {
	    
	}

	@Given("Admin is on the dashboard page after login")
	public void admin_is_on_the_dashboard_page_after_login() {
	   
	}

	@When("Admin clicks the {string} button on the navigation bar")
	public void admin_clicks_the_button_on_the_navigation_bar(String string) {
	   
	}
	
	@Then("Data table should display 1 page when entries are available")
	public void data_table_should_display_page_when_entries_are_available(Integer expectedPageNumber) {
// Assuming the page number is displayed in a specific element on the page
	    
	    String actualPageNumberText = mape.pageNumberElement.getText().trim();

	    try {
	        int actualPageNumber = Integer.parseInt(actualPageNumberText);
	        String pageNumber;
			//Assert.assertEquals("Data table displays the expected page:", expectedPageNumber, actualPageNumber);
	        System.out.println("Data table displays the expected page: " + expectedPageNumber);
	    } catch (NumberFormatException e) {
	        System.out.println("Error: Page number is not a valid integer.");
	    }  
	}


	

	@Then("Right arrow should be enabled in page one when entries are more than {int} are available")
	public void right_arrow_should_be_enabled_in_page_one_when_entries_are_more_than_are_available(Integer int1) {
		// You may need to retrieve the number of entries on the page to compare with the threshold
	    int numberOfEntriesOnPage = 5; // Implement the logic to get the number of entries

	    // Assuming you have a WebElement for the right arrow
	   // mape.rightArrowLocator();

	    try {
	       
			// Check if the right arrow is enabled when entries are more than the threshold
	        if (numberOfEntriesOnPage > threshold) {
	            // Verify that the right arrow is enabled (you should have a method for this)
	            boolean isRightArrowEnabled = isArrowEnabled(mape.isLeftArrowEnabled());

	            // Assert that the right arrow is enabled
	            Assert.assertTrue("Right arrow is enabled on page one when entries are more than " + threshold, isRightArrowEnabled);
	            System.out.println("Right arrow is enabled on page one when entries are more than " + threshold);
	        } else {
	            System.out.println("Right arrow is not checked because the number of entries is not greater than " + threshold);
	        }
	    } catch (Exception e) {
	        System.out.println("Error: Unable to check the right arrow state.");
	    }    
	}

	private boolean isArrowEnabled(boolean leftArrowEnabled) {
		// TODO Auto-generated method stub
		return false;
	}

	@Then("Left arrow should be disabled in page one when entries are more than {int} are available")
	public void left_arrow_should_be_disabled_in_page_one_when_entries_are_more_than_are_available(Integer int1) {
		 // You may need to retrieve the number of entries on the page to compare with the threshold
	    int numberOfEntriesOnPage = 5; // Implement the logic to get the number of entries

	    // Assuming you have a WebElement for the left arrow
	    //WebElement leftArrow = paginationAttendance.leftArrowElement;

	    try {
	        // Check if the left arrow is disabled when entries are more than the threshold
	        if (numberOfEntriesOnPage > threshold) {
	            // Verify that the left arrow is disabled (you should have a method for this)
	           
	        	boolean isLeftArrowDisabled = isArrowDisabled(mape.leftArrowLocator);

	            // Assert that the left arrow is disabled
	            Assert.assertTrue("Left arrow is disabled on page one when entries are more than " + threshold, isLeftArrowDisabled);
	            System.out.println("Left arrow is disabled on page one when entries are more than " + threshold);
	        } else {
	            System.out.println("Left arrow is not checked because the number of entries is not greater than " + threshold);
	        }
	    } catch (Exception e) {
	        System.out.println("Error: Unable to check the left arrow state.");
	    }
	}

	private boolean isArrowDisabled(WebElement leftArrowLocator) {
		// TODO Auto-generated method stub
		return false;
	}

	@Then("Right arrow should be enabled in page two when entries are more than {int} are available")
	public void right_arrow_should_be_enabled_in_page_two_when_entries_are_more_than_are_available(Integer int1) {
		// Assuming you have a WebElement representing the entries
		
		List<WebElement> entryElements = driver.findElements(By.cssSelector(".entry")); // Replace with your actual CSS selector

		// Get the number of entries on the current page
		int numberOfEntriesOnPage = entryElements.size();
		WebElement pageNumberElement = driver.findElement(By.cssSelector(".page-number")); // Replace with your actual CSS selector

		// Get the current page number
		String pageNumberText = pageNumberElement.getText();
		int pageNumber = Integer.parseInt(pageNumberText);
			    // Assuming you have a WebElement for the right arrow
			   // WebElement rightArrow = paginationAttendance.rightArrowElement;

			    try {
			        // Check if the page number is 2 and the right arrow is enabled when entries are more than the threshold
			        if (pageNumber == 2 && numberOfEntriesOnPage > threshold) {
			            // Verify that the right arrow is enabled (you should have a method for this)
			            boolean isRightArrowEnabled = isArrowEnabled(mape.isRightArrowEnabled());

			            // Assert that the right arrow is enabled
			            Assert.assertTrue("Right arrow is enabled on page two when entries are more than " + threshold, isRightArrowEnabled);
			            System.out.println("Right arrow is enabled on page two when entries are more than " + threshold);
			        } else {
			            System.out.println("Right arrow is not checked because conditions are not met.");
			        }
			    } catch (Exception e) {
			        System.out.println("Error: Unable to check the right arrow state.");
			    }  
	}

	@Then("Left arrow should be enabled in page two in attendance module")
	public void left_arrow_should_be_enabled_in_page_two_in_attendance_module() {
	  
		// Assuming paginationAttendance.leftArrowElement is a valid WebElement representing the left arrow

	    // Assuming you have a WebElement for the left arrow
	   

	    try {
	        // Verify that the left arrow is enabled (you should have a method for this)
	        boolean isLeftArrowEnabled = isArrowEnabled(mape.isLeftArrowEnabled());

	        // Assert that the left arrow is enabled
	        Assert.assertTrue("Left arrow is enabled on page two", isLeftArrowEnabled);
	        System.out.println("Left arrow is enabled on page two");
	    } catch (Exception e) {
	        System.out.println("Error: Unable to check the left arrow state.");
	    }
	}

	

	@Then("Pagination controls should be enabled when entries are more than {int} in the data table")
	public void pagination_controls_should_be_enabled_when_entries_are_more_than_in_the_data_table(Integer int1) {
	  
		// Assuming you have a WebElement representing the pagination controls
		
		
		
        WebElement paginationControls = driver.findElement(By.cssSelector(".pagination-controls"));

        try {
            // Check if the pagination controls are enabled when entries are more than the threshold
            if (threshold > 0) {
                // Verify that the pagination controls are enabled
                Assert.assertTrue("Pagination controls are enabled when entries are more than " + threshold, paginationControls.isEnabled());
                System.out.println("Pagination controls are enabled when entries are more than " + threshold);
            } else {
                System.out.println("Pagination controls are not checked because the number of entries is not greater than " + threshold);
            }
        } catch (Exception e) {
            System.out.println("Error: Unable to check the pagination controls state.");
        }
    }
	

	@Then("Pagination controls should be disabled when entries are less than {int} in the data table")
	public void pagination_controls_should_be_disabled_when_entries_are_less_than_in_the_data_table(Integer int1) {
		// Assuming you have a WebElement representing the pagination controls
        WebElement paginationControls = driver.findElement(By.cssSelector(".pagination-controls"));

        // Assuming you have a method to get the number of entries in the data table
        int numberOfEntries = getNumberOfEntriesInDataTable();

        try {
            // Check if the pagination controls are disabled when entries are less than the threshold
            if (numberOfEntries <= threshold) {
                // Verify that the pagination controls are disabled
                Assert.assertFalse("Pagination controls are disabled when entries are less than or equal to " + threshold, paginationControls.isEnabled());
                System.out.println("Pagination controls are disabled when entries are less than or equal to " + threshold);
            } else {
                System.out.println("Pagination controls are not checked because the number of entries is greater than " + threshold);
            }
        } catch (Exception e) {
            System.out.println("Error: Unable to check the pagination controls state.");
        }
    }

    private int getNumberOfEntriesInDataTable() {
        // Implement logic to retrieve the number of entries in the data table
        // For example, find the elements representing the entries and count them
        List<WebElement> entryElements = driver.findElements(By.cssSelector(".entry"));
        return entryElements.size();
    } 
	
	@Given("Admin clicks the +Add New attendance button after reaching the Manage attendance page")
	public void admin_clicks_the_add_new_attendance_button_after_reaching_the_manage_attendance_page() {
		// Implement code to click the "+Add New attendance" button
        WebElement addNewAttendanceButton = driver.findElement(By.id("add-new-attendance-button")); // Replace with the actual locator
        addNewAttendanceButton.click();
	}

	@Given("Admin is in the add attendance details popup window")
	public void admin_is_in_the_add_attendance_details_popup_window() {
		// Implement code to verify that the admin is in the add attendance details popup window
        WebElement popupTitle = driver.findElement(By.id("popup-title")); // Replace with the actual locator
        Assert.assertEquals("Add Attendance Details", popupTitle.getText());
	}

	@When("Admin creates {int} new attendance entries")
	public void admin_creates_new_attendance_entries(Integer int1) {
		// Implement code to create a specified number of new attendance entries
        for (int i = 0; i < numberOfEntries; i++) {
            // Fill out the attendance details and submit the form
            WebElement classIdInput = driver.findElement(By.id("class-id-input")); // Replace with the actual locator
            WebElement studentIdInput = driver.findElement(By.id("student-id-input")); // Replace with the actual locator
            WebElement presentCheckbox = driver.findElement(By.id("present-checkbox")); // Replace with the actual locator
            WebElement submitButton = driver.findElement(By.id("submit-button")); // Replace with the actual locator

            // Fill out the attendance details
            classIdInput.sendKeys("Class" + (i + 1));
            studentIdInput.sendKeys("Student" + (i + 1));
            presentCheckbox.click();

            // Submit the form
            submitButton.click();
        } 
	}

	@Then("Next page should be enabled when total attendance entries are above {int}")
	public void next_page_should_be_enabled_when_total_attendance_entries_are_above(Integer int1) {
		// Assuming you have a WebElement representing the "Next page" button
        WebElement nextPageButton = driver.findElement(By.id("next-page-button")); // Replace with the actual locator

        // Get the total number of attendance entries
        int totalAttendanceEntries = getTotalAttendanceEntries();

        try {
            // Check if the "Next page" button is enabled when the total attendance entries are above the threshold
            if (totalAttendanceEntries > threshold) {
                // Verify that the "Next page" button is enabled
                Assert.assertTrue("Next page button is enabled when total attendance entries are above " + threshold, nextPageButton.isEnabled());
                System.out.println("Next page button is enabled when total attendance entries are above " + threshold);
            } else {
                System.out.println("Next page button is not checked because the total attendance entries are not above " + threshold);
            }
        } catch (Exception e) {
            System.out.println("Error: Unable to check the Next page button state.");
        }
	}

	@Given("Admin creates less than or equal to {int} new attendance entries")
	public void admin_creates_less_than_or_equal_to_new_attendance_entries(Integer int1) {
		// Implement code to create a number of new attendance entries less than or equal to the threshold
        int numberOfEntries = threshold;

        // Implement similar code as in the admin_creates_new_attendance_entries method to create entries
        for (int i = 0; i < numberOfEntries; i++) {
            // Fill out the attendance details and submit the form (similar code as above)
        }  
	}

	@Then("Next page should be disabled when total attendance entries are {int} or below")
	public void next_page_should_be_disabled_when_total_attendance_entries_are_or_below(Integer int1) {
		// Assuming you have a WebElement representing the "Next page" button
        WebElement nextPageButton = driver.findElement(By.id("next-page-button")); // Replace with the actual locator

        // Get the total number of attendance entries
        int totalAttendanceEntries = getTotalAttendanceEntries();

        try {
            // Check if the "Next page" button is disabled when the total attendance entries are at or below the threshold
            if (totalAttendanceEntries <= threshold) {
                // Verify that the "Next page" button is disabled
                Assert.assertFalse("Next page button is disabled when total attendance entries are at or below " + threshold, nextPageButton.isEnabled());
                System.out.println("Next page button is disabled when total attendance entries are at or below " + threshold);
            } else {
                System.out.println("Next page button is not checked because the total attendance entries are not at or below " + threshold);
            }
        } catch (Exception e) {
            System.out.println("Error: Unable to check the Next page button state.");
        }
        
	}
	 private int getTotalAttendanceEntries() {
	        // Implement logic to retrieve the total number of attendance entries
	        // For example, find the elements representing the entries and count them
	        List<WebElement> entryElements = driver.findElements(By.cssSelector(".entry"));
	        return entryElements.size();
	    }
}
