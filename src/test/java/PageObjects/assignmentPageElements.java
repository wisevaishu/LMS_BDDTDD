package PageObjects;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.BaseClass;

public class assignmentPageElements extends BaseClass{
	public String deletedRecord= "";
	public assignmentPageElements()
	{
		PageFactory.initElements(driver, this);
	}

	public By addNewAssignmentButton = By.xpath("//addnewAssignmentButton");
	public List<WebElement> checkBoxes = driver.findElements(By.className("checkbox"));

	@FindBy(xpath = "New_Assignment_Btn")
	WebElement newAssignmentBtn ;

	public void newAssignmentButtonClick()
	{
		au.clickOper(newAssignmentBtn);
	}

	@FindBy(xpath = "upload_Assignment_Btn")
	WebElement uploadAssignmentBtn ;

	public void uploadAssignmentButtonClick()
	{
		au.clickOper(uploadAssignmentBtn);
	}

	@FindBy(xpath = "Srch_Assignment_Txt")
	WebElement searchAssignmentTextbox ;

	public void searchAssignmentTextbox()
	{
		au.enterText(searchAssignmentTextbox, "XYZ");
	}
	public boolean searchIsDisplayed() {
		boolean isDisplayed = searchAssignmentTextbox.isDisplayed();
		return isDisplayed;
	}

	@FindBy(xpath = "Delete_Assignment_Btn")
	WebElement deleteAssignmentBtn ;

	public boolean DeleteIconDisable()
	{
		String iconClass = deleteAssignmentBtn.getAttribute("class");
		boolean isDisabled = iconClass.contains("disabled");
		return isDisabled;
	}

	public void deleteAssignmentButtonClick()
	{
		au.clickOper(deleteAssignmentBtn);
	}

	@FindBy(xpath = "Table_Assignment")
	WebElement table_Assignment ;
	//incomplete need to read data from table
	//public void tableAssignment()
	//{

	//}

	@FindBy(xpath = "lable_Assignment")
	WebElement lableAssignment ;
	// need to read values from lable
	//public void lableAssignment()
	//{

