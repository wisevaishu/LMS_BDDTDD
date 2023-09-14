
package StepDefinition;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Base.BaseClass;
import io.cucumber.java.en.*;

public class sortClass extends BaseClass{

	@When("Admin click on Batch id column header to sort")
	public void admin_click_on_batch_id_column_header_to_sort() {
		cpe.sortIcon.get(0).click();
	}

	@Then("Admin should see data table sorted in descending order")
	public void admin_should_see_data_table_sorted_in_descending_order() {
		List<WebElement> td = cpe.table.findElements(By.tagName("td"));
		
		String strArry [] = new String[td.size()];
		String revArry [] = new String[td.size()];
		for(int i=0;i < td.size();i++)
		{
			strArry[i]=td.get(i).getText();
			revArry[i]=td.get(i).getText();
		}
		Arrays.sort(revArry, Collections.reverseOrder());
		
		for(int i=0;i < td.size();i++)
		{
			softAssert.assertEquals(strArry[i], revArry[i]);
		}
		
		
	 }

	@When("Admin double click on Batch id column header to sort")
	public void admin_double_click_on_batch_id_column_header_to_sort() {
		
		Actions act = new Actions(driver);

		//Double click on element 
		act.doubleClick(cpe.sortIcon.get(0)).perform();
	}

	@Then("Admin should see data table sorted in ascending  order")
	public void admin_should_see_data_table_sorted_in_ascending_order() {
	List<WebElement> td = cpe.table.findElements(By.tagName("td"));
		
		String strArry [] = new String[td.size()];
		String ascArry [] = new String[td.size()];
		for(int i=0;i < td.size();i++)
		{
			strArry[i]=td.get(i).getText();
			ascArry[i]=td.get(i).getText();
		}
		Arrays.sort(ascArry);
		
		for(int i=0;i < td.size();i++)
		{
			softAssert.assertEquals(strArry[i], ascArry[i]);
		}
		
	}

}