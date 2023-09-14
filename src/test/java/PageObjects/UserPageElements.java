package PageObjects;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;

public class UserPageElements extends BaseClass {
	
	///AddNewuser==========================================================================
private static WebDriver driver;
	
	//@FindBy(xpath="//input[@type='NewUser']") WebElement NewUser;
	
	//@FindBy(xpath="//input[@id='PopUp']")WebElement popup;
	
	//@FindBy(xpath="//input[@name='FirstName']")WebElement FirstName;
	
	//@FindBy(xpath="//input[@name='LastName']")WebElement LastName;
	
	//@FindBy(xpath="//input[@text='Location']")WebElement Location;
	
	@FindBy(xpath="//input[@text='noclasses']") WebElement NoOfClasses;
	
	@FindBy(xpath="//input[@text=email") WebElement Email;
	
	@FindBy(xpath="//input[@text='RoleStatus'") WebElement RoleStatus;
	
	@FindBy(xpath="//input[@text='VisaStatus'") WebElement VisaStatus;
	
	@FindBy(xpath="//input[@type='submit']") WebElement SubmitBtn;
	
	







//Method Creation

public void AddNewUser(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

//Addnewuser
    public void addingNewUser() {
	NewUser.click();   
}

//Popupverifyfields
    public void PopUp() throws InterruptedException {
	Thread.sleep(3000);
	//driver.switchTo().alert().accept();
	
}
    //Verifyall the fields in Add/User popup Page
    public void verifyfieldsvisibility(WebDriver driver,By xpath){
      WebElement Fields = driver.findElement(By.tagName("input"));
       if (Fields.isDisplayed()){
       System.out.println("field is visible"+ Fields);
       }
       
    else{
    System.out.println("field is not Visible"+Fields);
    }
       }
    public void VerifyFirstname() {
		   Boolean firstName=FirstName.isDisplayed();
			   if(firstName) {
	 System.out.println("Name is Displayed"+FirstName);
				  
			   }
			   else {
				   System.out.println("FirstName not is Displayed");
			   }
		   }
    //verifylastname
    public void VerifyLastname() {
		   Boolean lastName=FirstName.isDisplayed();
			   if(lastName) {
	 System.out.println("LastName is Displayed"+lastName);
				  
			   }
			   else {
				   System.out.println("LastName not is Displayed");
			   }
		   }
    //verify fields
    public void VerifyFields() {
		   Boolean location=Location.isDisplayed();
			   if(location) {
	 System.out.println("Location is Displayed"+location);
				  
			   }
			   else {
				   System.out.println("Location not is Displayed");
			   }
		   }
    //User enters firstname in Mandatory fields
    
    public void Firstnamefields(String name) {
		FirstName.sendKeys(name);
		//savebutton.click();
    }
		
		//User enters Lastname in Mandatory fields
	    
	    public void Lastnamefields(String name) {
			LastName.sendKeys(name);
			//savebutton.click();
}
    
//User enters firstname in Mandatory fields
    
    public void enterfields(String name) {
		FirstName.sendKeys(name);
		//savebutton.click()
    }

//User enters Location in Mandatory fields

public void Loation(String name) {
	Location.sendKeys(name);
	//savebutton.click();
}


//User enters firstname in Mandatory fields

public void Rolestatus(String name) {
	RoleStatus.sendKeys(name);
	//Cursor.MOVE_CURSOR();
}

//User enters Visastatus in Mandatory fields

    public void Visastatus(String name) {
	VisaStatus.sendKeys(name);
	//savebutton.click();
}
//User clicks submit button after giving Mandatory fields

    public void submitbutton() {
	SubmitBtn.click();
	driver.navigate().back();
}
//check the user is added on the table
    public void visibilityaddedUser() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation")));
    WebElement table = driver.findElement(By.id("Name"));
    boolean Useradded = table.getText().contains("Michelle Leo")
    &&
    table.getText().contains("Lasvegas");
    
    if(Useradded) {
   	 System.out.println("User is added to the table "+Useradded);
   				  
   			   }
   			   else {
   				   System.out.println("User is not added to the table ");
   			   }
   		   }
    
