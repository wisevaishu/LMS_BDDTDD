package StepDefinition;

import Base.BaseClass;
import PageObjects.ProgramPageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortProgram_Step extends BaseClass{




@When("Admin clicks the sort icon of Program Name column")
public void admin_clicks_the_sort_icon_of_program_name_column() {
 
programPage.ProgramNameSortIcon();
}

@Then("The data get sorted on the table based on the Program Name column values in ascending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_acending_order() {
   
log.info("Admin ges sorted on the table based on the Program Name column values in ascending order");
}

@Given("The data is in the ascending order on the table based on Program Name column")
public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_name_column() {
   
log.info("Data is in the ascending order on the table based on the program Name");
}

@Then("The data get sorted on the table based on the Program Name column values in decending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_decending_order() {
   
programPage.ProgramNameDescendingOrder();
log.info("Admin ges sorted on the table based on the Program Name column values in descending order");
}

@When("Admin clicks the sort icon of Program Description column")
public void admin_clicks_the_sort_icon_of_program_description_column() {
   
programPage.ProgramDescriptionSortIcon();
}

@Then("The data get sorted on the table based on the Program Description column values in acending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_acending_order() {
   
log.info("Admin gets Data in the ascending order on the table based on the program Description");
}

@Given("The data is in the ascending order on the table based on Program Description column")
public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_description_column() {
 
programPage.ProgramDescriptionDescendingOrder();
}

@Then("The data get sorted on the table based on the Program Description column values in decending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_decending_order() {
 
log.info("Admin gets Data in the descending order on the table based on the program Description");
}

@When("Admin clicks the sort icon of Program Status column")
public void admin_clicks_the_sort_icon_of_program_status_column() {
 
programPage.ProgramStatusSortIcon();
}

@Then("The data get sorted on the table based on the Program Status column values in acending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_acending_order() {
   
log.info("Admin gets Data in the ascending order on the table based on the program Status");
}

@Given("The data is in the ascending order on the table based on Program Status column")
public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_status_column() {
   
programPage.ProgramStatusDescendingOrder();
}

@Then("The data get sorted on the table based on the Program Status column values in decending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_decending_order() {
 
log.info("Admin gets Data in the descending order on the table based on the program Status");
}
}