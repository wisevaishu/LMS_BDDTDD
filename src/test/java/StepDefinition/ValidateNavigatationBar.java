package StepDefinition;

import org.testng.Assert;

import Base.BaseClass;
import PageObjects.ProgramPageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidateNavigatationBar extends BaseClass {



@Given("Admin is on the Program page after login")
public void admin_is_on_the_program_page_after_login() {
   
String TitleOfThePage = au.getTitleOfThePage();
Assert.assertEquals(TitleOfThePage, "Program details");
log.info("Admin is on the manage program page");
}

@When("Admin clicks the {string} button in the navigation bar from program page")
public void admin_clicks_the_button_in_the_navigation_bar_from_program_page(String string) {
   
programPage.navigateToOtherPages(ManageProgram_URL);
}

@Then("Admin should be able to land on the {string}  link page")
public void admin_should_be_able_to_land_on_the_link_page(String string) {
   
log.info("Admin is landing all the  page");
}

@When("Admin clicks on {string} link on Manage program page")
public void admin_clicks_on_link_on_manage_program_page(String string) {
   
programPage.logout();
}

@Then("Admin is redirect to {string} page from Manage Program page")
public void admin_is_redirect_to_page_from_manage_program_page(String string) {
   
String TitleOfThePage = au.getTitleOfThePage();
Assert.assertEquals(TitleOfThePage, "LogIn");
log.info("Admin is re-direct to the login page after clicking logout");
}
}