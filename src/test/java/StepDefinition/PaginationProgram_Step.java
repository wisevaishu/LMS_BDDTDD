package StepDefinition;

import Base.BaseClass;
import PageObjects.ProgramPageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaginationProgram_Step extends BaseClass {





@When("Admin clicks {string} page link on the program table")
public void admin_clicks_page_link_on_the_program_table(String string) {
   
programPage.VerifyNextPageLink();
}

@Then("Admin should see the pagination has {string} link on manage program page")
public void admin_should_see_the_pagination_has_link_on_manage_program_page(String string) {
   
log.info("Admin sees the pagination has Next link");
}

@Then("Admin should see the last page record on the table with Next page link are disabled on manage program page")
public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled_on_manage_program_page() {
   
programPage.VerifyLastPageLink();
log.info("Admin sees the last page record on the table with Next page link are disabled");
}

@Given("Admin is on last page Program table")
public void admin_is_on_last_page_program_table() {
   
programPage.VerifyFirstPageLink();
}

@Then("Admin should see the previous page record on the table with pagination has previous page link on manage program page")
public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link_on_manage_program_page() {
   
log.info("Admin sees the First page record on the table with Previous page link is enabled");
}

@Given("Admin is on previous program page")
public void admin_is_on_previous_program_page() {
   
programPage.VerifyStartPageLink();
}

@Then("Admin should see the very first page record on the table with previous page link are disabled on manage program page")
public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled_on_manage_program_page() {

log.info("Admin sees the Start page record on the table with Previous page link are disabled");
}

}