package StepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationFunctionValidationAttendanceToOtherSD extends BaseClass {     
	
@Given("Admin is on the Manage Attendance page after login")
	public void admin_is_on_the_manage_attendance_page_after_login() {
		log.info("Admin is on the Manage Attendance page");
		mape.navigateToAttendance();
		String Title = mape.verifyPageTitle();
		log.info("Title of current page is : " + Title);
		assertEquals(Title, "Manage Attendance", "Title do not match");
	}
	
	@When("Admin clicks the {string} button in the navigation bar")
	public void admin_clicks_the_button_in_the_navigation_bar(String page) {
	    switch (page) {
	        case "Student":
	        	mape.navigateToStudent();
	            break;
	        case "Program":
	        	mape.navigateToProgram();
	            break;
	        case "Batch":
	        	mape.navigateToBatch();
	            break;
	        case "User":
	        	mape.navigateToUser();
	            break;
	        case "Assignment":
	        	mape.navigateToAssignment();
	            break;
	        case "Class":
	        	mape.navigateToclass();
	            break;
	        default:
	            throw new IllegalArgumentException("Unsupported page: " + page);
	    }
	}

	@Then("Admin should be able to land on the {string} page")
	public void admin_should_be_able_to_land_on_the_page(String string) {
		// Check if the Admin has landed on the expected page. You can validate this using assertions.
        String currentPageTitle = mape.verifyPageTitle();
        assertEquals(currentPageTitle,string, "Admin did not land on the expected page.");
	   
	}

	@When("Admin clicks the Logout  button in the navigation bar")
	public void admin_clicks_the_logout_button_in_the_navigation_bar() {
		 // Click the Logout button
		mape.navigateToLogout();
	}

	@Then("Admin should be able to land on the Login page")
	public void admin_should_be_able_to_land_on_the_login_page() {
		
        boolean isLoginPage = mape.verifyPageTitle() != null;
        assertTrue(isLoginPage, "Admin did not land on the Login page after logout.");
	}
}



	

	
