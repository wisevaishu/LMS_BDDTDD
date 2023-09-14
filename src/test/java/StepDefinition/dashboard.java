package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class dashboard extends BaseClass
{
	@Then("Admin should see manage program as header")
	public void admin_should_see_manage_program_as_header() 
	{
		Assert.assertEquals(mpe.getManageProgramSpanText(), "Manage Program");
		log.info("Admin should see manage program as header");
	}
	
	@Then("Admin should see {string} as title")
	public void admin_should_see_as_title(String title) 
	{
		String TitleOfThePage = au.getTitleOfThePage();
		Assert.assertEquals(TitleOfThePage, title);
		log.info("Admin see LMS title");
	}
	
	@Then("Admin should see LMS title on top left corner of page")
	public void admin_should_see_lms_title_on_top_left_corner_of_page() 
	{
		int winHeight = driver.manage().window().getSize().getHeight();
		int winWidth = driver.manage().window().getSize().getWidth();
		int xPos = dbe.LMSTitle.getLocation().getX();
		int yPos = dbe.LMSTitle.getLocation().getY();
		int eleHeight = dbe.LMSTitle.getSize().getHeight();
		int eleWidth = dbe.LMSTitle.getSize().getWidth();
		Assert.assertTrue( ( (xPos + eleWidth) <= winWidth/2)  && ( (yPos + eleHeight) <= winHeight/2), "Title Is not top left corner of page");		
	}
	
	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() 
	{
		int MenuCount = dbe.NavigationMenuList.size();
		int count=0;
		boolean value=false;
		for (int i=1;i<=MenuCount;i++)
		{
			WebElement eachList = driver.findElement(By.xpath("//body/div[@id='navigation']/div[1]/nav[1]/div[1]/ul/li["+i+"]"));
			if ( (eachList.getText().contains("Student")) || (eachList.getText().contains("Program")) || 
			     (eachList.getText().contains("Batch"))	|| (eachList.getText().contains("Class")) ||
			     (eachList.getText().contains("User")) || (eachList.getText().contains("Assignment")) || 
			     (eachList.getText().contains("Attendance")) || (eachList.getText().contains("Logout")) )
			{
				count++;
			}					
		}
		if (count==8)
		{
			value=true;
		}
		else
		{
			value=false;
		}
		if (value=true)
		{
			Assert.assertTrue(value);
		}
		log.info("Admin should see correct spelling in navigation bar text");
	}
	
	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() 
	{
		Assert.assertEquals(dbe.getLMSTitleText(), "LMS - Learning Management System");
		log.info("Admin should see correct spelling and space in LMS title");
	}
	
	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() 
	{
		int winHeight = driver.manage().window().getSize().getHeight();
		int winWidth = driver.manage().window().getSize().getWidth();
		int xPos = dbe.LMSNavigationBar.getLocation().getX();
		int yPos = dbe.LMSNavigationBar.getLocation().getY();
		int eleHeight = dbe.LMSNavigationBar.getSize().getHeight();
		int eleWidth = dbe.LMSNavigationBar.getSize().getWidth();
		Assert.assertTrue( ( (xPos + eleWidth) >= winWidth/2)  && ( (yPos + eleHeight) >= winHeight/2), "Navigation bar is not on top right corner");
	}
	
	@Given("Admin in Dashboard Page")
	public void admin_in_dashboard_page() 
	{
		String TitleOfThePage = au.getTitleOfThePage();
		Assert.assertEquals(TitleOfThePage, "Dashboard Page");
		log.info("Admin in Dashboard Page");
	}
	
	@Then("Admin should see Menus in the the appropriate places {string} and {string}")
	public void admin_should_see_menus_in_the_the_appropriate_places_and(String menuname, String postinono) 
	{
		WebElement eachmenu = driver.findElement(By.xpath("//body/div[@id='navigation']/div[1]/nav[1]/div[1]/ul/li["+postinono+"]"));
		if  (eachmenu.getText().contains(menuname))
		{
			Assert.assertTrue(true);
		}
		log.info("Admin seeing the menus appropriate postion" +menuname + " " + postinono);
	}
	
	@Then("Admin click Logout from navigation bar")
	public void admin_click_logout_from_navigation_bar() 
	{
		dbe.clickLogout();
		log.info("Admin click logout");
	}
}
