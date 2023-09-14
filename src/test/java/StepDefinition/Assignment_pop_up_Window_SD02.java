package StepDefinition;

import org.openqa.selenium.By;
import org.testng.Assert;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Assignment_pop_up_Window_SD02 extends BaseClass {

	@Given("Admin is on manage assignment Page")
	public void admin_is_on_manage_assignment_page() {
		String TitleOfThePage = au.getTitleOfThePage();
		Assert.assertEquals(TitleOfThePage, "Manage Assignment");
		log.info("Admin is on manage assignment page");
	}

	@When("Admin click +Add new assignment button")
	public void admin_click_add_new_assignment_button() {
	//   dpe.ClickAssignmentBtn();
	}

	@Then("Admin should see a popup  with  heading {string} in assignment module")
	public void admin_should_see_a_popup_with_heading_in_assignment_module(String Expected_heading) {
		String actualHeaderText = ape.get_Pop_Up_header();
		Assert.assertEquals("Popup heading does not match the expected heading", Expected_heading, actualHeaderText);
	//	 driver.switchTo().window(mainWindowHandle);

	}



	@Then("Admin should see  dropdown option for Batch Number")
	public void admin_should_see_dropdown_option_for_batch_number() {
	  boolean isDisplayed = ape.IsVisibleBtachDrpDwn();
	   Assert.assertTrue(isDisplayed);
	}

	@Then("Admin should see  dropdown option for Program name")
	public void admin_should_see_dropdown_option_for_program_name() {
		 boolean isDisplayed = ape.IsVisibleProgramDrpDwn();
		   Assert.assertTrue(isDisplayed);
	}

	@Then("Admin should see  calendar icon for assignment due date")
	public void admin_should_see_calendar_icon_for_assignment_due_date() {
		boolean isDisplayed = ape.IsVisibleCalenderIcon();
		   Assert.assertTrue(isDisplayed);
	}  

	@Then("Admin should see  save button in the Assignment detail popup window")
	public void admin_should_see_save_button_in_the_assignment_detail_popup_window() {
		boolean isDisplayed = ape.searchIsDisplayed();
		   Assert.assertTrue(isDisplayed);
	}

	@Then("Admin should see  cancel button in the Assignment detail popup window")
	public void admin_should_see_cancel_button_in_the_assignment_detail_popup_window() {
		boolean isDisplayed = ape.cancelBtnIsDisplayed();
		   Assert.assertTrue(isDisplayed);
	}

	@Then("Admin should see  close button on the Assignment details popup window")
	public void admin_should_see_close_button_on_the_assignment_details_popup_window() {
		boolean isDisplayed = ape.IsVisibleCloseBtn();
		   Assert.assertTrue(isDisplayed);
	    
	}
	
	@Then("Admin should see input {string} Text")
	public void admin_should_see_input_text(String string) 
	{
		string =  string.trim();
		cpe.popUpWindow = driver.getWindowHandle();
		if(!mainWindow.equalsIgnoreCase(cpe.popUpWindow))			
        {
			driver.switchTo().window(cpe.popUpWindow);	
			String label_text = "//*[contains(text(),'" + string + "')]";
	        softAssert.assertTrue(driver.findElement(By.xpath(label_text)).isDisplayed());			
        }
	}

}
