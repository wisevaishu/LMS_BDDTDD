package PageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;


public class ProgramPageElements extends BaseClass {

	public ProgramPageElements()
	{
		PageFactory.initElements(driver, this);
	}

loginPageElements loginpage = new loginPageElements();

public void LMSlogin() {

hpe.loginButtonClick();
loginpage.setUser(ValidUserName);
loginpage.setPwd(ManageProgram_URL);
loginpage.clickLoginButton();
}

@FindBy (xpath="//div[@class='alert alert-primary']" )
WebElement errorMsg;

public void GetErrorMsg() {

String Msg;
Msg = errorMsg.getText();
}

public static void highlightElement(WebDriver driver, WebElement element) {
 
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='2px solid red'", element);
    }
 
public static void unhighlightElement(WebDriver driver, WebElement element) {
 
 JavascriptExecutor js = (JavascriptExecutor)driver;
 js.executeScript("arguments[0].style.border=''", element);
 
}

//1.Validates the program page elements

@FindBy(xpath = "//div[text()='Program']")WebElement ProgramLink;
@FindBy(xpath = "//div//header[@class='Manage_Program'")
WebElement Manageprogram_header;
@FindBy(xpath = "//div[text()='pagination_icon'")
WebElement Pagination;
@FindBy(xpath = "//div//div[3][@text='total_no_of_records']")
WebElement TotalRecords;
@FindBy(xpath = "//div[@icon='Delete']")
WebElement DeleteIcon;
@FindBy(xpath = "//div[@id='Add New Program']")
WebElement AddNew_Program;
@FindBy(xpath = "//div[@id='table']")
WebElement Table;
@FindBy(id = "search") WebElement Searchbox;


public void ValidateProgramURL() {

ProgramLink.click();
String currentURL = driver.getCurrentUrl();
}

public void validatePageHeader() {

highlightElement(driver,Manageprogram_header);
Manageprogram_header.click();

unhighlightElement(driver,Manageprogram_header);

}

public void validatePaginationIcon() {

highlightElement(driver,Pagination);
Pagination.click();

unhighlightElement(driver,Pagination);
}

public void validateTotalRecords() {

highlightElement(driver,TotalRecords);
TotalRecords.click();

unhighlightElement(driver,TotalRecords);
TotalRecords.getText();
}

public void validateDisabledDeleteIcon() {

highlightElement(driver,DeleteIcon);
DeleteIcon.click();

unhighlightElement(driver,DeleteIcon);

if(DeleteIcon.isDisplayed()) {

System.out.println("passed Validating left sided  deleted icon");
}
 else if(DeleteIcon.isEnabled()) {
 
 System.out.println("Failed Validating left sided deleted icon");
 
 }
 else {
 
 System.out.println("There is no any delete icon on left side of the page");
}
}

public void validateAddNewProgram() {

highlightElement(driver,AddNew_Program);
AddNew_Program.getTagName();

unhighlightElement(driver,AddNew_Program);

if(AddNew_Program.isEnabled()) {

System.out.println("Passed validating +A New Program icon is Enabled");
}
else if(AddNew_Program.isDisplayed()) {

System.out.println("Failed validating +A New Program icon is not Enabled");
}
else {

System.out.println("There is no any +A New Program icon");
}
}

public void ValidateNumberOfRecords() {

List<WebElement> row = Table.findElements(By.xpath("//div//table//tr[2]"));

if(row.size()==5) {

System.out.println("Validate number of Records - Passed");
}
else {

System.out.println("Validate number of Records - Failed");
}
}

WebElement tableHeaders = Table.findElement(By.xpath("//div//table//headers"));

public void validateHeaders() {

List<WebElement> HeaderColumn = tableHeaders.findElements(By.xpath("//div//table//hearder//tc"));

String[] expectHeaders = {"Program Name","Program Description","Program Status","Edit","Delete"};
boolean headerMatch = true;

for(int i=0;i<expectHeaders.length;i++) {

String expectedHeader = expectHeaders[i];
String actualHeader = HeaderColumn.get(i).getText();

if(!expectedHeader.equals(actualHeader)) {

headerMatch = false;
break;
}
}
}
public void ValidateHeaderSortIcons() {

List<WebElement> HeaderColumn = tableHeaders.findElements(By.xpath("//div//table//hearder//tc"));

boolean allcolumnsortIcons = true;

for(WebElement headercolumn : HeaderColumn) {

String HeaderColumnText = headercolumn.getText().trim();

if(!HeaderColumnText.equals("Edit")&&(!HeaderColumnText.equals("Delete"))) {

WebElement sortArrowIcon = headercolumn.findElement(By.xpath("//tc[@class='sort-arrow-icon']"));

if(!sortArrowIcon.isDisplayed())
allcolumnsortIcons = false;
break;
}
}
}
public void ValidateCheckBox() {

List<WebElement> rows = Table.findElements(By.xpath("//div//table//tr[2]"));

boolean rowCheckBox = true;

for(WebElement row : rows) {

WebElement checkbox = row.findElement(By.xpath("//tr[@class='checkbox']"));

if(!checkbox.isDisplayed())
rowCheckBox = false;
break;
}

}
public void ValidateEditDeleteIcon() {

List<WebElement> rows = Table.findElements(By.xpath("//div//table//tr[2]"));

boolean EditDeleteIcon = true;

for(WebElement row : rows) {

WebElement EditIcon = row.findElement(By.xpath("//tr[@class='Edit']"));
WebElement DeleteIcon = row.findElement(By.xpath("//tr[@class='Delete']"));

if(!EditIcon.isDisplayed() || !DeleteIcon.isDisplayed())
EditDeleteIcon = false;
break;
}

}

public void ValidateSearchbox() {

highlightElement(driver,Searchbox);
Searchbox.click();

unhighlightElement(driver,Searchbox);
}

public void SearchProgramByName() {

String ProgramName_Phrase = "Program Name";
Searchbox.sendKeys(ProgramName_Phrase);
Searchbox.submit();

List<WebElement> programItems = driver.findElements(By.className("program-item"));

for (WebElement programItem : programItems) {
            String programName = programItem.findElement(By.className("program-name")).getText();

}
}
public void SearchProgramByDescription() {

String ProgramDescription_Phrase = "Program Description";
Searchbox.sendKeys(ProgramDescription_Phrase);
Searchbox.submit();

List<WebElement> programItems = driver.findElements(By.className("program-item"));

for (WebElement programItem : programItems) {
            String programDescription = programItem.findElement(By.className("program-description")).getText();

}
}
public void SearchProgramByStatus() {

String ProgramStatus_Phrase = "Program Status";
Searchbox.sendKeys(ProgramStatus_Phrase);
Searchbox.submit();

List<WebElement> programItems = driver.findElements(By.className("program-item"));

for (WebElement programItem : programItems) {
            String programStatus = programItem.findElement(By.className("program-status")).getText();

}
}
public void SearchByInvalidData() {

String InvalidData = "Invalid Enteries";
Searchbox.sendKeys(InvalidData);
Searchbox.submit();

WebElement dataTable = driver.findElement(By.id("data-table"));

        if (dataTable.getText().contains("Zero entries")) {
       
            System.out.println("Test passed: Zero entries are displayed.");
        }
        else {
       
            System.out.println("Test failed: Zero entries are not displayed.");
        }
}

//2.Add New Program

@FindBy(xpath = "//*[@class='+ A New Program']")
WebElement AddNewProgram_Button;
@FindBy(xpath = "//*[text()='Name']")
WebElement ProgramName_Attribute;
@FindBy(xpath = "//*[@class='Name textbox'")
WebElement ProgramName_Textbox;
@FindBy(xpath = "//*[text()='Description']")
WebElement ProgramDescription_Attribute;
@FindBy(xpath = "//*[@class='Description textbox'")
WebElement ProgramDescription_Textbox;
@FindBy(xpath = "//*[@value='Active Radiobutton']")
WebElement Active_Radiobutton;
@FindBy(xpath = "//*[@value='Inactive Radiobutton']")
WebElement Inactive_Radiobutton;
@FindBy(xpath = "//button[@value='Save']")
WebElement SaveButton;
@FindBy(xpath = "//*[@id='Name']") WebElement Name;
@FindBy(xpath = "//*[@id='Description']")
WebElement Description;
@FindBy(xpath = "//*[@value='active_radiobutton']")
WebElement Status;
@FindBy(id = "success-message")
WebElement successMessage;
@FindBy(xpath = "//button[@value='Close']")
WebElement CloseButton;
@FindBy(xpath = "//button[@value='Cancel']")
WebElement CancelButton;

public void ClickAddNewProgram() {

AddNewProgram_Button.click();
au.waitUntilAlertIsPresent();  
}

public void ValidateFields() {

assert ProgramName_Attribute.isDisplayed();
assert ProgramName_Textbox.isDisplayed();
assert ProgramDescription_Attribute.isDisplayed();
assert ProgramDescription_Textbox.isDisplayed();
}

public void ValidateRadioButton() {

assert Active_Radiobutton.isDisplayed();
assert Inactive_Radiobutton.isDisplayed();

}

public void ClickSaveButton() {

SaveButton.click();
}

public void setProgramName(String ProgramName) {

Name.click();
Name.sendKeys(ProgramName);

}

public void setProgramDescription(String ProgramDescription) {

Name.click();
Name.sendKeys(ProgramDescription);

}
public String warningName() {

String validationMessage = Name.getAttribute("validationMessage");
return validationMessage;
}
public String warningDescription() {

String validationMessage = Description.getAttribute("validationMessage");
return validationMessage;
}

public void clickStatus() {

Status.click();
SaveButton.click();

        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();

        if (alertMessage.contains("Name and Description are required")) {
       
            System.out.println("Test passed: Alert message is correct.");
        }
        else {
            System.out.println("Test failed: Alert message is incorrect.");
        }
}

