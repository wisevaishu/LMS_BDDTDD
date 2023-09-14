
package StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseClass;
import io.cucumber.java.en.*;

public class editClass1 extends BaseClass{
	
	String record_text;
	
	@When("Admin clicks Edit button in data table")
	public void admin_clicks_edit_button_in_data_table() {
		mainWindow = driver.getWindowHandle();
		
		driver.findElement(cpe.editButton).click();

	}

	@Then("Edit popup window appears with heading Class Details")
	public void edit_popup_window_appears_with_heading_class_details() {
		cpe.popUpWindow = driver.getWindowHandle();
		if(!mainWindow.equalsIgnoreCase(cpe.popUpWindow))			
        {    		
			// Switching to edit popup message box
                driver.switchTo().window(cpe.popUpWindow);	
                softAssert.assertEquals(driver.getTitle().toLowerCase(), "class details");
	    }
		
	}

	@When("Admin clicks Edit button from one of the row in data table")
	public void admin_clicks_edit_button_from_one_of_the_row_in_data_table() {
        
		record_text = cpe.editIcon.get(0).getText().trim();
		mainWindow = driver.getWindowHandle();
		cpe.editIcon.get(0).click();

	}

	@Then("Edit popup window appears with same row values in the all fields")
	public void edit_popup_window_appears_with_same_row_values_in_the_all_fields() {
		cpe.popUpWindow = driver.getWindowHandle();
		String[] arrStr = record_text.split("  ", 9);
		
		if(!mainWindow.equalsIgnoreCase(cpe.popUpWindow))			
        {    		
			// Switching to edit popup message box
                driver.switchTo().window(cpe.popUpWindow);
                List<WebElement> totalTextboxes = driver.findElements(By.xpath("//input[@type='text']"));
                for(int i=0;i<9;i++)
                {
                	String txt_value = totalTextboxes.get(i).getAttribute("value").trim().toLowerCase();
                	softAssert.assertEquals(txt_value,arrStr[i].trim().toLowerCase());
                }
                  
	    }
		
	}
}