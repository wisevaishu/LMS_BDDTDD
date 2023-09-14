package StepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;
import io.cucumber.java.en.*;

public class ManageClass_12 extends BaseClass{

    public int displayEntries(int cellToFind)
    {
    	String cellTextEquals = driver.findElement(cpe.searchBar).getText(); 
      wait.until(ExpectedConditions.elementToBeClickable(cpe.table));
      List<WebElement> rows = cpe.table.findElements(By.tagName("tr"));
  	    for (WebElement row : rows) {
  	        List<WebElement> td = row.findElements(By.tagName("td"));
  	        if (td.size() > 0
  	                && td.get(cellToFind).getText().equals(cellTextEquals)) 
  	        {
  	            softAssert.assertTrue(true);
  	        }
  	    }
    	return 0;
    }
	
	
	@Given("Admin is on Manage Class Page")
	public void admin_is_on_manage_class_page() {
	   
		driver.get(classUrl);
		driver.navigate().refresh();
	}

	@When("Admin enters batch id into search box")
	public void admin_enters_batch_id_into_search_box() {
	    driver.findElement(cpe.searchBar).sendKeys("8232");
	}

	@Then("Displays entries with that batch Id")
	public void displays_entries_with_that_batch_id() 
	{
		displayEntries(1);
	}
	
	
	@When("Admin enters batch id which is not existing the table into search box")
	public void admin_enters_batch_id_which_is_not_existing_the_table_into_search_box() {
	    driver.findElement(cpe.searchBar).sendKeys("0001");
	    
	}

	@Then("Displays empty details in the data table")
	public void displays_empty_details_in_the_data_table() {
	      List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
		  size = rows.size();
		  softAssert.assertEquals(size, 0);
	
    }
	
	@When("Admin enters class no into search box")
	public void admin_enters_class_no_into_search_box() {
	    driver.findElement(cpe.searchBar).sendKeys("2");
	}

	@Then("Displays entries with that class no")
	public void displays_entries_with_that_class_no() {
		
			displayEntries(2);	
	}

	@When("Admin enters class no which is not existing the table into search box")
	public void admin_enters_class_no_which_is_not_existing_the_table_into_search_box() {
	    driver.findElement(cpe.searchBar).sendKeys("556");
}

	@When("Admin enters class topic into search box")
	public void admin_enters_class_topic_into_search_box() {
	    driver.findElement(cpe.searchBar).sendKeys("python");

	}

	@Then("Displays entries with that  class topic")
	public void displays_entries_with_that_class_topic() {
	    displayEntries(4);
	}

	@When("Admin enters staff id into search box")
	public void admin_enters_staff_id_into_search_box() {
	    driver.findElement(cpe.searchBar).sendKeys("U01");

	}

	@Then("Displays entries with that  staff id")
	public void displays_entries_with_that_staff_id() {
          displayEntries(5);	   
	}

	@When("Admin enters staff id which is not existing the table into search box")
	public void admin_enters_staff_id_which_is_not_existing_the_table_into_search_box() {
	    driver.findElement(cpe.searchBar).sendKeys("xx");

	}

	@When("Admin enters class date into search box")
	public void admin_enters_class_date_into_search_box() {
	    driver.findElement(cpe.searchBar).sendKeys("12/22/22");

	}

	@Then("Displays entries with that  class date")
	public void displays_entries_with_that_class_date() {
	    displayEntries(3);
	}

	@When("Admin enters invalid class date into search box")
	public void admin_enters_invalid_class_date_into_search_box() {
	    driver.findElement(cpe.searchBar).sendKeys("12/22/3000");

	}
}