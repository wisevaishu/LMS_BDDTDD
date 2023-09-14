package PageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Base.BaseClass;

public class AttendancePageElements extends BaseClass {
	
	        
	       
	  //-------------------------1.Manage attendance page elements-----------------------------------
	@FindBy(xpath = "//header[contains(text(), 'Manage Attendance')]")
    private WebElement manageAttendanceHeader;

    @FindBy(xpath = "//input[@id='searchInput']")
    private WebElement searchBar;

    @FindBy(xpath = "//button[contains(text(), '+ Add New Attendance')]")
    private WebElement addNewAttendanceButton;

    @FindBy(xpath = "//table[@id='attendanceTable']")
    private WebElement dataTable;

    @FindBy(xpath = "//table[@id='attendanceTable']//th")
    private List<WebElement> tableColumnHeaders;

    @FindBy(xpath = "//table[@id='attendanceTable']//td[contains(@class, 'edit-icon')]")
    private List<WebElement> editIcons;

    @FindBy(xpath = "//table[@id='attendanceTable']//td[contains(@class, 'delete-icon')]")
    private List<WebElement> deleteIcons;

    @FindBy(xpath = "//table[@id='attendanceTable']//th[contains(@class, 'sort-icon')]")
    private List<WebElement> sortIcons;

    @FindBy(xpath = "//table[@id='attendanceTable']//input[@type='checkbox']")
    private List<WebElement> checkBoxes;

    @FindBy(xpath = "//div[@class='dataTables_info']")
    private WebElement entriesInfo;

    @FindBy(xpath = "//div[@class='dataTables_paginate paging_simple_numbers']")
    private WebElement paginationControl;

    @FindBy(xpath = "//div[@class='dataTables_info']")
    private WebElement footerText;

    // Add getter methods for these WebElements

    public WebElement getManageAttendanceHeader() {
        return manageAttendanceHeader;
    }

    public WebElement getSearchBar() {
        return searchBar;
    }

    public WebElement getAddNewAttendanceButton1() {
        return addNewAttendanceButton;
    }

    public WebElement getDataTable() {
        return dataTable;
    }

    public List<WebElement> getTableColumnHeaders() {
        return tableColumnHeaders;
    }

    public List<WebElement> getEditIcons() {
        return editIcons;
    }

    public List<WebElement> getDeleteIcons() {
        return deleteIcons;
    }

    public List<WebElement> getSortIcons() {
        return sortIcons;
    }

    public List<WebElement> getCheckBoxes() {
        return checkBoxes;
    }

    public WebElement getEntriesInfo() {
        return entriesInfo;
    }

    public WebElement getPaginationControl() {
        return paginationControl;
    }

    public WebElement getFooterText() {
        return footerText;
    }
	    /////----------------------------popup------------------
	    
	    @FindBy(id = "grayTextElement")
	    private WebElement grayTextElement;
	    public WebElement getGrayTextElement() {
	        return grayTextElement;
	    }
	    
	    @FindBy(id = "closeButton")
	    private WebElement closeButton;

	    @FindBy(id = "programDropdown")
	    private WebElement programDropdown;

	    @FindBy(id = "classDropdown")
	    private WebElement classDropdown;

	    @FindBy(id = "studentDropdown")
	    private WebElement studentDropdown;

	    @FindBy(id = "attendanceDropdown")
	    private WebElement attendanceDropdown;

	    @FindBy(id = "saveButton")
	    private WebElement saveButtonpopup;

	    @FindBy(id = "cancelButton")
	    private WebElement cancelButton;

	    @FindBy(id = "datePicker")
	    private WebElement datePicker;

	    // Add more @FindBy annotations for other elements as needed

	    // Getter methods for the elements
	    public WebElement getCloseButton() {
	        return closeButton;
	    }

	    public WebElement getProgramDropdown() {
	        return programDropdown;
	    }

	    public WebElement getClassDropdown() {
	        return classDropdown;
	    }

	    public WebElement getStudentDropdown() {
	        return studentDropdown;
	    }

	    public WebElement getAttendanceDropdown() {
	        return attendanceDropdown;
	    }

	    public WebElement getSaveButton() {
	        return saveButtonpopup;
	    }

	    public WebElement getCancelButton() {
	        return cancelButton;
	    }

	    public WebElement getDatePicker() {
	        return datePicker;
	    }
	    ///-----------------------------add new attendance
	    
	    
	   
	    
	    
	    // EditAttendance--------------------------------------------------------------------
	    @FindBy(id = "programName")
	    private WebElement programNameField;

	    @FindBy(id = "className")
	    private WebElement classNameField;

	    @FindBy(id = "studentName")
	    private WebElement studentNameField;

	    @FindBy(id = "attendanceInput")
	    private WebElement attendanceField;

	    @FindBy(id = "attendanceDateInput")
	    private WebElement attendanceDateField;

	    @FindBy(id = "saveButton")
	    private WebElement saveButton;

	    @FindBy(id = "successMessage")
	    private WebElement successMessageinedit;

	   

