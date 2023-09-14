package StepDefinition;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.*;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Assignment_Sort_SD extends BaseClass{
	@Given("Admin is on manage assignment page")
	public void admin_is_on_manage_assignment_page() {
	   driver.getCurrentUrl();
	}

	@When("Admin click on assignment name column header to sort")
	public void admin_click_on_assignment_name_column_header_to_sort() {
		ape.ClickSortassignmentNameHeader();
	}

	

	@When("Admin double click on assignment name column header to sort")
	public void admin_double_click_on_assignment_name_column_header_to_sort() {
		ape.DoubleClickSortassignmentNameHeader();
	}
}