   public void validateSuccessMessage(String expectedMessage) {

    if (successMessage.getText().equals(expectedMessage)) {
   
        System.out.println("Test passed: Success message is correct.");
       
    } else {
   
        System.out.println("Test failed: Success message is incorrect.");
    }
   }
public void ValidateNewProgram() {

String expectedProgramName = "New Program";
        String expectedProgramDescription = "New Description";
       
        List<WebElement> rows = Table.findElements(By.xpath("//tbody/tr"));

        boolean programFound = false;
       
        for (WebElement row : rows) {
           
           List<WebElement> cells = row.findElements(By.tagName("td"));
           
            if (Name.equals(expectedProgramName) && Description.equals(expectedProgramDescription)) {
               
            row.getText();
            programFound = true;
                break;
            }
        }

        if (programFound) {
            System.out.println("Test passed: New program is present in the table.");
        } else {
            System.out.println("Test failed: New program is not present in the table.");
        }
}

public void clickCloseButton() {

CloseButton.submit();
}

public void clickCancelButton() {

CancelButton.submit();
}


//3.Edit Program

@FindBy(xpath = "//*[@value='checkbox']")
WebElement CheckBox;

public void clickCheckBox() {

CheckBox.isDisplayed();
CheckBox.click();
}

public void EditProgramName(String editname) {

Name.clear();
Name.sendKeys(editname);
SaveButton.submit();

String expectedName = "EditName";
List<WebElement> rows = Table.findElements(By.xpath("//tbody/tr"));

        boolean programFound = false;
       
        for (WebElement row : rows) {
           
           List<WebElement> cells = row.findElements(By.tagName("td"));

if (Name.equals(expectedName)) {
row.getText();
            programFound = true;
            break;
           
        }
if (programFound) {
            System.out.println("Test passed: New program is present in the table.");
        } else {
            System.out.println("Test failed: New program is not present in the table.");
        }
    }

}

public void EditProgramDescription(String editdescription) {

Description.clear();
Description.sendKeys(editdescription);
SaveButton.submit();

String expectedDescription = "EditDescription";
List<WebElement> rows = Table.findElements(By.xpath("//tbody/tr"));

        boolean programFound = false;
       
        for (WebElement row : rows) {
           
           List<WebElement> cells = row.findElements(By.tagName("td"));

if (Name.equals(expectedDescription)) {
row.getText();
            programFound = true;
            break;
           
        }
if (programFound) {
            System.out.println("Test passed: New program is present in the table.");
        } else {
            System.out.println("Test failed: New program is not present in the table.");
        }
    }


}
//4.Delete Single Program
public void clickDeleteIcon() {

String programNameToDelete = "Program Name";
DeleteIcon.click();

Alert confirmationAlert = driver.switchTo().alert();
        String alertText = confirmationAlert.getText();
       
        if (alertText.contains("Confirm") && alertText.contains("YES") && alertText.contains("NO")) {
       
            System.out.println("Test passed: Confirmation alert is displayed with the expected heading and buttons.");
       
        } else {
       
            System.out.println("Test failed: Confirmation alert is not displayed as expected.");
        }
       
        if (alertText.contains("Are you sure you want to delete " + programNameToDelete + "?")) {
       
            System.out.println("Test passed: Confirmation message is displayed as expected.");
           
        } else {
       
            System.out.println("Test failed: Confirmation message is not displayed as expected.");
        }
}


public void DeleteconfirmationAlert() {

Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.accept();
       
        Alert successAlert = driver.switchTo().alert();

        String successMessage = successAlert.getText();
       
        if (successMessage.equals("Successfully Program Deleted")) {
       
            System.out.println("Test passed: Success message is displayed as expected.");
           
        } else {
       
            System.out.println("Test failed: Success message is not displayed as expected.");
        }
}

public void DeleteDismissAlert(boolean isAlertPresent) {

DeleteIcon.click();

Alert confirmationAlert = driver.switchTo().alert();

        confirmationAlert.dismiss();

        boolean isConfirmationAlertPresent = isAlertPresent;
       
        if (!isConfirmationAlertPresent) {
       
            System.out.println("Test passed: Confirmation alert has disappeared.");
           
        } else {
       
            System.out.println("Test failed: Confirmation alert is still present.");
        }
}

//5.Delete Multiple Program

@FindBy(xpath = "//td[text()='program']")
WebElement deletedProgram;

public void ValidateDeleteButton() {

deletedProgram.isDisplayed();
CheckBox.click();

if(DeleteIcon.isEnabled()) {

System.out.println("Test Passed");
}
else {

System.out.println("Test Failed");
}
}

public void MultiDeletionProgram() {


List<String> programNamesToDelete = new ArrayList<>();
programNamesToDelete.add("Program A");
programNamesToDelete.add("Program B");
programNamesToDelete.add("Program C");

for (String programName : programNamesToDelete) {

            WebElement checkbox = driver.findElement(By.xpath("//td[text()='" + programName + "']/a::td/input[@type='checkbox']"));
                checkbox.click();
                DeleteIcon.click();        
            }
}

//6.Sort Program

@FindBy(xpath = "//td[text()='programName']/sortIcon")
WebElement ProgramName_SortIcon;
@FindBy(xpath = "//td[text()='programDescription']/sortIcon")
WebElement ProgramDescription_SortIcon;
@FindBy(xpath = "//td[text()='programStatus']/sortIcon")
WebElement ProgramStatus_SortIcon;

public void ProgramNameSortIcon() {

ProgramName_SortIcon.click();

List<WebElement> ProgramNameLists = driver.findElements(By.xpath("//td[@class='program-name']"));

List<String> programNames = new ArrayList<>();

for(WebElement ProgramNameList : ProgramNameLists) {

programNames.add(ProgramNameList.getText());
}

List<String> sortedProgramNames = new ArrayList<>(programNames);

Collections.sort(sortedProgramNames);

if (programNames.equals(sortedProgramNames)) {
            System.out.println("Test passed: Data is sorted in ascending order based on Program Name.");
        } else {
            System.out.println("Test failed: Data is not sorted in ascending order based on Program Name.");
        }

}

public void ProgramNameDescendingOrder() {

ProgramName_SortIcon.click();

List<WebElement> ProgramNameLists = driver.findElements(By.xpath("//td[@class='program-name']"));

List<String> programNames = new ArrayList<>();

for(WebElement ProgramNameList : ProgramNameLists) {

programNames.add(ProgramNameList.getText());
}

List<String> sortedProgramNamesDescending = new ArrayList<>(programNames);

Collections.sort(sortedProgramNamesDescending,Collections.reverseOrder());

if (programNames.equals(sortedProgramNamesDescending)) {

           System.out.println("Test passed: Data is sorted in descending order based on Program Name.");
     
} else {

           System.out.println("Test failed: Data is not sorted in descending order based on Program Name.");
       }

}

public void ProgramDescriptionSortIcon() {

ProgramDescription_SortIcon.click();

List<WebElement> ProgramDescriptionLists = driver.findElements(By.xpath("//td[@class='program-description']"));

List<String> programDescriptions = new ArrayList<>();

for(WebElement programDescriptionList : ProgramDescriptionLists) {

programDescriptions.add(programDescriptionList.getText());
}

List<String> sortedProgramDescription = new ArrayList<>(programDescriptions);

Collections.sort(sortedProgramDescription);

if (programDescriptions.equals(sortedProgramDescription)) {

           System.out.println("Test passed: Data is sorted in ascending order based on Program Description.");
       
} else {

           System.out.println("Test failed: Data is not sorted in ascending order based on Program Description.");
       }

}
public void ProgramDescriptionDescendingOrder() {

ProgramDescription_SortIcon.click();

List<WebElement> ProgramDescriptionLists = driver.findElements(By.xpath("//td[@class='program-Description']"));

List<String> programDescriptions = new ArrayList<>();

for(WebElement ProgramDescriptionList : ProgramDescriptionLists) {

programDescriptions.add(ProgramDescriptionList.getText());
}

List<String> sortedProgramDescriptionDescending = new ArrayList<>(programDescriptions);

Collections.sort(sortedProgramDescriptionDescending,Collections.reverseOrder());

if (programDescriptions.equals(sortedProgramDescriptionDescending)) {

           System.out.println("Test passed: Data is sorted in descending order based on Program Description.");
     
} else {

           System.out.println("Test failed: Data is not sorted in descending order based on Program Description.");
       }

}

public void ProgramStatusSortIcon() {

ProgramStatus_SortIcon.click();

List<WebElement> ProgramStatusLists = driver.findElements(By.xpath("//td[@class='program-status']"));

List<String> programstatus = new ArrayList<>();

for(WebElement programStatusList : ProgramStatusLists) {

programstatus.add(programStatusList.getText());
}

List<String> sortedProgramStatus = new ArrayList<>(programstatus);

Collections.sort(sortedProgramStatus);

if (programstatus.equals(sortedProgramStatus)) {

           System.out.println("Test passed: Data is sorted in ascending order based on Program Status.");
       
} else {

           System.out.println("Test failed: Data is not sorted in ascending order based on Program Status.");
       }

}
public void ProgramStatusDescendingOrder() {

ProgramStatus_SortIcon.click();

List<WebElement> ProgramStatusLists = driver.findElements(By.xpath("//td[@class='program-Status']"));

List<String> programStatus = new ArrayList<>();

for(WebElement ProgramStatusList : ProgramStatusLists) {

programStatus.add(ProgramStatusList.getText());
}

List<String> sortedProgramStatusDescending = new ArrayList<>(programStatus);

Collections.sort(sortedProgramStatusDescending,Collections.reverseOrder());

if (programStatus.equals(sortedProgramStatusDescending)) {

           System.out.println("Test passed: Data is sorted in descending order based on Program Status.");
     
} else {

           System.out.println("Test failed: Data is not sorted in descending order based on Program Status.");
       }

}

//7.Pagination Program

@FindBy(xpath = "//*[text()='Next link']")
WebElement NextPageLink;
@FindBy(xpath = "//*[text()='Last link']")
WebElement LastPageLink;
@FindBy(xpath = "//table[@id='program-table']//tr[last()]")
WebElement lastPageRecord;
@FindBy(xpath = "//*[text()='First link']")
WebElement FirstPageLink;
@FindBy(xpath = "//table[@id='program-table']//tr[first()]")
WebElement firstPageRecord;
@FindBy(xpath = "//*[text()='Previous link']")
WebElement PreviousPageLink;
@FindBy(xpath = "//*[text()='Start link']")
WebElement StartPageLink;

public void VerifyNextPageLink() {

NextPageLink.click();

boolean NextLinkSize = Pagination.findElements(By.xpath("//*[text()='Next link']")).size()>0;

if (NextLinkSize) {

               System.out.println("Test passed: Pagination contains the 'Next' link on the next page.");
           
} else {

               System.out.println("Test failed: Pagination does not contain the 'Next' link on the next page.");
           }
}

public void VerifyLastPageLink() {

LastPageLink.click();

boolean isNextPageLinkDisabled = !NextPageLink.isEnabled();

if (lastPageRecord.isDisplayed() && isNextPageLinkDisabled) {

                System.out.println("Test passed: Last page record is displayed, and the 'Next' page link is disabled.");
           
} else {

                System.out.println("Test failed: Last page record is not displayed, or the 'Next' page link is not disabled.");
            }

}

public void VerifyFirstPageLink() {

FirstPageLink.click();

boolean isPreviousPageLinkEnabled = PreviousPageLink.isEnabled();

if(firstPageRecord.isDisplayed() && isPreviousPageLinkEnabled) {

System.out.println("Test passed: First page record is displayed, and the previous page link is enabled");
}else {
System.out.println("Test Failed:First page record is not displayed, and the previous page link is disabled");
}
}

public void VerifyStartPageLink() {

StartPageLink.click();

boolean isPreviousPageLinkDisabled = !PreviousPageLink.isEnabled();

            if (firstPageRecord.isDisplayed() && isPreviousPageLinkDisabled) {
           
                System.out.println("Test passed: Very first page record is displayed, and the 'Previous' page link is disabled.");
           
            } else {
           
                System.out.println("Test failed: Very first page record is not displayed, or the 'Previous' page link is not disabled.");
            }
}

//8.Navigate to other pages from Program page

@FindBy(xpath = "//div[text()='StudentPage']") WebElement StudentLink;
@FindBy(xpath = "//div[text()='Batch']")WebElement BatchLink;
@FindBy(xpath = "//div[text()='Class']")WebElement ClassLink;
@FindBy(xpath = "//div[text()='User']")WebElement UserLink;
@FindBy(xpath = "//div[text()='Assignment']")WebElement AssignmentLink;
@FindBy(xpath = "//div[text()='Attendance']")WebElement AttendanceLink;
@FindBy(xpath = "//div[@id='logout']")WebElement LogoutButton;

public void navigateToOtherPages(String string) {

switch (string) {

case "Batch":
log.info("Click on Batch");
BatchLink.click();
BatchLink.getText();
break;

case "Class":
log.info("Click on Class");
ClassLink.click();
ClassLink.getText();
break;

case "User":
log.info("Click on User");
UserLink.click();
UserLink.getText();
break;

case "Assignment":
log.info("Click on Assignment");
AssignmentLink.click();
AssignmentLink.getText();
break;

case "Attendance":
log.info("Click on Attendance");
AttendanceLink.click();
AttendanceLink.getText();
break;

case "Student":
log.info("Click on Student");
StudentLink.click();
StudentLink.getText();
break;

case "Program":
log.info("click on Program");
ProgramLink.click();
ProgramLink.getText();
break;
}

}
public void logout() {

LogoutButton.click();
}

}