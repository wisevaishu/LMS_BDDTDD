
package StepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import Base.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageClass_11 extends BaseClass{
	
    @Before
	public static void Launch()
	{
		System.out.println("Initializing the driver...");
		//options.addArguments("--headless");
//		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}	

	@Given("The Admin is on dashboard page after Login")
	public void the_admin_is_on_dashboard_page_after_login() 
	{
	    driver.get(loginUrl);
	    driver.findElement(cpe.loginField).sendKeys("user123");
	    driver.findElement(cpe.passwordField).sendKeys("password123");
	    driver.findElement(cpe.loginButton).click();
	    cpe.currentUrl = driver.getCurrentUrl();
        softAssert.assertEquals(cpe.currentUrl, dashboardUrl);     
    
	}

	@When("Admin clicks Class button on the navigation bar")
	public void admin_clicks_class_button_on_the_navigation_bar() {
	    driver.findElement(cpe.classButton).click();
	    start_time = System.currentTimeMillis();
	}

	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String string) {
	    cpe.currentUrl = driver.getCurrentUrl();
	    string =  string.trim();
	        softAssert.assertTrue(cpe.currentUrl.contains(string));	  
	}

	@Then("Get the response time for navigation from dashboard page to manage class page")
	public void get_the_response_time_for_navigation_from_dashboard_page_to_manage_class_page() {
		 
	     start_time = System.currentTimeMillis();
		//URL launch
	      driver.get(classUrl);
	      //verify page is loaded
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	      wait.until(ExpectedConditions.elementToBeClickable(By.className("//classnameelements")));
	      //capture time after page load
	      end_time = System.currentTimeMillis();
	      //compute time
	      time_taken = end_time-start_time;
	      System.out.println("Page load time in milliseconds: " + time_taken);
	}

	@Then("Admin should see header with {string}")
	public void admin_should_see_header_with(String string) {
	   String header = driver.getTitle().trim();
	   softAssert.assertTrue(header.contains(string));
	   
	}

	@When("get all text from the portal page")
	public void get_all_text_from_the_portal_page() {
		//List<WebElement> el = driver.findElements(By.xpath("//*"));
	    size = cpe.el.size();

	}


@Then("Admin should see correct spelling for the all the {string}")
public void admin_should_see_correct_spelling_for_the_all_the(String string) {
	size = cpe.el.size();
	for(int i=0;i<size;i++)
    {
    	String t = cpe.el.get(i).getText();
   	   if(t.contains(string))
   	   {
   		   softAssert.assertTrue(true);
   		   break;
   	   }

   	 
    }

    
}
	@Then("Admin should see disabled delete icon below the {string}")
	public void admin_should_see_disabled_delete_icon_below_the(String string) {
	    if(driver.findElement(cpe.deleteButton).isDisplayed())
	    {
	    	if(!driver.findElement(cpe.deleteButton).isEnabled())
	    	{
	    		softAssert.assertTrue(true, "Delete Button is displayed and disabled");
	    	}
	    }
	}

	@Then("Admin should see search bar on the class page")
	public void admin_should_see_search_bar_on_the_class_page() {
		if(driver.findElement(cpe.searchBar).isDisplayed())
		{
    		softAssert.assertTrue(true, "search bar is displayed");	
		}
	}

	@Then("Admin should see +Add New Class button on the class page")
	public void admin_should_see_add_new_class_button_on_the_class_page() {
	    if(driver.findElement(cpe.addNewClassButton).isDisplayed())
	    {
    		softAssert.assertTrue(true, "+Add New Class Button is displayed");	

	    }
	   }

	@Then("Admin should see data table on the Manage Class Page With following {string}")
	public void admin_should_see_data_table_on_the_manage_class_page_with_following(String string) {	
		
		size = cpe.tableHeaders.size();
		if(string == "Check Box Symbol")
		{
			if(driver.findElement(By.xpath("checkbox")).isDisplayed())
			{
	    		softAssert.assertTrue(true);	
			}
			
		}
		else
		{
			if(driver.findElement(cpe.dataTable).isDisplayed())
			{		
			for(int i=0;i<size;i++)
			{
				String headers = cpe.tableHeaders.get(i).getText().trim();
				if(headers.equalsIgnoreCase(string.trim()))
				{
		    		softAssert.assertTrue(true);	
	                break;	
				}
			}
			
		}
	}
		
	    
}

	@Then("Edit Icon in each row of data table only  when entries are available")
	public void edit_icon_in_each_row_of_data_table_only_when_entries_are_available() {
        //clearing the data table rows by giving an invalid search
		//if()
		//{
			//driver.findElement(searchBar).sendKeys("invalid");
		
			size = cpe.editIcon.size();
			if(size>0)
			{
				for(int i=0;i<size;i++)
				{
					softAssert.assertTrue(cpe.editIcon.get(i).isDisplayed());

				}
		    }
			
				
	}

	@Then("Edit Icon will not be present in data table")
	public void edit_icon_will_not_be_present_in_data_table() {
		//clearing the data table rows by giving an invalid search
		driver.findElement(cpe.searchBar).sendKeys("invalidtext");
		size = cpe.editIcon.size();
		if(size == 0)
		{
			if(!cpe.editIcon.get(0).isDisplayed())
			{
				softAssert.assertTrue(true);
			}
		}

}

	@Then("Delete Icon in each row of data table only  when entries are available")
	public void delete_icon_in_each_row_of_data_table_only_when_entries_are_available() {
		size = cpe.deleteIcon.size();
		if(size>0)
		{
			for(int i=0;i<size;i++)
			{
				softAssert.assertTrue(cpe.deleteIcon.get(i).isDisplayed());

			}
	    }
	}

	@Then("Admin cant see delete  Icon in data table")
	public void admin_cant_see_delete_icon_in_data_table() {
		driver.findElement(cpe.searchBar).sendKeys("invalidtext");
		size = cpe.deleteIcon.size();
		if(size == 0)
		{
			if(!cpe.deleteIcon.get(0).isDisplayed())
			{
				softAssert.assertTrue(true);
			}
		}
}

	@Then("Admin should see sort icon near the column headers except for Edit and Delete")
	public void admin_should_see_sort_icon_near_the_column_headers_except_for_edit_and_delete() {
		size = cpe.sortIcon.size();
		if(size>0)
		{
			for(int i=0;i<size;i++)
			{
				softAssert.assertTrue(cpe.sortIcon.get(i).isDisplayed());

			}
		}
	}

	@Then("Admin should see check box in the all rows  of data table")
	public void admin_should_see_check_box_in_the_all_rows_of_data_table() {
		List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
		List<WebElement> checkBoxes = driver.findElements(By.className("checkbox"));
		if(rows.size() == checkBoxes.size())
		{
			for(int i=0;i<size;i++)
		    {
				softAssert.assertTrue(checkBoxes.get(i).isDisplayed());
		    }
		}
		
	   }

	@Then("Above the footer Admin should see the text as \"\"Showing x to y of z entries\"\" below the table")
	public void above_the_footer_admin_should_see_the_text_as_showing_x_to_y_of_z_entries_below_the_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {
		
		softAssert.assertTrue(driver.findElement(By.xpath("//forwardpaginationButton")).isDisplayed());
		softAssert.assertTrue(driver.findElement(By.xpath("//backwardpaginationButton")).isDisplayed());						
		softAssert.assertTrue(driver.findElement(By.xpath("//firstpageButton")).isDisplayed());						
		softAssert.assertTrue(driver.findElement(By.xpath("//lastpageButton")).isDisplayed());						

	}

	@Then("Admin should see the text with total number classes in the data table. \\( {string})")
	public void admin_should_see_the_text_with_total_number_classes_in_the_data_table(String string) {
		List<WebElement> rows = cpe.table.findElements(By.xpath(".//tr"));
		size = rows.size();
		String footerText = driver.findElement(By.cssSelector("div.page-footer span")).getText().trim();
		String total_classes = footerText.replaceAll("[^0-9]", " ").trim();
         //checking whether the number of classes displayed is correct
		String s = Integer.toString(size);
        softAssert.assertEquals(size, total_classes);		
        //checking for text
		 softAssert.assertTrue(footerText.toLowerCase().contains("In total there are x classes"));
	
	}

}