	    public void fillProgramName(String programName) {
	        programNameField.sendKeys(programName);
	    }

	    public void fillClassName(String className) {
	        classNameField.sendKeys(className);
	    }

	    public void fillStudentName(String studentName) {
	        studentNameField.sendKeys(studentName);
	    }

	    public void fillAttendance(String attendance) {
	        attendanceField.sendKeys(attendance);
	    }

	    public void fillAttendanceDate(String attendanceDate) {
	        attendanceDateField.sendKeys(attendanceDate);
	    }

	    public void clickSaveButton() {
	        saveButton.click();
	    }

	    public String getSuccessMessageinedit() {
	        return successMessageinedit.getText();
	    }
	    
	    
	    
	    
	    
	    //deleteAttendance-----------------------------------------------------------------------------
	    @FindBy(xpath = "//button[@class='delete-button']")
	    private WebElement deleteButtonsingle;

	    @FindBy(id = "alertYesButton")
	    private WebElement yesButtonInAlert;

	    @FindBy(id = "alertNoButton")
	    private WebElement noButtonInAlert;

	    public void clickDeleteButtonInDataTable() {
	        deleteButtonsingle.click();
	    }

	    public boolean isAlertPresent() {
	        try {
	            driver.switchTo().alert();
	            return true;
	        } catch (NoAlertPresentException e) {
	            return false;
	        }
	    }

	    public void clickYesButtonInAlert() {
	        Alert alert = driver.switchTo().alert();
	        alert.accept();
	    }

	    public void clickNoButtonInAlert() {
	        Alert alert = driver.switchTo().alert();
	        alert.dismiss();
	    }
	    
	    
	    
	    
	    
	    
	    
	    
//delete multiple-------------------------------------------------------	    
	 
	    
	    // Locator for the checkboxes in the data table
	    @FindBy(xpath = "//input[@type='checkbox']")
	    private List<WebElement> checkboxes;

	    // Locator for the delete button under the header
	    @FindBy(id = "delete-button")
	    private WebElement deleteButton;

	    // Locator for the success message
	    @FindBy(id = "success-message")
	    private WebElement successMessage;

	    // Locator for the yes button in the delete alert
	    @FindBy(id = "yes-button")
	    private WebElement yesButton;

	    // Locator for the no button in the delete alert
	    @FindBy(id = "no-button")
	    private WebElement noButton;

	  

	    // Methods to interact with the elements
	    public void clickRowLevelCheckbox(int index) {
	        if (index >= 0 && index < checkboxes.size()) {
	            checkboxes.get(index).click();
	        }
	    }

	    public void clickHeaderDeleteButton() {
	        deleteButton.click();
	    }

	    public void clickYesButtonInDeleteAlert() {
	        yesButton.click();
	    }

	    public void clickNoButtonInDeleteAlert() {
	        noButton.click();
	    }

	    public String getSuccessMessage() {
	        return successMessage.getText();
	    }
	
//--------------------------------Pagination-------------------------------------------------
	//-------------------------------------------------------------------------------------------------
	
	@FindBy(xpath = "//[@class='pageNumber']")
	public WebElement pageNumberElement ;
	
	@FindBy(xpath = "//button[@class='pagination-right-arrow']") private WebElement rightArrowLocator;

 @FindBy(xpath = "//button[@class='pagination-left-arrow']")
	public WebElement leftArrowLocator;

 

 @FindBy(className = "pagination-next") // Replace with the actual locator for the next page arrow
 private WebElement nextPageArrow;

 @FindBy(className = "pagination-previous") // Replace with the actual locator for the previous page arrow
 private WebElement previousPageArrow;



 // Method to check if the right arrow is enabled
 public boolean isRightArrowEnabled() {
     return rightArrowLocator.isEnabled();
 }


 // Method to check if the left arrow is enabled
 public boolean isLeftArrowEnabled() {
     return leftArrowLocator.isEnabled();
 }

 // Method to check if pagination controls are enabled based on the presence of the data table
 public boolean arePaginationControlsEnabled() {
     return dataTable.isDisplayed(); // Adjust this condition based on how your pagination controls are displayed
 }

 // Method to check if the next page is enabled based on the presence of the next page arrow
 public boolean isNextPageEnabled() {
     return nextPageArrow.isEnabled();
 }

 // Method to check if the previous page is enabled based on the presence of the previous page arrow
 public boolean isPreviousPageEnabled() {
     return previousPageArrow.isEnabled();
 }

 // Method to check if the right arrow is enabled on a given page
 public boolean isRightArrowEnabled(int currentPage, int totalEntriesPerPage) {
     int maxPages = (int) Math.ceil((double) totalEntriesPerPage / 5);
     return currentPage < maxPages;
 }

 // Method to check if the left arrow is enabled on a given page
 public boolean isLeftArrowEnabled(int currentPage) {
     return currentPage > 1;
 }