	public String getUrl() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}

	//}
	@FindBy(xpath = "Assignment_header")
	WebElement Assignment_header ;


	public String getheader() {

		return Assignment_header.getText();
	}
	public boolean addNewBtnIsDisplayed() {
		boolean isDisplayed = newAssignmentBtn.isDisplayed();
		return isDisplayed;

	}

	@FindBy(xpath = "Assignment_PopUp_header")
	WebElement Assignment_Pop_Up_header ;


	public String get_Pop_Up_header() {

		// Switch to the popup window using window handles
		String mainWindowHandle = driver.getWindowHandle(); // Store the main window handle
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(windowHandle); // Switch to the popup window
				break;
			}
		}
		String popUpHeader= Assignment_Pop_Up_header.getText();
		// Switch back to the main window if needed
		driver.switchTo().window(mainWindowHandle);
		return popUpHeader;
		// Switch back to the main window if needed
		//driver.switchTo().window(mainWindowHandle);
	}

	@FindBy(xpath = "Assignment_PopUp_PrgramNameDrpDwn")
	WebElement Assignment_Pop_Up_PrgramNameDrpDwn ;

		public String get_Pop_Up_PrgramNameDrpDwn() {
		String mainWindowHandle = driver.getWindowHandle(); // Store the main window handle
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(windowHandle); // Switch to the popup window
				break;
			}
		}

		Select select = new Select(Assignment_Pop_Up_PrgramNameDrpDwn);
		WebElement selectedOption = select.getFirstSelectedOption();
		//    String selectedOptionText = selectedOption.getText();
		String SelectedTxt =selectedOption.getText();
		driver.switchTo().window(mainWindowHandle);
		return SelectedTxt;

	}
		public boolean IsVisibleProgramDrpDwn() {
			String mainWindowHandle = driver.getWindowHandle(); // Store the main window handle
			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(mainWindowHandle)) {
					driver.switchTo().window(windowHandle); // Switch to the popup window
					break;
				}
			}
			boolean isDisplayed = au.checkVisible(Assignment_Pop_Up_PrgramNameDrpDwn);
			driver.switchTo().window(mainWindowHandle);
			return isDisplayed ;
		}
		

	@FindBy(xpath = "Assignment_PopUp_BatchNoDrpDwn")
	WebElement Assignment_PopUp_BatchNoDrpDwn ;

	public boolean IsVisibleBtachDrpDwn() {
		String mainWindowHandle = driver.getWindowHandle(); // Store the main window handle
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(windowHandle); // Switch to the popup window
				break;
			}
		}
		boolean isDisplayed = au.checkVisible(Assignment_PopUp_BatchNoDrpDwn);
		driver.switchTo().window(mainWindowHandle);
		return isDisplayed ;
	}

	public String get_Pop_UpBatchNoDrpDwn() {
		String mainWindowHandle = driver.getWindowHandle(); // Store the main window handle
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(windowHandle); // Switch to the popup window
				break;
			}
		}
		Select select = new Select(Assignment_PopUp_BatchNoDrpDwn);
		WebElement selectedOption = select.getFirstSelectedOption();
		//    String selectedOptionText = selectedOption.getText();
		String selectedTxt =selectedOption.getText();
		driver.switchTo().window(mainWindowHandle);

		return selectedTxt;

	}

	@FindBy(xpath = "Assignment_PopUp_Name")
	WebElement Assignment_Pop_Up_Name ;


	public String get_Pop_Up_Name() {
		String mainWindowHandle = driver.getWindowHandle(); // Store the main window handle
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(windowHandle); // Switch to the popup window
				break;
			}
		}
		String nameTxt = Assignment_Pop_Up_Name.getText();
		driver.switchTo().window(mainWindowHandle);

		return nameTxt; 

	}
	@FindBy(xpath = "Assignment_PopUp_Description")
	WebElement Assignment_Pop_Up_Description ;


	public String get_Pop_Up_Description() {
		String mainWindowHandle = driver.getWindowHandle(); // Store the main window handle
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(windowHandle); // Switch to the popup window
				break;
			}
		}
		String descriptionTxt =Assignment_Pop_Up_Description.getText();
		driver.switchTo().window(mainWindowHandle);
		return descriptionTxt;
	}

	@FindBy(xpath = "Assignment_PopUp_GradeBy")
	WebElement Assignment_Pop_Up_GradeBy ;


	public String get_Pop_Up_GradeBy() {
		String mainWindowHandle = driver.getWindowHandle(); // Store the main window handle
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(windowHandle); // Switch to the popup window
				break;
			}
		}
		String gradeTxt =Assignment_Pop_Up_GradeBy.getText();
		driver.switchTo().window(mainWindowHandle);
		return gradeTxt;
	}
	@FindBy(xpath = "Assignment_PopUp_CalenderIcon")
	WebElement Assignment_Pop_Up_CalenderIcon ;
	
	public boolean IsVisibleCalenderIcon() {
		 
			String mainWindowHandle = driver.getWindowHandle(); // Store the main window handle
			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(mainWindowHandle)) {
					driver.switchTo().window(windowHandle); // Switch to the popup window
					break;
				}
			}
			boolean isDisplayed = au.checkVisible(Assignment_Pop_Up_CalenderIcon);
			driver.switchTo().window(mainWindowHandle);
			return isDisplayed ;
	}
	@FindBy(xpath = "Assignment_PopUp_CancleBtn")
	WebElement Assignment_Pop_Up_cancelBtn ;
	
	public boolean cancelBtnIsDisplayed() {
		String mainWindowHandle = driver.getWindowHandle(); // Store the main window handle
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(windowHandle); // Switch to the popup window
				break;
			}
		}
		boolean isDisplayed = au.checkVisible(Assignment_Pop_Up_cancelBtn);
		driver.switchTo().window(mainWindowHandle);
		return isDisplayed ;
		
	}
	@FindBy(xpath = "Assignment_PopUp_CloseBtn")
	WebElement Assignment_Pop_Up_CloseBtn ;
	public boolean IsVisibleCloseBtn() {
		String mainWindowHandle = driver.getWindowHandle(); // Store the main window handle
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(windowHandle); // Switch to the popup window
				break;
			}
		}
		boolean isDisplayed = au.checkVisible(Assignment_Pop_Up_CloseBtn);
		driver.switchTo().window(mainWindowHandle);
		return isDisplayed ;
	}
	@FindBy(xpath = "assignmentNameHeaderSort")
	
	List<WebElement> assignmentNameHeaderSort ;
	public void ClickSortassignmentNameHeader()
	{
		au.clickOper(assignmentNameHeaderSort.get(0));
		
	}
	public void DoubleClickSortassignmentNameHeader()
	{
		Actions act = new Actions(driver);

		//Double click on element 
		act.doubleClick(assignmentNameHeaderSort.get(0)).perform();
		
	}

	@FindBy(xpath = "AssignmentBtn")
	WebElement AssignmentBtn ;
	public void clickAssgnmentBtn() {
		au.clickOper(AssignmentBtn);;
	}
	
	public String extractAssignmentName(String s)
	{
		 String deleteAssignmentName = new Scanner(deletedRecord).useDelimiter("\\D+").next();
		String	deletedRecord = deleteAssignmentName.trim();
			return deletedRecord;
	}
	
}


