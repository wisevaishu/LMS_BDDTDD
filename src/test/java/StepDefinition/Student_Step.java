package StepDefinition;

import java.io.IOException;
import org.testng.Assert;
import Base.BaseClass;
import PageObjects.StudentPageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ApplicationUtils;

public class Student_Step extends BaseClass 
{
	StudentPageElements studentPage = new StudentPageElements();
	
	@Given("Admin is on the Dashboard page after logged in")
	public void admin_is_on_the_dashboard_page_after_logged_in() 
	{
		log.info("Admin is on the Dashboard page");
	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) 
	{
		studentPage.ValidateStudentbutton();
		log.info("Admin clicks student button on Dashboard");
	}

	@Then("Admin should see the {string} page title")
	public void admin_should_see_the_page_title(String string) 
	{
		String TitleOfThePage = au.getTitleOfThePage();
		Assert.assertEquals(TitleOfThePage, "Student Details");
		log.info("Admin in Student Details page");
	}

	@Then("Maximun navigation time in milliseconds,defaults to {int} seconds")
	public void maximun_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) 
	{
		ApplicationUtils.waitUntilAlertIsPresent();
		String TitleOfThePage = au.getTitleOfThePage();
		Assert.assertEquals(TitleOfThePage, "Student Details");
		log.info("Admin in Student Details page");
	}

	@When("Admin clicks {string} on the navigation bar to validate the broken link")
	public void admin_clicks_on_the_navigation_bar_to_validate_the_broken_link(String url) throws IOException 
	{
		studentPage.validateBrokenLink(url);
		log.info("Admin valiating the student broken link");
	}

	@Then("HTTP response >={int}, then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) 
	{
		String statusCode = au.getTitleOfThePage();
		Assert.assertEquals(statusCode, "400 Bad Request");
		log.warn("Admin gets 400 Bad Request");
	}

	@Then("Admin should see the {string} as title")
	public void admin_should_see_the_as_title(String string) 
	{
		String TitleOfThePage = au.getTitleOfThePage();
		Assert.assertEquals(TitleOfThePage, "Learning Management System");
		log.info("Admin is seeing Learning Management System Title");
	}

	@Then("Student details title should be in center of the page")
	public void student_details_title_should_be_in_center_of_the_page() 
	{
		studentPage.LocationOfTitle();
		log.info("Student Details title is in center of the Page");
	}

	@Then("{int} drop down should be present in the {string} page")
	public void drop_down_should_be_present_in_the_page(Integer int1, String string) 
	{
		studentPage.ValidateDropdown();
		log.info("Admin is seeing Student Name dropdown and batch id dropdown");
	}

	@Then("Admin should see {string} inside the {string} drop down")
	public void admin_should_see_inside_the_drop_down(String string, String string2) 
	{
		studentPage.studentNameDropdown();
		studentPage.BatchIdDropdown();
		log.info("Admin can able to see search bar after clicking Student Name dropdown");
		log.info("Admin can able to see search bar after clicking batch id dropdown");
	}

	@Then("Admin should see correct spelling select {string} text")
	public void admin_should_see_correct_spelling_select_text(String string) 
	{
		studentPage.verifyNameAndIdSpelling();
		log.info("Admin is seeing the correct spelling of Student Names and Batch id");
	}

	@Then("Admin should see select {string} in gray color")
	public void admin_should_see_select_in_gray_color(String string) 
	{
		studentPage.ValidateNameAndIdColor();
		log.info("Admin sees Student names and batch ids are in gray color");
	}

	@Then("Admin should see select {string} in first")
	public void admin_should_see_select_in_first(String string) 
	{
		studentPage.ValidateNameFirstDropdownlable();
		log.info("Admin sees the first dropdown lable on Student Name");
	}

	@Then("Admin should see select {string} in second")
	public void admin_should_see_select_in_second(String string) 
	{
		studentPage.ValidateIdSecondDropdownlable();
		log.info("Admin sees the second dropdown lable on batch id");
	}

	@Then("Admin should able to scroll down to select the Student name")
	public void admin_should_able_to_scroll_down_to_select_the_student_name() 
	{
		studentPage.StudentNameDropdownScroll();
		log.info("Admin can able to scroll down the Student Name dropdown");
	}

	@Then("Admin should able to scroll down to select the batch id")
	public void admin_should_able_to_scroll_down_to_select_the_batch_id() 
	{
		studentPage.batchIdDropdownScroll();
		log.info("Admin can able to scroll down the batch id dropdown");
	}

	@Given("Admin is on Student details page")
	public void admin_is_on_student_details_page() 
	{
		log.info("Admin is on Student Details Page");
	}

	@When("Admin select {string} from the drop down")
	public void admin_select_from_the_drop_down(String string) 
	{
		studentPage.studentNameDropdown();
	}

	@Then("Admin should not see select student name text")
	public void admin_should_not_see_select_student_name_text() 
	{
		studentPage.ValidateStudentNameFade();
		log.info("Admin is seeing the faded student name");
	}

	@Then("Admin should not see select batch id text")
	public void admin_should_not_see_select_batch_id_text() 
	{
		studentPage.BatchIdDropdown();
		studentPage.ValidateBatchIdFade();
		log.info("Admin is seeing the faded batch id");
	}

	@When("Admin clicks {string} search box and enters {string} alphabet in the search box")
	public void admin_clicks_search_box_and_enters_alphabet_in_the_search_box(String string, String string2) 
	{
		studentPage.ValidateStudentNameSearchBox();
	}

	@Then("Admin should see student name start with x is listed below")
	public void admin_should_see_student_name_start_with_x_is_listed_below() 
	{
		log.info("Admin is seeing list of same alphat student name which is validated by the search box");
	}

	@When("Admin clicks {string} search box and enters x number in the search box")
	public void admin_clicks_search_box_and_enters_x_number_in_the_search_box(String string) 
	{
		studentPage.ValidateBatchIdSearchBox();
	}

	@Then("Admin should see batch id start with x is listed below")
	public void admin_should_see_batch_id_start_with_x_is_listed_below() 
	{
		log.info("Admin is seeing list of same Number batch id which is validated by the search box");
	}

	@When("Admin selects only {string}")
	public void admin_selects_only(String string) 
	{
		studentPage.SelectOnlyStudentName();
		studentPage.SelectOnlyBatchId();
	}

	@Then("Student details should not be displayed")
	public void student_details_should_not_be_displayed() 
	{
		log.info("Admin is not getting any student details");
	}

	@When("Admin selects {string} and batch id")
	public void admin_selects_and_batch_id(String string) 
	{
		studentPage.SelectNameAndId();
	}

	@Then("Particular student informations should be display")
	public void particular_student_informations_should_be_display() 
	{
		log.info("Admin gets student details");
	}

	@When("Admin clicks on {string} link on student page")
	public void admin_clicks_on_link_on_student_page(String string) 
	{
		studentPage.navigateToOtherPages(string);
	}

	@Then("Admin is redirect to Program page")
	public void admin_is_redirect_to_program_page() 
	{
		log.info("Admin is redirecet to Program page");
	}

	@Then("Admin is redirect to Batch page")
	public void admin_is_redirect_to_batch_page() 
	{
		log.info("Admin is redirect to Batch page");
	}

	@Then("Admin is redirect to Class page")
	public void admin_is_redirect_to_class_page() 
	{
		log.info("Admin is redirect to Class page");
	}

	@Then("Admin is redirect to User page")
	public void admin_is_redirect_to_user_page() 
	{
		log.info("Admin is redirect to User page");
	}

	@When("Admin clicks on {string} link on studet page")
	public void admin_clicks_on_link_on_studet_page(String string) 
	{
		log.info("Admin is redirect to Assignment page");
	}

	@Then("Admin is redirect to Attendance page")
	public void admin_is_redirect_to_attendance_page() 
	{
		log.info("Admin is redirect to Attendance page");
	}

	@When("Admin clicks on logout link on student page")
	public void admin_clicks_on_logout_link_on_student_page() 
	{
		studentPage.logout();
	}

	@Then("Admin is redirect to login page")
	public void admin_is_redirect_to_login_page() 
	{
		log.info("Admin redirected to the login page");
	}
}