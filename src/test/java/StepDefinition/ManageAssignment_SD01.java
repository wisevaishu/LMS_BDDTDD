package StepDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.swabunga.spell.engine.SpellDictionaryHashMap;
import com.swabunga.spell.event.SpellChecker;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;

public class ManageAssignment_SD01 extends BaseClass {
	private SpellChecker spellChecker;


	@Given("Logged on the LMS portal as Admin")
	public void logged_on_the_lms_portal_as_admin() {
	
		lpe.clickLoginButton();
		log.info("Logged on the LMS portal as Admin");
	}

	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
	    
		String TitleOfThePage = au.getTitleOfThePage();
		Assert.assertEquals(TitleOfThePage, "Dashboard Page");
		log.info("Admin lands on dashboard page");
	}

	@When("Admin clicks {string} button on the navigation bar")
	public void admin_clicks_button_on_the_navigation_bar(WebElement assignmentBtn) {
		
	 //  dpe.clickOper(assigmnentBtn);
	}
	
	@Then("Admin should see URL with {string} in assignment module")
	public void admin_should_see_url_with_in_assignment_module(String expectedUrl) {
		String actual_Url = ape.getUrl();
		Assert.assertEquals(actual_Url,expectedUrl); 
		
	   
	}
//	private WebDriver driver;
    private WebDriverWait wait;
    public void NavigationStepDefinitions(WebDriver driver) {
        this.driver = driver;
   //     wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
    }

    

	@Then("Get the response time for navigation from dashboard page to manage assignment page")
	public void get_the_response_time_for_navigation_from_dashboard_page_to_manage_assignment_page() {
		// Navigate from the dashboard to the manage assignment page
        driver.findElement(By.linkText("Manage Assignments")).click();

        // Measure the response time
        long startTime = System.currentTimeMillis();

        // Wait for an element on the manage assignment page to ensure it's fully loaded
        WebElement manageAssignmentHeader = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Manage Assignments')]")));

        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;

        // You can print the response time or perform any validation as needed
        System.out.println("Response time for navigation: " + responseTime + " milliseconds");

	}

	@Then("Admin should see header with {string} in assignment module")
	public void admin_should_see_header_with_in_assignment_module(String expectedHeaderText) {
		String actualHeaderText = ape.getheader();
		Assert.assertEquals("Header text mismatch", expectedHeaderText, actualHeaderText);
	   
	}

	@When("Admin clicks {string} button on the navigation bar and get all text from the portal page")
	public void admin_clicks_button_on_the_navigation_bar_and_get_all_text_from_the_portal_page(String string) {
	  //need dashboardpageElements
	//	dpe.clickAssignment();
		// Get all text from the portal page
        List<WebElement> allTextElements = driver.findElements(By.xpath("//*[not(self::script)]/text()")); 
        // Iterate through the elements and print their text
        for (WebElement element : allTextElements) {
            String text = element.getText();
            if (!text.trim().isEmpty()) {
                System.out.println(text);
            }
        }
     
	}
	
	 
	    public void AdminSpellCheckStepDefinitions(WebDriver driver) throws IOException {
	        this.driver = driver;
	        // Initialize the spell checker with a dictionary (you may need to adjust the path)
	        SpellDictionaryHashMap dictionary = new SpellDictionaryHashMap();
	     //   dictionary.addDictionary("C:/Users/HP/.git/LMS_BDDTDD/dictionary.txt");
	       // dictionary.addDictionary("path/to/your/dictionary.txt"); // Replace with the actual path
	        spellChecker = new SpellChecker(dictionary);
	    }

	@Then("Admin should see correct spelling for the all the fields")
	public void admin_should_see_correct_spelling_for_the_all_the_fields() {
		// Get all text from the portal page
        List<String> allText = getAllTextFromPortalPage();

        // Check spelling for each word in the text
        List<String> misspelledWords = new ArrayList<>();

        for (String text : allText) {
            String[] words = text.split("\\s+");
            for (String word : words) {
                if (!isWordSpelledCorrectly(word)) {
                    misspelledWords.add(word);
                }
            }
        }

        // If misspelled words are found, fail the test
        if (!misspelledWords.isEmpty()) {
            System.out.println("Misspelled words: " + StringUtils.join(misspelledWords, ", "));
            Assert.fail("There are misspelled words on the page.");
        }
	}

	private boolean isWordSpelledCorrectly(String word) {
		 String cleanedWord = WordUtils.capitalizeFully(word); // Capitalize the first letter for Jazzy
	        return spellChecker.isCorrect(cleanedWord);
	}

	private List<String> getAllTextFromPortalPage() {
		List<String> allText = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//*[not(self::script)]/text()"));

        for (WebElement element : elements) {
            String text = element.getText();
            if (!text.trim().isEmpty()) {
                allText.add(text);
            }
        }
        return allText;
	}

	@Then("Admin should see disabled delete icon below the {string} in assignment module")
	public void admin_should_see_disabled_delete_icon_below_the_in_assignment_module(String string) {
	boolean isDisabled = ape.DeleteIconDisable();
		  Assert.assertTrue(isDisabled);
	}

	@Then("Admin should see search bar on the manage assignment page")
	public void admin_should_see_search_bar_on_the_manage_assignment_page() {
		boolean searchIsDisabled =   ape.searchIsDisplayed();
	   Assert.assertTrue(searchIsDisabled);
	}

	@Then("Admin should see +Add New assignment button on the manage assignment page")
	public void admin_should_see_add_new_assignment_button_on_the_manage_assignment_page() {
		boolean addNewBtnIsDisabled =   ape.addNewBtnIsDisplayed();
		   Assert.assertTrue(addNewBtnIsDisabled);
	}

}
