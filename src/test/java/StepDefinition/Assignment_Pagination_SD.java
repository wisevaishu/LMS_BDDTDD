package StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Assignment_Pagination_SD extends BaseClass {
//	@Given("The Admin is on dashboard page after Login")
//	public void the_admin_is_on_dashboard_page_after_login() {
//	   driver.get(dashboardUrl);
//	}

	@When("Admin clicks Assigmment button on the navigation bar")
	public void admin_clicks_assigmment_button_on_the_navigation_bar() {
	    ape.clickAssgnmentBtn();
	}

	@Then("Data table should display one page  when entries available in assignment module")
	public void data_table_should_display_one_page_when_entries_available_in_assignment_module() {
List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
	    
		if(rows.size()>0)
		{
			softAssert.assertTrue(driver.findElement(By.linkText("1")).isDisplayed());
		}
	}

	@Then("Right arrow should be enabled in page one  when entries are more than {int} available in assignment module")
	public void right_arrow_should_be_enabled_in_page_one_when_entries_are_more_than_available_in_assignment_module(Integer int1) {
		List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
	    if(rows.size()>5)
		{
			softAssert.assertTrue(driver.findElement(By.linkText(">")).isEnabled());
		}
	}

	@Then("Left arrow should be disabled in page one  when entries are more than {int} available in assignment module")
	public void left_arrow_should_be_disabled_in_page_one_when_entries_are_more_than_available_in_assignment_module(Integer int1) {
		List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
	    if(rows.size()>5)
		{
			softAssert.assertTrue(!driver.findElement(By.linkText("<")).isEnabled());
		}  
	}

	@Then("Right arrow should be enabled in page two when entries are more than {int} available in assignment module")
	public void right_arrow_should_be_enabled_in_page_two_when_entries_are_more_than_available_in_assignment_module(Integer int1) {
		List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
		if(rows.size()>int1)
		{
			driver.findElement(By.linkText(">")).click();

			softAssert.assertTrue(driver.findElement(By.linkText(">")).isEnabled());
		}    
	}

	@Then("Left arrow should be enabled in page two in assignment module")
	public void left_arrow_should_be_enabled_in_page_two_in_assignment_module() {
		List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
		
		if(rows.size()>10)
		{
			driver.findElement(By.linkText(">")).click();
			softAssert.assertTrue(driver.findElement(By.linkText("<")).isEnabled());
		}  
	}

	@Then("entries are more than {int} in data table pagination controls enabled in assignment module")
	public void entries_are_more_than_in_data_table_pagination_controls_enabled_in_assignment_module(Integer int1) {
List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
		
		if(rows.size()>int1)
		{
	    	softAssert.assertTrue(driver.findElement(By.linkText(">>")).isEnabled());

			softAssert.assertTrue(driver.findElement(By.linkText("<<")).isEnabled());
		}    
	}

	@Then("entries are less than {int} in data table pagination controls disabled in assignment module")
	public void entries_are_less_than_in_data_table_pagination_controls_disabled_in_assignment_module(Integer int1) {
List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
		
		if(rows.size()<int1)
		{
	    	softAssert.assertTrue(!driver.findElement(By.linkText(">>")).isEnabled());

			softAssert.assertTrue(!driver.findElement(By.linkText("<<")).isEnabled());
		}    
	}
// Pagination 2 
	
	@Given("Admin is in add assignment details popup window")
	public void admin_is_in_add_assignment_details_popup_window() {
		driver.get(assignmentURL);
	    mainWindow = driver.getWindowHandle();
	  		driver.findElement(ape.addNewAssignmentButton).click();
	  		cpe.popUpWindow = driver.getWindowHandle();
			if(!mainWindow.equalsIgnoreCase(cpe.popUpWindow))			
	        {    		
				// Switching to popup message box
	                driver.switchTo().window(cpe.popUpWindow);	
	        }
	}

	@When("Admin creates {int} new assignment")
	public void admin_creates_new_assignment(Integer int1) {
		String program_name = "Sep23-seleniumWinner-SDET-222", batch_number = "55" , Assignment_name = "API",  Assignment_description = "API restAssured" ;
		for(int i=1;i<=int1; i++)
		 {
			driver.findElement(By.id("program_name")).sendKeys(program_name);
       	driver.findElement(By.id("batch_number")).sendKeys(batch_number);
       	driver.findElement(By.id("Assignment_name")).sendKeys(Assignment_name);
       	driver.findElement(By.id("Assignment_description")).sendKeys(Assignment_description);
       	
       	driver.findElement(By.name("Save")).click();
       	int id = Integer.valueOf(batch_number);
       	id++;
       	batch_number = Integer.toString(id);
        }
	}
	@Then("In this case total class entries above {int} next page is enabled \\( On multiples of {int} new page will be enabled)")
	public void in_this_case_total_class_entries_above_next_page_is_enabled_on_multiples_of_new_page_will_be_enabled(Integer int1, Integer int2) {
List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
		
		if(rows.size()>int1)
		{
			softAssert.assertTrue(driver.findElement(By.linkText(">")).isEnabled());
		}
	}

	@When("Admin creates less than or equal to {int} new  assignment")
	public void admin_creates_less_than_or_equal_to_new_assignment(Integer int1) {
		String program_name = "Sep23-seleniumWinner-SDET-22", batch_number = "22" , Assignment_name = "xyz",  Assignment_description = "wwww" ;
	       
		 for(int i=1;i<=int1; i++)
		 {
			driver.findElement(By.id("program_name")).sendKeys(program_name);
       	driver.findElement(By.id("batch_number")).sendKeys(batch_number);
       	driver.findElement(By.id("Assignment_name")).sendKeys(Assignment_name);
       	driver.findElement(By.id("Assignment_description")).sendKeys(Assignment_description);
       	
       	driver.findElement(By.name("Save")).click();
       	int id = Integer.valueOf(batch_number);
       	id++;
       	batch_number = Integer.toString(id);
        }
	}

	@Then("In this case entries are less than {int} in data table pagination controls disabled")
	public void in_this_case_entries_are_less_than_in_data_table_pagination_controls_disabled(Integer int1) {
List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
		
		if(rows.size()>int1)
		{
			softAssert.assertTrue(driver.findElement(By.linkText(">")).isEnabled());
		}
	}

}
