package StepDefinition;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Base.BaseClass;
import io.cucumber.java.en.*;

public class deleteClass extends BaseClass
{
	
	String searchId = "";
	
@When("Admin clicks delete button in data table row level")
public void admin_clicks_delete_button_in_data_table_row_level() {
    cpe.deletedRecord = cpe.editIcon.get(0).getText();
   //extracting batch id
    searchId = cpe.extractBatchId(cpe.deletedRecord);
   
}

@Then("Admin should see alert")
public void admin_should_see_alert() {
	try
	{
	    driver.switchTo().alert();
	    softAssert.assertTrue(true);	    
	} catch(NoAlertPresentException e)
	  {
		e.printStackTrace();
	  }
}

@Then("Alert should have yes button to accept")
public void alert_should_have_button_to_accept() {
	
	softAssert.assertTrue(driver.switchTo().activeElement().findElement(cpe.alertYesButton).isDisplayed());
}

@Then("Alert should have No button to reject")
public void alert_should_have_button_to_reject() {
    // Write code here that turns the phrase above into concrete actions
	softAssert.assertTrue(driver.switchTo().activeElement().findElement(cpe.alertNoButton).isDisplayed());

}


@Given("Admin is in delete alert")
public void admin_is_in_delete_alert() {
    driver.get(classUrl);
    cpe.editIcon.get(0).click();
    try
	{
	    driver.switchTo().alert();
	    softAssert.assertTrue(true);	    
	} catch(NoAlertPresentException e)
	  {
		e.printStackTrace();
	  }
}

@When("Admin clicks yes button")
public void admin_clicks_yes_button() 
{
	try
	{
		driver.switchTo().alert().accept();
        softAssert.assertTrue(true);	
	}
	catch(NoAlertPresentException e)
	  {
		e.printStackTrace();
	  }
}

@Then("Success message and validate particular class details are deleted from the data table")
public void success_message_and_validate_particular_class_details_are_deleted_from_the_data_table() {
	WebElement deletepost_message = driver.findElement(By.xpath("//span[@class=\"notice__text\"]"));
	String delete_message= deletepost_message.getText().trim();
	softAssert.assertEquals(delete_message, "Class Deleted");
}

@When("Admin clicks no button")
public void admin_clicks_no_button() {
	try
	{
		driver.switchTo().alert().accept();
        softAssert.assertTrue(true);	
	}
	catch(NoAlertPresentException e)
	  {
		e.printStackTrace();
	  }
	}

@Then("Admin should land on manage class page and validate particular class details are not deleted from the data table")
public void admin_should_land_on_manage_class_page_and_validate_particular_class_details_are_not_deleted_from_the_data_table() 
{
	driver.navigate().refresh();
	driver.findElement(cpe.searchBar).sendKeys(searchId); 
	List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
    size = rows.size();
	softAssert.assertEquals(size, 0);   
}

}
