
package StepDefinition;

import org.openqa.selenium.By;

import Base.BaseClass;
import io.cucumber.java.en.*;

public class classNavigation extends BaseClass {
	
	@When("Admin clicks {string} button in the navigation bar")
	public void admin_clicks_button_in_the_navigation_bar(String string) {
		
		string = string.trim().toLowerCase();
		String pagebutton = "//*[@href=" + string + "]";
		driver.findElement(By.xpath(pagebutton)).click();
		
	}

	@Then("Admin should able to land on {string} page")
	public void admin_should_able_to_land_on_page(String string) {
	
		string = string.trim().toLowerCase();
		String testUrl = "https://lmsapplication.com/" + string; 
		softAssert.assertEquals(driver.getCurrentUrl(),testUrl);
	}

}