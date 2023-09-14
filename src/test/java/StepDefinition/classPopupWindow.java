package StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import Base.BaseClass;
import io.cucumber.java.en.*;

public class classPopupWindow extends BaseClass {
	
	
	
	
	@When("Admin click +Add New Class button")
	public void admin_click_add_new_class_button() 
	{
	    mainWindow = driver.getWindowHandle();
		driver.findElement(cpe.addNewClassButton).click();
	}

	@Then("Admin should see a popup  with  heading {string}")
	public void admin_should_see_a_popup_with_heading(String string) 
	{
		string = string.toLowerCase().trim();
		cpe.popUpWindow = driver.getWindowHandle();
		if(!mainWindow.equalsIgnoreCase(cpe.popUpWindow))			
        {    		
			// Switching to popup message box
                driver.switchTo().window(cpe.popUpWindow);	
                softAssert.assertEquals(driver.getTitle().toLowerCase(), string);
                ////*[contains(text(),'ABC')]
	    }
	}

	@Then("Admin should see {string}")
	public void admin_should_see(String string) {
		
		string =  string.trim();
		cpe.popUpWindow = driver.getWindowHandle();
		if(!mainWindow.equalsIgnoreCase(cpe.popUpWindow))			
        {
			driver.switchTo().window(cpe.popUpWindow);	
			String label_text = "//*[contains(text(),'" + string + "')]";
	        softAssert.assertTrue(driver.findElement(By.xpath(label_text)).isDisplayed());			
        }


	}


	@Then("{int} textbox should be  present in Class details popup window")
	public void textbox_should_be_present_in_class_details_popup_window(Integer int1) {
		
		cpe.popUpWindow = driver.getWindowHandle();
		if(!mainWindow.equalsIgnoreCase(cpe.popUpWindow))			
        {
			driver.switchTo().window(cpe.popUpWindow);	
			List<WebElement> totalTextboxes = driver.findElements(By.xpath("//input[@type='text']"));
		    softAssert.assertEquals(totalTextboxes, int1);
        }
	}

	@Then("Admin should see  dropdown option for Batch ID")
	public void admin_should_see_dropdown_option_for_batch_id() {
		cpe.popUpWindow = driver.getWindowHandle();
		if(!mainWindow.equalsIgnoreCase(cpe.popUpWindow))			
        {
			driver.switchTo().window(cpe.popUpWindow);	
			WebElement dropdown = driver.findElement(By.xpath("//select[@name='Batch ID']"));
			softAssert.assertTrue(dropdown.isDisplayed());
        }
	}

	@Then("Admin should see  dropdown option for Staff Id")
	public void admin_should_see_dropdown_option_for_staff_id() {
		cpe.popUpWindow = driver.getWindowHandle();
		if(!mainWindow.equalsIgnoreCase(cpe.popUpWindow))			
        {
			driver.switchTo().window(cpe.popUpWindow);	
			WebElement dropdown = driver.findElement(By.xpath("//select[@name='Staff ID']"));
			softAssert.assertTrue(dropdown.isDisplayed());
        }
	}

	@Then("Admin should see  calendar icon for class date")
	public void admin_should_see_calendar_icon_for_class_date() {
		cpe.popUpWindow = driver.getWindowHandle();
		if(!mainWindow.equalsIgnoreCase(cpe.popUpWindow))			
        {
			driver.switchTo().window(cpe.popUpWindow);	
		WebElement element = driver.findElement(By.cssSelector("td img#ctl00_cntMainContent_imgStartDate"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		softAssert.assertTrue(true);
        }
		
		   
	}

	@Then("Admin should see  save button in the class detail popup window")
	public void admin_should_see_save_button_in_the_class_detail_popup_window() {
		cpe.popUpWindow = driver.getWindowHandle();
		if(!mainWindow.equalsIgnoreCase(cpe.popUpWindow))			
        {
			driver.switchTo().window(cpe.popUpWindow);	
			driver.findElement(By.name("Save"));
			softAssert.assertTrue(true);
        }
		
	}

	@Then("Admin should see  cancel button in the class detail popup window")
	public void admin_should_see_cancel_button_in_the_class_detail_popup_window() {
		cpe.popUpWindow = driver.getWindowHandle();
		if(!mainWindow.equalsIgnoreCase(cpe.popUpWindow))			
        {
			driver.switchTo().window(cpe.popUpWindow);	
			driver.findElement(By.name("Cancel"));
			softAssert.assertTrue(true);
        }
		}

	@Then("Admin should see  close button on the class details popup window")
	public void admin_should_see_close_button_on_the_class_details_popup_window() {
		cpe.popUpWindow = driver.getWindowHandle();
		if(!mainWindow.equalsIgnoreCase(cpe.popUpWindow))			
        {
			driver.switchTo().window(cpe.popUpWindow);	
			driver.findElement(By.name("Close"));
			softAssert.assertTrue(true);
        }
		
}
}