    //error messages for invalid fields
    public void Verifyinvalidfields() {
		   
			   boolean username = false;
			if(username) {
	 System.out.println("User given invalid inputs");
				  
			   }
			   else {
				   System.out.println("User has given valid values");
			   }
		   }
    //Mandatory fields blank error message
    public void Mandatoryfieldserrormsg () {
    //boolean ErrorMsg=ErrorMsg.isDisplayed();
    	 	
	   if(Location.getText().isEmpty()) {
     System.out.println(" missing mandatory field");
		  
	   }
	   else {
		   System.out.println("Not missing mandatory field");
	   }
}
    
    
    //delete user====================================
@FindBy(xpath="//input[@value='delete']") WebElement deleteIcon;
	
	@FindBy(xpath="//input[@id='alert']")WebElement alert;
	
	@FindBy(xpath = "//button[text()='yes']")WebElement YesBtn;
	
	@FindBy(xpath = "//button[text()='no']")WebElement NoBtn;
	
	@FindBy(xpath="//input[@id='BatchName']")WebElement UserName;
	
	@FindBy(xpath="//*[id='Table-row']") WebElement tablerow;
	@FindBy(xpath="//*[id='Table-column']") WebElement tablecolumns;
	
	public void DeleteUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Verify Delete icon is enabled
	 public void verifyDeleteicon() {
		   Boolean Delete = deleteIcon.isEnabled();
		   if(deleteIcon.isEnabled()) {
			   System.out.println("DeleteIcon is Enable in ManageUser");
			  
		   }
		   else {
			   System.out.println("DeleteIcon is not  Enable ManageUser");
			  log.info("Delete icon is enabled");
		   }
	 }
	//Validate delete icon click
	public void Deleteicon() {
		deleteIcon.click();
		log.info("Admin cliks Delete icon");
	}
	//Accept alert with yes or no options
	  public void verifyDeleteAlert() {
	        
	       Alert alert = driver.switchTo().alert();
           String alertMessage = alert.getText();
            if (alertMessage.contains("Are you sure you want to delete?")) {
	           System.out.println("The alert message with yes or no displays ");
	        alert.accept();}
	  }
	  
	//Verify Yes button
	  public void YesBtn() throws InterruptedException {
		  Thread.sleep(3000);
			YesBtn.click();
		}
	  //verify no button
		public void NoBtn() throws InterruptedException {
			Thread.sleep(3000);
			NoBtn.click();
		}
		//verifyUserDeletedAlert pops in the Table

		public void UserDeletedAlert () {
		    
		    Alert alert = driver.switchTo().alert();

		     String alertMessage = alert.getText();

		     if (!alertMessage.contains("Are you sure you want to delete this UserName abc?")) {
		       System.out.println("Are you sure want to delete ?");
		    }
		     alert.accept();
		     
             YesBtn.click();
		     String deletedUserName = "Deleted Username abc"; 
		    boolean UserDeleted = true;
           if (UserName.equals(deletedUserName)) {
		            	System.out.println("User name is Deleted"); 
		                }
		            else {
		            	System.out.println("User name is not Deleted");	
		            }
		}
		//check whether the deleted User is still available in the table
		public void UserNotDeleted() {
			
			boolean UserAvaiTable;
			if (UserName("abc").isDisplayed()) {
				System.out.println("Deleted User is still present in the Table");
			}
				else {
					System.out.println("Deleted User is not present in the Table");
			}
		}
		private WebElement UserName(String string) {
			
			return null;
		}
		
		//delete multiple user
		@FindBy(xpath="//input[@type='Delete']")WebElement  Deleteicon;
		@FindBy(xpath="//Button[@Disabled='true']") WebElement DisableDeleteBtn;
		List<WebElement> checkboxes = driver.findElements(By.id("checkbox"));
		@FindBy(xpath="//input[@type='checkbox1'and @checked='checked']") WebElement oneCheckBox;
		@FindBy(xpath="//input[@Type='checkbox1 and checkbox2") WebElement multipleCheckBox;
		@FindBy(xpath="//tr[contains(@data-id-03']")WebElement dataTablerow03;
		
