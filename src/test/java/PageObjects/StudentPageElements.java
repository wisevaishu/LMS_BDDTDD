package PageObjects;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;

import utilities.ReadConfig;

public class StudentPageElements extends BaseClass {

public StudentPageElements() {

PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//div[text()='StudentPage']") WebElement Studentbutton;
@FindBy(xpath = "//div[text()='Student Details']")WebElement StudentDetails_Title;
@FindBy(xpath = "//div//a[1][@class='nav-link dropdown-toggle']") WebElement StudentName_DropDown;
@FindBy(xpath = "//div//a[2][@class='nav-link dropdown-toggle']") WebElement batchId_DropDown;
@FindBy(xpath = "//a[text()='drop down']")WebElement dropdown ;
@FindBy(xpath = "//div[@id='search box']")WebElement StudentName_SearchBox;
@FindBy(xpath = "//div[@id='search box']")WebElement BatchId_SearchBox;
@FindBy(xpath = "//div[1][@class='dropdown-menu show']/a[2]")WebElement StudentName2;
@FindBy(xpath = "//div[2][@class='dropdown-menu show']/a[2]")WebElement batchId2;

@FindBy(xpath = "//div[text()='Program']")WebElement ProgramButton;
@FindBy(xpath = "//div[text()='Batch']")WebElement BatchButton;
@FindBy(xpath = "//div[text()='Class']")WebElement ClassButton;
@FindBy(xpath = "//div[text()='User']")WebElement UserButton;
@FindBy(xpath = "//div[text()='Assignment']")WebElement AssignmentButton;
@FindBy(xpath = "//div[text()='Attendance']")WebElement AttendanceButton;
@FindBy(xpath = "//div[@id='logout']")WebElement LogoutButton;


Select select;
Actions action = new Actions(driver);

public void ValidateStudentbutton() {

Studentbutton.click();
}

public int validateBrokenLink(String url) throws IOException {

 HttpURLConnection httpURLConnection = null;
   try {
       URL link = new URL(url);
       httpURLConnection = (HttpURLConnection) link.openConnection();
       httpURLConnection.setConnectTimeout(3000);
       httpURLConnection.connect();
       return httpURLConnection.getResponseCode();
   } finally {
       if (httpURLConnection != null) {
           httpURLConnection.disconnect();
       }
   }
}
public void LocationOfTitle() {

Dimension titleSize = StudentDetails_Title.getSize();
Point titleLocation = StudentDetails_Title.getLocation();

int pageCenterX = driver.manage().window().getSize().getWidth()/2;
int pageCenterY = driver.manage().window().getSize().getHeight()/2;

int expectedTitleCenterX = titleLocation.getX()+titleSize.getWidth()/2;
int expectedTitleCenterY = titleLocation.getY()+titleSize.getHeight()/2;

assertEquals("The Student Details title in not centered horizontally on the page",pageCenterX,expectedTitleCenterX);
assertEquals("The Student Details title is not centered vertically on the page",pageCenterY,expectedTitleCenterY);
}

public void ValidateDropdown() {

action.sendKeys(StudentName_DropDown,Keys.TAB).perform();
action.sendKeys(batchId_DropDown,Keys.TAB).perform();

}

public void studentNameDropdown() {

StudentName_DropDown.click();
}

public void BatchIdDropdown() {

batchId_DropDown.click();
}

public void verifyNameAndIdSpelling() {

   Select studentNameSelect = new Select(StudentName_DropDown);
       Select batchIdSelect = new Select(batchId_DropDown);

       String[] studentNameCorrectSpellings = {"Steve","Robert","Stephen","Sylvia","Sarah"};
       String[] batchIdCorrectSpellings = {"8408","8408","1255","7581","3566"};

       verifydropdownSpelling(studentNameSelect, studentNameCorrectSpellings, "Student Name");

       verifydropdownSpelling(batchIdSelect, batchIdCorrectSpellings, "Batch ID");

}

public void verifydropdownSpelling(Select dropdown,String[] correctSpellings, String dropdownName) {

List<WebElement> option = dropdown.getOptions();

for(int i=0;i<option.size();i++) {

WebElement options = option.get(i);
String optionText = options.getText().trim();

if(i < correctSpellings.length) {

String expectedSpelling = correctSpellings[i];

if(optionText.equals(expectedSpelling)) {

System.out.println(dropdownName +"Student Name and Batch id "+(i+1)+" spelling is correct "+optionText);
}
else {
System.out.println(dropdownName +"Student Name and Batch id "+(i+1)+" spelling is incorrect "+optionText);
}

}
}

}

public void ValidateNameAndIdColor() {

ValidateTextColor(driver,"Student Name");
ValidateTextColor(driver,"batch id");
}

public void ValidateTextColor(WebDriver driver, String optionText) {

select = new Select(dropdown);

WebElement option = select.getOptions().stream().filter(opt -> opt.getText().trim().equals(optionText))
.findFirst().orElse(null);
if(option != null) {

String textColor = option.getCssValue("color");

if(textColor.equalsIgnoreCase("rgb(128,128,128)")) {

System.out.println("The "+optionText+" option is displayed in gray color");
}
else {
System.out.println("The "+optionText+" option is not displayed in gray color");
}
}
}
public void ValidateNameFirstDropdownlable() {

select = new Select(StudentName_DropDown);
String firstOptionLabel = select.getOptions().get(0).getText();
}

public void ValidateIdSecondDropdownlable() {

select = new Select(batchId_DropDown);
String secondOptionLabel = select.getOptions().get(0).getText();
}

public void StudentNameDropdownScroll() {

select = new Select(StudentName_DropDown);
StudentName_DropDown.click();

JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", StudentName_DropDown);

}

public void batchIdDropdownScroll() {

select =new Select(batchId_DropDown);
batchId_DropDown.click();

JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", batchId_DropDown);
}

public void ValidateStudentNameFade() {

select = new Select(StudentName_DropDown);
select.selectByVisibleText("Student Name");

boolean isTextVisible = driver.findElements(By.xpath("//option[contains(text(),'Stephen']")).isEmpty();

if(!isTextVisible) {
System.out.println("The Student Name text is still visible");
}
else {
System.out.println("The Student Name text has faded away");
}
}
public void ValidateBatchIdFade() {

select = new Select(batchId_DropDown);
select.selectByVisibleText("batch id");

boolean isTextVisible = driver.findElements(By.xpath("//option[contains(text(),'1255']")).isEmpty();

if(!isTextVisible) {
System.out.println("The batch id text is still visible");
}
else {
System.out.println("The batch id text has faded away");
}
}

public void ValidateStudentNameSearchBox() {

StudentName_DropDown.click();
StudentName_SearchBox.sendKeys("A");

}
public void ValidateBatchIdSearchBox() {

batchId_DropDown.click();
BatchId_SearchBox.sendKeys("9");

}
public void SelectOnlyStudentName() {

StudentName_DropDown.click();
StudentName2.click();
action.sendKeys(StudentName2,Keys.ENTER).perform();
}

public void SelectOnlyBatchId() {

batchId_DropDown.click();
batchId2.click();
action.sendKeys(batchId2,Keys.ENTER).perform();
}
public void SelectNameAndId() {

StudentName_DropDown.click();
StudentName2.click();
batchId_DropDown.click();
batchId2.click();
action.sendKeys(batchId2,Keys.ENTER).perform();
}

public void navigateToOtherPages(String string) {

switch (string) {
case "Program":
log.info("click on Program");
ProgramButton.click();
break;

case "Batch":
log.info("Click on Batch");
BatchButton.click();
break;

case "Class":
log.info("Click on Class");
ClassButton.click();
break;

case "User":
log.info("Click on User");
UserButton.click();
break;

case "Assignment":
log.info("Click on Assignment");
AssignmentButton.click();
break;

case "Attendance":
log.info("Click on Attendance");
AttendanceButton.click();
break;

case "Student":
log.info("Click on Student");
Studentbutton.click();
break;
}

}
public void logout() {

LogoutButton.click();
}
}