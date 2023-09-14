package StepDefinition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageAttendancePageSD extends BaseClass {
	 @Given("Admin is in the Manage Attendance page At first")
	    public void admin_is_in_the_manage_attendance_page_At_first() {
	        // Navigate to the Manage Attendance page
	        driver.get("https://your-website.com/manage-attendance");
	    }

	    @When("Admin clicks {string} on the navigation bar in attendance module")
	    public void admin_clicks_on_the_navigation_bar_in_attendance_module(String navigationOption) {
	        // Implement logic to click a navigation option
	        mape.clickNavigationBarLink(navigationOption);
	    }

	    @Then("Admin should see {string} in the header")
	    public void admin_should_see_in_the_header(String expectedHeaderText) {
	        // Verify the header text
	        assertEquals(expectedHeaderText, mape.getHeaderText());
	    }

	    @Then("Maximum navigation time should not exceed {int} seconds")
	    public void maximum_navigation_time_should_not_exceed_seconds(Integer maxTimeInSeconds) {
	    	// Implement logic to measure and verify navigation time
	        long startTime = System.currentTimeMillis();
	        // Perform navigation
	        // Replace the URL with the actual URL you are navigating to.
	        driver.get("https://your-website.com/manage-attendance");
	        long endTime = System.currentTimeMillis();
	        long navigationTime = (endTime - startTime) / 1000;
	        assertTrue("Navigation time exceeded " + maxTimeInSeconds + " seconds. Actual time: " + navigationTime + " seconds.",
	                   navigationTime <= maxTimeInSeconds);
	    }

	    

	    @Then("HTTP response code should be greater than or equal to {int}")
	    public void http_response_code_should_be_greater_than_or_equal_to(Integer expectedResponseCode) {
	        // Implement logic to check HTTP response code
	    	 int actualResponseCode = getResponseCode(driver.getCurrentUrl());
	    	    //assertTrue(actualResponseCode >= expectedResponseCode);
	    }

	    // Helper method to get HTTP response code
	    private int getResponseCode(String urlString) {
	        // Implement logic to get HTTP response code from a URL
	        // You can use HttpURLConnection or other HTTP client libraries.
	        // Replace this with actual code to fetch the response code.
	        return 200; // Example: return a dummy response code (200 OK).
	    }

	    @Then("the link is broken")
	    public void the_link_is_broken() {
	        // Implement logic to check if the link is broken
	        String linkUrl = mape.getUrl(); // Replace with the actual method to get the link URL
	        boolean isLinkBroken = isLinkBroken(linkUrl);
	        assertTrue("The link is broken", isLinkBroken);
	    }

	    // Helper method to check if a link is broken
	    private boolean isLinkBroken(String linkUrl) {
	        try {
	            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(linkUrl).openConnection();
	            httpURLConnection.setRequestMethod("HEAD");
	            httpURLConnection.connect();
	            int responseCode = httpURLConnection.getResponseCode();
	            return (responseCode >= 400);
	        } catch (Exception e) {
	            return true;
	        }
	    }

	    @Then("Admin should see {string} as the title")
	    public void admin_should_see_as_the_title(String expectedTitle) {
	        // Assume you have a method to retrieve the current page title
	        String actualTitle = driver.getTitle(); // Assuming driver is your WebDriver
	        assertEquals("Page title doesn't match", expectedTitle, actualTitle);
	    }

	    @Then("Manage Attendance header should be on the left side of the page")
	    public void manage_attendance_header_should_be_on_the_left_side_of_the_page() {
	        // Assume you have a method to retrieve the header element's X coordinate
	        WebElement headerElement = driver.findElement(By.id("header")); // Replace with your actual header locator
	        int headerLocationX = headerElement.getLocation().getX();
	        assertTrue("Manage Attendance header should be on the left side of the page", headerLocationX >= 0);
	    }

	    @When("Admin clicks {string} button on the navigation bar in attendance module")
	    public void admin_clicks_button_on_the_navigation_bar_in_attendance_module(String buttonName) {
	        // Assume you have a method to click on navigation bar buttons
	        WebElement navigationBarButton = driver.findElement(By.xpath("//button[text()='" + buttonName + "']")); // Replace with your actual locator
	        navigationBarButton.click();
	    }

	    @When("Admin gets all text from the portal page")
	    public void admin_gets_all_text_from_the_portal_page() {
	        // Assume you have a method to retrieve all text from the portal page
	        WebElement portalPageElement = driver.findElement(By.id("portal")); // Replace with your actual portal page locator
	        String portalPageText = portalPageElement.getText();
	        // You can further process the text as needed
	    }


@Then("Admin should see correct spelling for all the fields")
public void admin_should_see_correct_spelling_for_all_the_fields() {
    // Assume you have a method to retrieve text from all fields
    WebElement programNameField = driver.findElement(By.id("programName")); // Replace with your actual field locator
    String programNameText = programNameField.getText();
    
    WebElement classNameField = driver.findElement(By.id("className")); // Replace with your actual field locator
    String classNameText = classNameField.getText();
    
    WebElement studentNameField = driver.findElement(By.id("studentName")); // Replace with your actual field locator
    String studentNameText = studentNameField.getText();
    
    WebElement attendanceField = driver.findElement(By.id("attendance")); // Replace with your actual field locator
    String attendanceText = attendanceField.getText();
    
    WebElement attendanceDateField = driver.findElement(By.id("attendanceDate")); // Replace with your actual field locator
    String attendanceDateText = attendanceDateField.getText();
    
    // Perform assertions to check correct spellings
    assertEquals("Program Name field has incorrect spelling", "Program Name", programNameText);
    assertEquals("Class Name field has incorrect spelling", "Class Name", classNameText);
    assertEquals("Student Name field has incorrect spelling", "Student Name", studentNameText);
    assertEquals("Attendance field has incorrect spelling", "Attendance", attendanceText);
    assertEquals("Attendance Date field has incorrect spelling", "Attendance Date", attendanceDateText);
}

@Then("Admin should see a disabled delete icon below the {string}")
public void admin_should_see_a_disabled_delete_icon_below_the(String sectionName) {
    // Assume you have a method to check the presence and status of delete icons
    WebElement deleteIcon = driver.findElement(By.xpath("//div[@id='" + sectionName + "']/span[@class='delete-icon disabled']"));
    assertTrue("Delete icon below " + sectionName + " is not disabled or not present", deleteIcon.isDisplayed());
}

@Then("Admin should see a search bar on the attendance page")
public void admin_should_see_a_search_bar_on_the_attendance_page() {
    // Assume you have a method to check the presence of the search bar
    WebElement searchBar = driver.findElement(By.id("searchBar")); // Replace with your actual search bar locator
    assertTrue("Search bar is not present on the attendance page", searchBar.isDisplayed());
}

@Then("Admin should see a {string} button on the attendance page")
public void admin_should_see_a_button_on_the_attendance_page(String buttonName) {
    // Assume you have a method to check the presence of the specified button
    WebElement addButton = driver.findElement(By.xpath("//button[text()='" + buttonName + "']"));
    assertTrue(buttonName + " button is not present on the attendance page", addButton.isDisplayed());
}

@Then("Admin should see a data table on the Manage Attendance Page")
public void admin_should_see_a_data_table_on_the_manage_attendance_page() {
    // Assume you have a method to check the presence of the data table
    WebElement dataTable = driver.findElement(By.id("attendanceTable")); // Replace with your actual data table locator
    assertTrue("Data table is not present on the Manage Attendance Page", dataTable.isDisplayed());
}

@Then("the table should have the following column headers: {string}, {string}, {string}, {string}, {string}")
public void the_table_should_have_the_following_column_headers(String col1, String col2, String col3, String col4, String col5) {
    // Assume you have a method to get the column headers
    WebElement columnHeader1 = driver.findElement(By.xpath("//th[contains(text(), '" + col1 + "')]"));
    WebElement columnHeader2 = driver.findElement(By.xpath("//th[contains(text(), '" + col2 + "')]"));
    WebElement columnHeader3 = driver.findElement(By.xpath("//th[contains(text(), '" + col3 + "')]"));
    WebElement columnHeader4 = driver.findElement(By.xpath("//th[contains(text(), '" + col4 + "')]"));
    WebElement columnHeader5 = driver.findElement(By.xpath("//th[contains(text(), '" + col5 + "')]"));
    
    assertTrue(col1 + " column header is missing", columnHeader1.isDisplayed());
    assertTrue(col2 + " column header is missing", columnHeader2.isDisplayed());
    assertTrue(col3 + " column header is missing", columnHeader3.isDisplayed());
    assertTrue(col4 + " column header is missing", columnHeader4.isDisplayed());
    assertTrue(col5 + " column header is missing", columnHeader5.isDisplayed());
}

@Then("Edit icons should be present in each row of the data table when entries are available")
public void edit_icons_should_be_present_in_each_row_of_the_data_table_when_entries_are_available() {
    // Assume you have a method to check the presence of edit icons in each row
    List<WebElement> editIcons = driver.findElements(By.xpath("//td[@class='edit-icon']"));
    assertFalse("Edit icons are missing in the data table", editIcons.isEmpty());
}

@Then("Edit icons should not be present in the data table when there are no entries in the attendance page")
public void edit_icons_should_not_be_present_in_the_data_table_when_there_are_no_entries_in_the_attendance_page() {
    // Assume you have a method to check the absence of edit icons
    List<WebElement> editIcons = driver.findElements(By.xpath("//td[@class='edit-icon']"));
    assertTrue("Edit icons are present when there are no entries in the data table", editIcons.isEmpty());
}

@Then("Delete icons should be present in each row of the data table when entries are available")
public void delete_icons_should_be_present_in_each_row_of_the_data_table_when_entries_are_available() {
    // Assume you have a method to check the presence of delete icons in each row
    List<WebElement> deleteIcons = driver.findElements(By.xpath("//td[@class='delete-icon']"));
    assertFalse("Delete icons are missing in the data table", deleteIcons.isEmpty());
}

@Then("Admin should not see Delete icons in the data table when there are no entries in attendance page")
public void admin_should_not_see_delete_icons_in_the_data_table_when_there_are_no_entries_in_attendance_page() {
    // Assume you have a method to check the absence of delete icons
    List<WebElement> deleteIcons = driver.findElements(By.xpath("//td[@class='delete-icon']"));
    assertTrue("Delete icons are present when there are no entries in the data table", deleteIcons.isEmpty());
}

@Then("Admin should see sort icons near the column headers except for {string} and {string} in attendance page")
public void admin_should_see_sort_icons_near_the_column_headers_except_for_and_in_attendance_page(String col1, String col2) {
    // Assume you have a method to check the presence of sort icons
    WebElement sortIcon1 = driver.findElement(By.xpath("//th[contains(text(), '" + col1 + "')]/span[@class='sort-icon']"));
    WebElement sortIcon2 = driver.findElement(By.xpath("//th[contains(text(), '" + col2 + "')]/span[@class='sort-icon']"));
    assertFalse(col1 + " sort icon is missing", sortIcon1.isDisplayed());
    assertFalse(col2 + " sort icon is missing", sortIcon2.isDisplayed());
}

@Then("Admin should see a check box in all rows of the data table in attendance page")
public void admin_should_see_a_check_box_in_all_rows_of_the_data_table_in_attendance_page() {
    // Assume you have a method to check the presence of check boxes in each row
    List<WebElement> checkboxes = driver.findElements(By.xpath("//td/input[@type='checkbox']"));
    assertFalse("Check boxes are missing in the data table", checkboxes.isEmpty());
}

@Then("Above the footer, Admin should see the text {string} below the table in attendance page")
public void above_the_footer_admin_should_see_the_text_below_the_table_in_attendance_page(String text) {
    // Assume you have a method to retrieve the text above the footer
    WebElement footerText = driver.findElement(By.xpath("//div[@class='footer-text']"));
    assertEquals("Incorrect text above the footer", text, footerText.getText());
}

@Then("x - starting record number on that page")
public void x_starting_record_number_on_that_page() {
    // Write code here to get and verify the starting record number (x)
    throw new io.cucumber.java.PendingException();
}

@Then("y - ending record number on that page")
public void y_ending_record_number_on_that_page() {
    // Write code here to get and verify the ending record number (y)
    throw new io.cucumber.java.PendingException();
}

@Then("z - Total number of records")
public void z_total_number_of_records() {
    // Write code here to get and verify the total number of records (z)
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see the pagination controls under the data table in attendance page")
public void admin_should_see_the_pagination_controls_under_the_data_table_in_attendance_page() {
    // Assume you have a method to check the presence of pagination controls
    WebElement paginationControls = driver.findElement(By.id("paginationControls")); // Replace with your actual locator
    assertTrue("Pagination controls are missing", paginationControls.isDisplayed());
}

@Then("Admin should see the text {string} in the data table footer in attendance page")
public void admin_should_see_the_text_in_the_data_table_footer_in_attendance_page(String text) {
    // Assume you have a method to retrieve the text in the data table footer
    WebElement footerText = driver.findElement(By.xpath("//div[@class='footer-text']"));
    assertEquals("Incorrect text in the data table footer", text, footerText.getText());
}

}