		public void DeleteMultipleUser(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		//verify none of the datatable chekbox selected
		  public void verifyUserCheckboxSelected() {
		        
		        
		        boolean tablecheckbox;
		       // for (WebElement checkbox : checkboxes) {
		            if (!oneCheckBox.isSelected()) {
		               System.out.println("One or more checkboxes in the data table are not selected");
		            }
		            else {
		            	System.out.println("One or more checkboxes in the data table are selected");
		            }
		        }
		//Verify delete icon disabled under Manageuser
			public void VerifyDeleteIconMU() {
		          Boolean Delete = Deleteicon.isEnabled();
		          if(Deleteicon !=null) {
		           System.out.println("DeleteIcon is Enabled");
		           
		          }
		          else {
		           System.out.println("DeleteIcon is not Enabled");
		          }
		          }
			
		   public void onecheckbox() {
			  oneCheckBox.click();
			 
		  }
		 //verify one check box/row is selected
			public void checkboxselec() {
				
			        
			        List<WebElement> SingleCheckBox = driver.findElements(By.tagName("tr")); 
			        
			         boolean OneCheckboxSelected = false;
			      for (WebElement checkbox : SingleCheckBox) {
			            if (OneCheckboxSelected ) {
			            	OneCheckboxSelected = true;
			            	System.out.println("singlecheckbox is selected");
			            }
			            else
			            	System.out.println("singlecheckbox is not selected");
			}
			}    
			    //delete icon to click
			  	
			      public void clickdeleteicon() {
			    	  Deleteicon.click();
			  		log.info("Delete Icon under MB is selected");
			  	}
			  //Delete one batchrow
				
			  	public void RowTableDelete() {
					dataTablerow03.isSelected();
					Deleteicon.click();
					log.info("02 Row in the BatchDataTable is Deleted");
				}      
				//one/or two is Selected
				
			  	public void TwoRowSelected() {
				multipleCheckBox.isSelected();
					boolean twochkbox = true;
				if (multipleCheckBox.isSelected()) {
					System.out.println("Tworows in BatchDataTable is Selected");}
					else {
						System.out.println("Tworows in BatchDataTable  is not Selected");
					}
				log.info("TwoRow in the BatchDataTable is Selected");
				}
			  	//edit new user===============================
			  	//@FindBy(xpath="button[id=edit']") WebElement EditIcon;
				//@FindBy(xpath="//input[@id='PopUp']") WebElement popup;
				@FindBy(xpath="button[id=submit']") WebElement submitBtn;
				@FindBy(xpath="	//div[@role='alert']")WebElement ErrorMessg;
				@FindBy(name="firstname")WebElement FirstName;
				@FindBy(name="lastname")WebElement LastName;
				@FindBy(name="location")WebElement Location;
				@FindBy(xpath="//*[@id='dropBox']") WebElement DropBox;
				@FindBy(xpath="//input[@id='MandatoryField']") WebElement MandatoryField;
				@FindBy(xpath="//input[@id='Description']") WebElement description;
				public void editNewUserPages(WebDriver driver) {
					this.driver = driver;
					PageFactory.initElements(driver,this);
				}
				//verify Edit Icon
				 public void verifyEditIconenable() {
					   Boolean Edit = EditIcon.isEnabled();
					   if(Edit) {
						   System.out.println("EditIcon is Enable");
						  
					   }
					   else {
						   System.out.println("EditIcon not is Enable");
					   }
				 }
				 //Edit Icon click
				 public void ClickEditIcon() {
					 EditIcon.click();
				 }
				 
				   //New User fields Update
				 public void updateFields(String fname,String lname) throws InterruptedException {
					  EditIcon.click();
					 Thread.sleep(3000);
					  FirstName.sendKeys(fname);
					  LastName.sendKeys(lname);
					 submitBtn.click();
							
						}
				 //validate invalid fields msg
				 public String invalidCredentialMessg() {
						return ErrorMessg.getText();
					}
				 //validate fields clear
				 public void cleartext() {
					 FirstName.clear();
					 LastName.clear();
				 }
				//verify popup appearance
				 public void PopUpAppearance() throws InterruptedException {
						Thread.sleep(3000);
						 WebElement popUp = driver.findElement(By.id("popup-id"));
					        if (!popUp.isDisplayed()) {
					            throw new AssertionError("Pop-up is not displayed.");
					        }
				 }
				 //validate with Update the fields with valid values and click submit
				 public void UpdateFields() {
				 submitBtn.click();
				 }
				 //Updated fields availablity
				 public void UpFieldsAppearancce() {
					 log.info("The Data given in the fields are Updated");
				 }
				 
			//Update fields with invalid inputs
				 public void InvalidInputFieldsAndSubmit () {
					 FirstName.sendKeys("Invalid_FirstName");
				        LastName.sendKeys("Invalid_LastName");
				        Location.sendKeys("Invalid_Location");

				        submitBtn.click();
				 }  
				        
				//Error Msg
					 public String InvalidCredentialMessg() {
							return ErrorMessg.getText();
						}
					//Erase data from Mandatory field
					  public void deleteUserMandatory() {
				   	   MandatoryField.clear();
				   	   log.info(" Mandatory field data is erased");
					  }
					  //Erase data from description field
					  public void deleteUserDescription() {
				   	   description.clear();
				   	   log.info(" -------Description field data is erased---------");
				      }
					  ///uservalidation=================================
					  boolean status;
						
						 @FindBy(xpath = "//a[@href='User']")WebElement User;
						 
						 @FindBy(xpath="//table[@id='Manage user page']") WebElement UserTableHeader;
						 
						// @FindBy(xpath="//table[@id='Tableheader']") WebElement tableHeaders;

						 @FindBy(xpath="//input[@type='popup']")WebElement  popup;
						 @FindBy(xpath="//input[@type='Delete']")WebElement  DeleteIcon;
						 @FindBy(xpath="//input[@type='UserNavbar']")WebElement  UserNav;
						 
						 @FindBy(xpath="//input[@type='NewUser']" )WebElement NewUser;
						 
						 @FindBy(xpath="//input[@type='AssignStaff']" )WebElement Assignstaff;
						 
						 @FindBy(xpath="//input[@id='searchtextbox']")WebElement SearchTextBox;
						 
						 @FindBy(xpath="//input[@type='checkbox']")WebElement Checkbox;
						
						 @FindBy(xpath="//input[@type='edittext']") WebElement  EditIcon;
						 
						 @FindBy(xpath="//input[@type='Delete']")WebElement  DeleteButton;
						 @FindBy(xpath ="//td[value() ='1']")WebElement data1;
						 
						 @FindBy(xpath = "//a[@id ='dashboardsmsg']")
							WebElement dashboardlandmsg;
						
						 List<WebElement> tableHeaders = (List<WebElement>) dashboardlandmsg;
						 @FindBy(xpath ="//td[value() ='1']")
						 WebElement data2;
						 
						 
						 
						 
						 public void UserPageValidationELe(WebDriver driver) {
							  this.driver = driver;
							  PageFactory.initElements(driver, this);
							 }
						 //verify User button on the manageUser page
							  public void UserBtn() {
							   User.click();
							   log.info("Admin clicked the user button");
							  }
						 //verify ManageUser Title
							  public String getManageUser() {
								   return driver.getTitle();
							  }
					     //Verify manage user url
							  public String currturl() {
								   return driver.getCurrentUrl();
								   
								  }
							  //verify navigation bar
							  public void ClickNavigationBar() {
								  UserNav.click();
							  }
							  public static  void verifyManageUserTitle() {

							        String manageuserTitle= driver.getTitle();
							         log.info("manageuserTitle");
							        String expectedManagePageTitle="Manage user";
							      
							       Assert.assertEquals(manageuserTitle, expectedManagePageTitle);
							        log.info("---------Manage user Title verified-------");
							        
							      }
							//  public void NextPagebutton() {
							//	  NextpageButton.click();
							 // public void paginationcheck() {
							//	  Paginationelements.  
							 // }
							  
						//VerifyUserTableHeader	  
							  public void verifyUserTableHeader() {
							         List<WebElement>rows=UserTableHeader.findElements(By.tagName("tr"));
							         for (WebElement r:rows) {
							          System.out.println(r.getText());
							         }
							  }
							  //verify admin is on Dashboard page afterlogin
							  public void verifyDashBoardpg() {
								  try {
										status = dashboardlandmsg.isDisplayed();
										assertTrue(status);
							        log.info("Dashboard page is displayed");
							} catch (AssertionError e) {
										log.error("Dashboard page is not displayed");
										System.out.println(e.getMessage());
									}				
									}
							  
							  //verify pagination controls under the data table
							  public void paginationchk()
								{
									 Object colName = null;
									 List<WebElement> result = null;
							        for (int i = 0; i < tableHeaders.size(); i++) {
										if (tableHeaders.get(i).getText().equals(colName)) {
							                break;
							            }
							        }
							        boolean goNext = false;
							        do {
							        	for (int i = 0; i < tableHeaders.size(); i++) {
							                data2.getText();
								        }
							        	 boolean paginationNext = false;
										goNext = paginationNext;
							             if (paginationNext) {
							                 data2.click();
							             }
							           } while (goNext);
							             return ;
							        }
							  
						//VerifyDeleteIcon
					    public void verifyDeleteIcon() {
						Boolean Delete = DeleteIcon.isEnabled();
						if(Delete) {
						System.out.println("DeleteIcon is Enable");
						              
						 }
						 else {
						 System.out.println("DeleteIcon not is Enable");
						  }
						}
							  
						//VerifyNewUser
						  public void verifyNewUser() {
						  Boolean User=NewUser.isDisplayed();
						  if(User) {
						  System.out.println("+A NewUserIcon is Displayed");
							              
						  }
						  else {
						  System.out.println("+A NewUserIcon not is Displayed");
						  }
						  }
							
						 //VerifyAssignstaff
						  public void verifyAssignstaff() {
						  Boolean AssiStaff= Assignstaff.isDisplayed();
						  
						  if(AssiStaff) { 
						  System.out.println("+Assignstaffis Displayed");
								              
						  }
						  else {
						  System.out.println("+Assignstaff not is Displayed");
						  }  
						  }  
						  
						  //VerifysearchTextBox
						public void verifysearchTextbox() {
						Boolean TextBox=SearchTextBox.isDisplayed();
						 if(TextBox) {
						System.out.println("SearhTextBox is Displayed");
									              
						}
					    else {
					   System.out.println("SearhTextBox not is Displayed");
					    }
						  }
									             
						//Verify thecheckbox	
						public void verifyCheckBox() {
						Boolean Check=Checkbox.isDisplayed();
						if(Check) {
					    System.out.println("CheckBox is Displayed");
										                 
						}
						else {
						System.out.println("CheckBox is not Displayed");
						}
						}
						
						//VerifyEditIcon
						public void verifyEditIcon() {
						 Boolean Edit = EditIcon.isEnabled();
						 if(Edit) {
						System.out.println("EditIcon is Enable");
											          
						 }
						else {
					   System.out.println("EditIcon not is Enable");
						 }
						}
											         
						//VerifyDeletebutton					         
						public void verifyDeletebutton() {
						Boolean Delete = DeleteButton.isEnabled();
						if(Delete) {
					   System.out.println("DeleteButton is Enable");
											              
						 }
					    else {
						System.out.println("DeleteButton not is Enable");
						  }
						}				             
											            
						//verify popup appearance
					public void PopUp1() {
						  try {
								status = popup.isDisplayed();
								assertTrue(status);
					      log.info("new user details  is displayed");
					} catch (AssertionError e) {
								log.error("new user details  is not displayed");
								System.out.println(e.getMessage());
							}				
					}
		
}
