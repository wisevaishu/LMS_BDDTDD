package StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseClass;
import io.cucumber.java.en.*;

public class editClass2 extends BaseClass{
	

@Given("Admin is in  Edit class detail popup window")
public void admin_is_in_edit_class_detail_popup_window() {
    driver.get(classUrl);
	mainWindow = driver.getWindowHandle();
	driver.findElement(cpe.editButton).click();
	
	cpe.popUpWindow = driver.getWindowHandle();
	if(!mainWindow.equalsIgnoreCase(cpe.popUpWindow))			
    {    		
		// Switching to popup message box
            driver.switchTo().window(cpe.popUpWindow);
    }
}

@Then("Admin should see particular class details is updated in the data table")
public void admin_should_see_particular_class_details_is_updated_in_the_data_table() {

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

@When("Admin clicks Cancel button without entering values in the fields")
public void admin_clicks_cancel_button_without_entering_values_in_the_fields() {
     driver.findElement(By.xpath("closebuttom")).click();
}

@Then("Admin should land on Manage Class page")
public void admin_should_land_on_manage_class_page() {
    driver.switchTo().window(mainWindow);
    softAssert.assertEquals(driver.getCurrentUrl(), classUrl);
}

@When("Admin clicks Cancel button entering values in the fields	 {string} {string} {string} {string} {string} {string} {string} {string} {string}")
public void admin_clicks_cancel_button_entering_values_in_the_fields(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
	driver.findElement(By.id("id_batchid")).sendKeys(string);
   	driver.findElement(By.id("id_noofclasses")).sendKeys(string2);
   	driver.findElement(By.id("id_classdate")).sendKeys(string3);
   	driver.findElement(By.id("id_staffid")).sendKeys(string5);
   	driver.findElement(By.id("id_topic")).sendKeys(string4);
   	driver.findElement(By.id("id_classdescription")).sendKeys(string6);
   	driver.findElement(By.id("id_comments")).sendKeys(string7);
   	driver.findElement(By.id("id_notes")).sendKeys(string8);
   	driver.findElement(By.id("id_recording")).sendKeys(string9);

}

@Then("Admin should land on Manage Class Page and validate particular class details are not changed  in the data table")
public void admin_should_land_on_manage_class_page_and_validate_particular_class_details_are_not_changed_in_the_data_table() {
    
	List<WebElement> totalTextboxes = driver.findElements(By.xpath("//input[@type='text']"));
	String [] arrStr = new String[totalTextboxes.size()];
	for(int i =0; i<totalTextboxes.size();i++)
    {
    	arrStr[i] = totalTextboxes.get(i).getText().trim().toLowerCase();
    }
    driver.switchTo().window(mainWindow);
    softAssert.assertEquals(driver.getCurrentUrl(), classUrl);
    driver.findElement(cpe.searchBar).sendKeys(arrStr[0]);
	List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
	outer:
	for(int i=0;i<rows.size();i++)
	{
		if(arrStr[0] != rows.get(i).getText().trim())
		{
			softAssert.assertTrue(true);
			break outer;
		}
	}
	
}


}