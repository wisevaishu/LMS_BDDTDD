package StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseClass;
import io.cucumber.java.en.*;

public class classPagination extends BaseClass {


	
	@Then("Data table should display one page  when entries available")
	public void data_table_should_display_one_page_when_entries_available() {
		List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
	    
		if(rows.size()>0)
		{
			softAssert.assertTrue(driver.findElement(By.linkText("1")).isDisplayed());
		}
}

	@Then("Right arrow should be enabled in page one  when entries are more than {int} available")
	public void right_arrow_should_be_enabled_in_page_one_when_entries_are_more_than_available(Integer int1) {

		List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
	    if(rows.size()>5)
		{
			softAssert.assertTrue(driver.findElement(By.linkText(">")).isEnabled());
		}
	}

	@Then("Left arrow should be disabled in page one  when entries are more than {int} available")
	public void left_arrow_should_be_disabled_in_page_one_when_entries_are_more_than_available(Integer int1) {
		List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
	    if(rows.size()>5)
		{
			softAssert.assertTrue(!driver.findElement(By.linkText("<")).isEnabled());
		}    
	}

	@Then("Right arrow should be enabled in page two when entries are more than {int} available")
	public void right_arrow_should_be_enabled_in_page_two_when_entries_are_more_than_available(Integer int1) {
		List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
		if(rows.size()>int1)
		{
			driver.findElement(By.linkText(">")).click();

			softAssert.assertTrue(driver.findElement(By.linkText(">")).isEnabled());
		}    
	}

	@Then("Left arrow should be enabled in page two")
	public void left_arrow_should_be_enabled_in_page_two() {
		List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
	
		if(rows.size()>10)
		{
			driver.findElement(By.linkText(">")).click();
			softAssert.assertTrue(driver.findElement(By.linkText("<")).isEnabled());
		}    
	}

/*	@Then("Data table should display  page {int}  when entries available")
	public void data_table_should_display_page_when_entries_available(Integer int1) {
		List<WebElement> rows = table.findElements(By.xpath(".//tr"));
		
		if(rows.size()>10)
		{
			driver.findElement(By.linkText(">")).click();
			softAssert.assertTrue(driver.findElement(By.linkText("<")).isEnabled());
		}

	}*/

	@Then("entries are more than {int} in data table pagination controls enabled")
	public void entries_are_more_than_in_data_table_pagination_controls_enabled(Integer int1) {
		List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
		
		if(rows.size()>int1)
		{
	    	softAssert.assertTrue(driver.findElement(By.linkText(">>")).isEnabled());

			softAssert.assertTrue(driver.findElement(By.linkText("<<")).isEnabled());
		}    

	}

	@Then("entries are less than {int} in data table pagination controls disabled")
	public void entries_are_less_than_in_data_table_pagination_controls_disabled(Integer int1) {


		List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
		
		if(rows.size()<int1)
		{
	    	softAssert.assertTrue(!driver.findElement(By.linkText(">>")).isEnabled());

			softAssert.assertTrue(!driver.findElement(By.linkText("<<")).isEnabled());
		}    

}
	
	//pagination2
	
	@Given("Admin is in add class details popup window")
	public void admin_is_in_add_class_details_popup_window() {
	    driver.get(classUrl);
	    mainWindow = driver.getWindowHandle();
	  		driver.findElement(cpe.addNewClassButton).click();
	  		cpe.popUpWindow = driver.getWindowHandle();
			if(!mainWindow.equalsIgnoreCase(cpe.popUpWindow))			
	        {    		
				// Switching to popup message box
	                driver.switchTo().window(cpe.popUpWindow);	
	        }
	  		
	}

	@When("Admin creates {int}  new class")
	public void admin_creates_new_class(Integer int1) {
		 String Batch_ID = "3322", No_of_Classes = "2" , Class_Date = "22/01/23",  Staff_Id = "U022" ;
        
		 for(int i=1;i<=int1; i++)
		 {
			driver.findElement(By.id("id_batchid")).sendKeys(Batch_ID);
        	driver.findElement(By.id("id_noofclasses")).sendKeys(No_of_Classes);
        	driver.findElement(By.id("id_classdate")).sendKeys(Class_Date);
        	driver.findElement(By.id("id_staffid")).sendKeys(Staff_Id);
        	
        	driver.findElement(By.name("Save")).click();
        	int id = Integer.valueOf(Batch_ID);
        	id++;
        	Batch_ID = Integer.toString(id);
         }
	}
	@Then("total class entries above {int} next page is enabled \\( On multiples of {int} new page will be enabled)")
	public void total_class_entries_above_next_page_is_enabled_on_multiples_of_new_page_will_be_enabled(Integer int1, Integer int2) {

		List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
		
		if(rows.size()>int1)
		{
			softAssert.assertTrue(driver.findElement(By.linkText(">")).isEnabled());
		}
	}

	@When("Admin creates less than or equal to {int} new class")
	public void admin_creates_less_than_or_equal_to_new_class(Integer int1) {
		 String Batch_ID = "5002", No_of_Classes = "2" , Class_Date = "22/01/23",  Staff_Id = "U022" ;
	       
		 for(int i=1;i<=int1; i++)
		 {
			driver.findElement(By.id("id_batchid")).sendKeys(Batch_ID);
        	driver.findElement(By.id("id_noofclasses")).sendKeys(No_of_Classes);
        	driver.findElement(By.id("id_classdate")).sendKeys(Class_Date);
        	driver.findElement(By.id("id_staffid")).sendKeys(Staff_Id);
        	
        	driver.findElement(By.name("Save")).click();
        	int id = Integer.valueOf(Batch_ID);
        	id++;
        	Batch_ID = Integer.toString(id);
         }
		}

	@Then("total class entries  {int} or below next page is disabled")
	public void total_class_entries_or_below_next_page_is_disabled(Integer int1) {
	
		List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
		
		if(rows.size()>int1)
		{
			softAssert.assertTrue(driver.findElement(By.linkText(">")).isEnabled());
		}
	}
	
}
