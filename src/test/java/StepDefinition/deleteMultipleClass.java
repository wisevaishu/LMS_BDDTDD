package StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseClass;
import io.cucumber.java.en.*;

public class deleteMultipleClass extends BaseClass {
	
	String searchId = " ";

	@When("Admin clicks single row level check box in the data table")
	public void admin_clicks_single_row_level_check_box_in_the_data_table() 
	{
	    cpe.checkBoxes.get(0).click();
	}

	@Then("Admin should see delete icon below the header is enabled")
	public void admin_should_see_delete_icon_below_the_header_is_enabled() {
		softAssert.assertTrue(driver.findElement(cpe.deleteButton).isEnabled());
;
		}

	@Then("Admin should see tick mark in check box")
	public void admin_should_see_tick_mark_in_check_box() {
		driver.navigate().refresh();
	    cpe.checkBoxes.get(0).click();

	    softAssert.assertTrue(cpe.checkBoxes.get(0).isSelected());
	}

	@When("Admin clicks multiple row level check box in the data table")
	public void admin_clicks_multiple_row_level_check_box_in_the_data_table() {

		for(int i=0; i<3; i++)
		{
		    cpe.checkBoxes.get(i).click();
		    cpe.deletedRecord = cpe.editIcon.get(i).getText();
		    
		   searchId =  searchId + " " + cpe.extractBatchId(cpe.deletedRecord);
		   searchId = searchId.trim();
      
		}
	}

	@Then("Admin should see tick mark in check box  of the selected rows")
	public void admin_should_see_tick_mark_in_check_box_of_the_selected_rows() {
		for(int i=0; i<3; i++)
		{
		    softAssert.assertTrue(cpe.checkBoxes.get(i).isSelected());

		}
}
	
	@Then("Admin should land on manage class page and validate particular class details are deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_validate_particular_class_details_are_deleted_from_the_data_table() {
		
		driver.navigate().refresh();
		softAssert.assertEquals(driver.getCurrentUrl(),classUrl);
		String[] arrStr = searchId.split(" ", 3);
		for(int i=0; i<3; i++)
		{
			driver.findElement(cpe.searchBar).sendKeys(arrStr[i]); 
			List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
			size = rows.size();
			softAssert.assertEquals(size, 0);
				
		}
		}
	   

	@When("Admin clicks on under the header Delete button after selecting multiple checkboxes")
	public void admin_clicks_on_under_the_header_delete_button_after_selecting_multiple_checkboxes() {
		for(int i=0; i<3; i++)
		{
		   cpe.checkBoxes.get(i).click();
		   cpe.deletedRecord = cpe.editIcon.get(i).getText();
		   //extracting the batch id from selected records
		   searchId =  searchId + " " + cpe.extractBatchId(cpe.deletedRecord);
		   searchId = searchId.trim();
      
		}
		driver.findElement(cpe.deleteButton).click();
	
	}

}