 // Method to check if the next page is enabled based on the total entries and current page
 public boolean isNextPageEnabled(int totalEntries, int currentPage) {
     int entriesPerPage = 5;
     int maxPages = (int) Math.ceil((double) totalEntries / entriesPerPage);
     return currentPage < maxPages;
 }
 
 
 
 //--------------------------------------Navigation-----------------------------------------
 
 
	@FindBy(xpath = "//a[@href='Attendance']")
	WebElement Attendancelink;
	@FindBy(xpath = "//a[@href='Student']")
	WebElement Studentlink;
	@FindBy(xpath = "//a[@href='Program ']")
	WebElement ProgramLink;
	@FindBy(xpath = "//a[@class='Batch']")
	WebElement BatchLink;
	@FindBy(xpath = "//a[@href='/User']")
	WebElement UserLink;
	@FindBy(xpath = "//a[@href='Assignment']")
	WebElement AssignmentLink;
	@FindBy(xpath = "//a[@href='Class']")
	WebElement ClassLink;
	@FindBy(xpath = "//a[@href='Logout']")
	WebElement LogoutLink ;
	
	
public void navigateToAttendance() {
		
	Attendancelink.click();
	}
	// Verify the title of the page
	public String verifyPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public void navigateToStudent() {
		
		Studentlink.click();
	}
public void navigateToProgram() {
		
	ProgramLink.click();
}
	public void navigateToBatch() {
			
		BatchLink.click();
		
	}
		public void navigateToUser() {
			
			UserLink.click();
		}
		public void navigateToAssignment() {
			
			AssignmentLink.click();
		}
	  public void navigateToclass() {
			Studentlink.click();
		}
   public void navigateToLogout() {
 	  LogoutLink.click();
   }




	public String getUrl() {
		// TODO Auto-generated method stub
		return null;
	}




	public boolean isDeleteIconEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean areSelectedAttendanceDetailsPresent() {
		// TODO Auto-generated method stub
		return false;
	}


	public void clickMultipleRowLevelCheckboxes() {
		// TODO Auto-generated method stub
		
	}


	public boolean areRowLevelCheckboxesTicked() {
		// TODO Auto-generated method stub
		return false;
	}

	public void clickSingleRowLevelCheckboxes() {
		// TODO Auto-generated method stub
		
	}




	public boolean areSelectedRowLevelCheckboxesTicked() {
		// TODO Auto-generated method stub
		return false;
	}




	public String getCurrentPageTitle() {
		// TODO Auto-generated method stub
		return null;
	}




	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}




	public void clickButton(String string) {
		// TODO Auto-generated method stub
		
	}




	public Object getAddNewAttendanceButton() {
		// TODO Auto-generated method stub
		return null;
	}




	public WebElement getProgramLabel() {
		// TODO Auto-generated method stub
		return null;
	}




	public WebElement getClassLabel() {
		// TODO Auto-generated method stub
		return null;
	}




	public WebElement getStudentLabel() {
		// TODO Auto-generated method stub
		return null;
	}




	public WebElement getAttendanceLabel() {
		// TODO Auto-generated method stub
		return null;
	}
	public Select getClassDropdown1() {
        return new Select(classDropdown);
    }



	public WebElement getDateLabel() {
		// TODO Auto-generated method stub
		return null;
	}




	public WebElement getSaveButtonpopup() {
		// TODO Auto-generated method stub
		return null;
	}




	public String getLabelOrder() {
		// TODO Auto-generated method stub
		return null;
	}




	public void clickProgramNameDropdown() {
		// TODO Auto-generated method stub
		
	}




	public String getSelectedProgramName() {
		// TODO Auto-generated method stub
		return null;
	}




	public void clickClassNameDropdown() {
		// TODO Auto-generated method stub
		
	}




	public String getSelectedClassName() {
		// TODO Auto-generated method stub
		return null;
	}




	public String getSelectedAttendance() {
		// TODO Auto-generated method stub
		return null;
	}




	public String getAttendanceInTable() {
		// TODO Auto-generated method stub
		return null;
	}




	public String getAttendanceFieldText() {
		// TODO Auto-generated method stub
		return null;
	}




	public String getSelectedDate() {
		// TODO Auto-generated method stub
		return null;
	}




	public void clickNextMonthArrow() {
		// TODO Auto-generated method stub
		
	}




	public void clickPreviousMonthArrow() {
		// TODO Auto-generated method stub
		
	}




	public boolean isNextMonthCalendarVisible() {
		// TODO Auto-generated method stub
		return false;
	}




	public boolean isPreviousMonthCalendarVisible() {
		// TODO Auto-generated method stub
		return false;
	}




	public boolean isDateHighlighted(String currentDate) {
		// TODO Auto-generated method stub
		return false;
	}




	public void selectDateFromDatePicker(String futureDate) {
		// TODO Auto-generated method stub
		
	}




	public void clickDatePickerButton() {
		// TODO Auto-generated method stub
		
	}

	public void clickNavigationBarLink(String navigationOption) {
		// TODO Auto-generated method stub
		
	}

	public Object getHeaderText() {
		// TODO Auto-generated method stub
		return null;
	}




	





}
