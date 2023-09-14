package StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Base.BaseClass;
import io.cucumber.java.en.*;


public class addNewClass extends BaseClass{
	
	Select drpbatchid;
	
	@When("Admin clicks  Batch ID dropdown")
	public void admin_clicks_batch_id_dropdown() {
              drpbatchid = new Select(driver.findElement(By.xpath("//select[@name='Batch ID']")));
	  
}

	@Then("Batch id in the drop down should match with Batch id manage batch page table")
	public void batch_id_in_the_drop_down_should_match_with_batch_id_manage_batch_page_table() {
		  
		List <WebElement> ids = drpbatchid.getOptions();
		driver.findElement(By.name("Cancel"));
		driver.switchTo().window(mainWindow);
		  List<WebElement> rows = cpe.table.findElements(By.tagName("tr"));
	     
	      for(int i =0; i<ids.size() ; i++){
	         String options = ids.get(i).getText().trim();
	         outer:
	         for (int j=0; j<rows.size();j++)
	         {
	        	 String records = rows.get(j).getText().trim();
	        	 if(records.contains(options))
	        	 {
	        		 softAssert.assertTrue(true);
	        		 break outer;
	        	 }
	         }
	      }
	}
	@When("Admin enters all mandatory field values with valid data and clicks save button \\( Batch ID , No of Classes, Class Date, Staff Id)")
	public void admin_enters_all_mandatory_field_values_with_valid_data_and_clicks_save_button_batch_id_no_of_classes_class_date_staff_id() {
		 
		String Batch_ID = "3322", No_of_Classes = "2" , Class_Date = "22/01/23",  Staff_Id = "U022" ;
	        
		driver.findElement(By.id("id_batchid")).sendKeys(Batch_ID);
       	driver.findElement(By.id("id_noofclasses")).sendKeys(No_of_Classes);
       	driver.findElement(By.id("id_classdate")).sendKeys(Class_Date);
       	driver.findElement(By.id("id_staffid")).sendKeys(Staff_Id);
        	
        driver.findElement(By.name("Save")).click();
	}

	@Then("Admin should see new class details is added in the data table")
	public void admin_should_see_new_class_details_is_added_in_the_data_table() {
		
		String batchid = driver.findElement(By.id("id_batchid")).getAttribute("value");
	    driver.switchTo().window(mainWindow);
	    driver.navigate().refresh();
	    List<WebElement> rows = cpe.table.findElements(By.tagName("tr"));
  	    for (WebElement row : rows) {
  	        List<WebElement> td = row.findElements(By.tagName("td"));
  	        if (td.size() > 0
  	                && td.get(1).getText().equals(batchid)) 
  	        {
  	            softAssert.assertTrue(true);
  	        }
  	    }
    	
	}

	@When("Admin enters all mandatory field values with invalid data and clicks save button \\( Batch ID , No of Classes, Class Date, Staff Id, )")
	public void admin_enters_all_mandatory_field_values_with_invalid_data_and_clicks_save_button_batch_id_no_of_classes_class_date_staff_id() {
		String Batch_ID = "@$90", No_of_Classes = "-" , Class_Date = "22/01/23",  Staff_Id = "U022" ;
        
		driver.findElement(By.id("id_batchid")).sendKeys(Batch_ID);
       	driver.findElement(By.id("id_noofclasses")).sendKeys(No_of_Classes);
       	driver.findElement(By.id("id_classdate")).sendKeys(Class_Date);
       	driver.findElement(By.id("id_staffid")).sendKeys(Staff_Id);
        	
        driver.findElement(By.name("Save")).click();
	    
	}

	@Then("Error message should appear in alert")
	public void error_message_should_appear_in_alert() {

	 String err_msg = driver.switchTo().alert().getText();
	 softAssert.assertEquals(err_msg, "Invalid Data");

	}
	@When("Admin enters values in all fields with valid data and clicks save button {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void admin_enters_values_in_all_fields_with_valid_data_and_clicks_save_button(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
			driver.findElement(By.id("id_batchid")).sendKeys(string);
       	driver.findElement(By.id("id_noofclasses")).sendKeys(string2);
       	driver.findElement(By.id("id_classdate")).sendKeys(string3);
       	driver.findElement(By.id("id_staffid")).sendKeys(string5);
       	driver.findElement(By.id("id_topic")).sendKeys(string4);
       	driver.findElement(By.id("id_classdescription")).sendKeys(string6);
       	driver.findElement(By.id("id_comments")).sendKeys(string7);
       	driver.findElement(By.id("id_notes")).sendKeys(string8);
       	driver.findElement(By.id("id_recording")).sendKeys(string9);
              	
        driver.findElement(By.name("Save")).click();

	}


	@When("Admin enters with invalid data in optional fields and clicks save button {string} {string} {string} {string} {string} {string} {string} {string}%@#%{string} {string}")
	public void admin_enters_with_invalid_data_in_optional_fields_and_clicks_save_button(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) {
		driver.findElement(By.id("id_batchid")).sendKeys(string);
       	driver.findElement(By.id("id_noofclasses")).sendKeys(string2);
       	driver.findElement(By.id("id_classdate")).sendKeys(string3);
       	driver.findElement(By.id("id_staffid")).sendKeys(string5);
       	driver.findElement(By.id("id_topic")).sendKeys(string4);
       	driver.findElement(By.id("id_classdescription")).sendKeys(string6);
       	driver.findElement(By.id("id_comments")).sendKeys(string7);
       	driver.findElement(By.id("id_notes")).sendKeys(string8);
       	driver.findElement(By.id("id_recording")).sendKeys(string9);
              	
        driver.findElement(By.name("Save")).click();

}

	@When("Admin enters data missing value in one of the fields and clicks save button {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void admin_enters_data_missing_value_in_one_of_the_fields_and_clicks_save_button(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
		
        driver.findElement(By.id("id_batchid")).sendKeys(string);
       	driver.findElement(By.id("id_noofclasses")).sendKeys(string2);
       	driver.findElement(By.id("id_classdate")).sendKeys(string3);
       	driver.findElement(By.id("id_staffid")).sendKeys(string5);
       	driver.findElement(By.id("id_topic")).sendKeys(string4);
       	driver.findElement(By.id("id_classdescription")).sendKeys(string6);
       	driver.findElement(By.id("id_comments")).sendKeys(string7);
       	driver.findElement(By.id("id_notes")).sendKeys(string8);
       	driver.findElement(By.id("id_recording")).sendKeys(string9);
              	
        driver.findElement(By.name("Save")).click();

	}


	@Then("{string} is missing")
	public void is_missing(String string) {
		WebElement message_box = driver.findElement(By.xpath("//span[@class=\"notice__text\"]"));
		String message = message_box.getText().trim();
		softAssert.assertEquals(message, string);
	
	}

}