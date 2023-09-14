
package StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseClass;
import io.cucumber.java.en.*;

public class addNewClass2 extends BaseClass {
	
	public void selectDate(String month_year, String select_day) throws InterruptedException
	{ 
	List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[1]"));

	for (int i=0; i<elements.size();i++)
	{
	System.out.println(elements.get(i).getText());

	//Selecting the month
	if(elements.get(i).getText().equals(month_year))
	{ 

	//Selecting the date 
	List<WebElement> days = driver.findElements(By.xpath("//div[@class='ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-datepicker-multi ui-datepicker-multi-2']/div[2]/table/tbody/tr/td/a"));

	for (WebElement d:days)
	{ 
	System.out.println(d.getText());
	if(d.getText().equals(select_day))
		{
			d.click();
			Thread.sleep(10000);
			return;
		}
	}
	}
	}
	driver.findElement(By.xpath("//div[@class='ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-datepicker-multi ui-datepicker-multi-2']/div[2]/div/a/span")).click();
	selectDate(month_year,select_day);
	}
	
	@When("Admin clicks date from date picker")
	public void admin_clicks_date_from_date_picker() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("selected date should be their in class date text box")
	public void selected_date_should_be_their_in_class_date_text_box() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("selected date should be in  mm\\/dd\\/yyyy format")
	public void selected_date_should_be_in_mm_dd_yyyy_format() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks right arrow in the date picker near month")
	public void admin_clicks_right_arrow_in_the_date_picker_near_month() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Next month calender should visible")
	public void next_month_calender_should_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks left arrow in the date picker near month")
	public void admin_clicks_left_arrow_in_the_date_picker_near_month() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("previous month calender should visible")
	public void previous_month_calender_should_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks date picker button")
	public void admin_clicks_date_picker_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see current date is highled in the date picker")
	public void admin_should_see_current_date_is_highled_in_the_date_picker() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks date picker button and selects future date")
	public void admin_clicks_date_picker_button_and_selects_future_date() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see selected date is highled in the date picker")
	public void admin_should_see_selected_date_is_highled_in_the_date_picker() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks Cancel button entering values in the fields")
	public void admin_clicks_cancel_button_entering_values_in_the_fields() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should land on Manage Class Page and validate new class is not created in the data table")
	public void admin_should_land_on_manage_class_page_and_validate_new_class_is_not_created_in_the_data_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}