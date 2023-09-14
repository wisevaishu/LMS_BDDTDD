package PageObjects;

import org.apache.hc.client5.http.entity.mime.Header;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.model.Log;
import java.util.List;
import Base.BaseClass;


import org.testng.Assert;
public class BatchPageValidationEle extends BaseClass {
	
	 public BatchPageValidationEle() {
		  
		  PageFactory.initElements(driver, this);
		 }
	 
	 @FindBy(xpath = "//a[@href='batch']")
	 WebElement batch;
	 
	 @FindBy(xpath = "//a[@href='batchheader']")WebElement BatchHeader;
	 
	 @FindBy(xpath = "//a[contains(text='Next')]") WebElement Batchpagenext;
	 
	 @FindBy(xpath = "//a[contains(text='previous')]") WebElement Batchpageprevious;
	 
	 @FindBy(xpath="//table[@id='Manage Batch']")WebElement TableHeader;
	 
	 @FindBy(xpath="//input[@type='edittext']")
	 WebElement  EditIcon;
	 
	 @FindBy(xpath="//input[@type='Delete']")
	 WebElement  DeleteIcon;
	 
	 @FindBy(xpath="//input[@type='NewBatch']")
	 WebElement NewBatch;
	 
	 @FindBy(xpath="//input[@type='checkbox']")
	 WebElement Checkbox;
	 
	 
	
		  public void Batch() {
		   batch.click();
		  }
		  
		  public String getManageBatch() {
		   return driver.getTitle();
		  }
		  
		    public String currturl() {
		   return driver.getCurrentUrl();
		  }
	
		    public static void verifyManageBatchTitle() {

		        String managebatchTitle= driver.getTitle();
		         log.info("managebatchTitle");
		        String expectedManagePageTitle="Manage Batch";
		       Assert.assertEquals(managebatchTitle,expectedManagePageTitle);
		       
		        log.info("---------Manage batch Title verified-------");
		      }
		        //VerifyBatchheader
		       
		       
		        public  boolean verifyBatchHeader() {
		        	boolean BatchtypeHeader;
		        	try
		        	{
		        		BatchtypeHeader =BatchHeader.isDisplayed();
		        		return BatchtypeHeader ;
		        	}
		        	catch (Exception e)
		        	{
		        		return false;
		        	}
		        }
		        
		        //VerifyBatchpagination
		        public  boolean verifyBatchPageNext() {
		        	boolean pagination;
		        	try
		        	{
		        		pagination =Batchpagenext.isDisplayed();
		        		return pagination;
		        	}
		        	catch (Exception e)
		        	{
		        		return false;
		        	}
		        }
		        
		        public  boolean verifyBatchPrevious() {
		        	boolean pagination;
		        	try
		        	{
		        		pagination =Batchpageprevious.isDisplayed();
		        		return pagination;
		        	}
		        	catch (Exception e)
		        	{
		        		return false;
		        	}
		        }
		      //VerifyTableheader
			       
		        public  void verifyTableHeader() {
		         List<WebElement>rows=TableHeader.findElements(By.tagName("tr"));
		         for (WebElement r:rows) {
		          System.out.println(r.getText());
		         }
		        }
		       //Verify Edit Icon 
		        public void verifyEditIcon() {
		         Boolean Edit = EditIcon.isEnabled();
		         if(Edit) {
		          System.out.println("EditIcon is Enable");
		          
		         }
		         else {
		          System.out.println("EditIcon not is Enable");
		         }
		        }
		         //Verify DeleteIcon
		         public void verifyDeleteIcon() {
		             Boolean Delete = DeleteIcon.isEnabled();
		             if(Delete) {
		              System.out.println("DeleteIcon is Enable");
		              
		             }
		             else {
		              System.out.println("DeleteIcon not is Enable");
		             }
		             
		            }
		        //VerifyNew Batch
		            public void verifyNewBatch() {
		             Boolean Batch=NewBatch.isDisplayed();
		             if(Batch) {
		         System.out.println("+A NewBatchIcon is Displayed");
		              
		             }
		             else {
		              System.out.println("+A NewBatchIcon not is Displayed");
		             }
		              
		             }
		       //Verify Check box
		            public void verifyCheckBox() {
		                Boolean Check=Checkbox.isDisplayed();
		                if(Check) {
		            System.out.println("CheckBox is Displayed");
		                 
		                }
		                else {
		                 System.out.println("CheckBox is not Displayed");
		                }
		               }
					public void clicknewbatch() {
						
						
					}
					
					//add 
					
					@FindBy(xpath="//input[@id='PopUp']")WebElement popup;
					
					@FindBy(xpath="//input[@name='Name']")WebElement NameField;
					
					@FindBy(xpath="//input[@text=noclasses") WebElement NoOfClasses;
					
					@FindBy(xpath="//input[@id='Description']") WebElement description;
					
					@FindBy(xpath="//a[@id='ProgramName-DropDown']") WebElement PGNDropdown;
					
					@FindBy(xpath="button[text()='Radiobtn']") WebElement RadioButton;
					
					@FindBy(xpath="button[id=savebtn']") WebElement savebutton;
					
					@FindBy(xpath="//table[@id='Batch-data-table']")WebElement BatchDTable;
					
					@FindBy(xpath="	//div[@role='alert']")WebElement invalidMessg;
						
					
					

						public void AddNewBatch(WebDriver driver) {
							this.driver = driver;
							PageFactory.initElements(driver, this);
						}
						//Verify popup appears
						public void verifyPopUpAppearance() {
					        boolean batchpopup = false;
					  if (popup.isDisplayed()) {
					        	System.out.println   ("The Batch details pop-up is displayed.");
					        batchpopup = true;
					       // break;
					        }

						 if (!popup.isDisplayed()) {
				             System.out.println("The newly added batch is not found in the data table.");
				         }
					            System.out.println("The Batch details Pop-up is not displayed");
				}

					//verify the popup fields
						public void verifyPopUpFields() {
					        
					         List<WebElement> textFields = popup.findElements(By.tagName("input"));
					        WebElement PGNDropdown = popup.findElement(By.id("program-name-dropdown")); 
					        List<WebElement> RadioButton = popup.findElements(By.id("input[type='radio']"));

					        if (textFields.size() != 25 || PGNDropdown == null || RadioButton.size() != 1){
					           System.out.println("Expected fields not found in the pop-up.");
					        }
					    }
					//Enter details in the Add new Batch form fields

				     public void batchFieldsdetails() {
				        
				         NameField.sendKeys();

				         NoOfClasses.sendKeys();

				        PGNDropdown.isSelected();
				        
				        RadioButton.click();

				        savebutton.click();
				        
				    	 System.out.println("All the details in the Addnewbatch is filled");
				    	 log.info("----Popup details can able to see----");
				     }

				     //Verify the new batch is present in the table
				     
				     public void verifyNewBatchInDataTable() {
				    	 
				         if (BatchDTable == null) {
				         System.out.println("Data table not found on the page.");
				         }

				         
				         String BatchName = "CYS Batch"; 
				         String ProgramName= "Program XYZ"; 

				         boolean batchFound = false;
				         for (WebElement row : BatchDTable.findElements(By.tagName("tr"))) {
				             
				             List<WebElement> columns = row.findElements(By.tagName("td"));
				             if (columns.size() >= 3) {
				                 String batchName = columns.get(0).getText();
				                 String programName = columns.get(1).getText();

				                 if (batchName.equals(BatchName) && programName.equals(ProgramName)) {
				                     batchFound = true;
				                     break;
				                 }
				             
				                 if (!batchFound) {
				             System.out.println("The newly added batch is not found in the data table.");
				             log.info("The newly added batch is available in Datatable");
				         }
				             }  
				         }}
				     
				        //Fill the details in Batch form and click save
				     public void BatchformfillFields() {
				    	   
				    	 NameField.sendKeys(null);
				    	 
				    	 NoOfClasses.sendKeys(null);
				    	   
				    	 PGNDropdown.click();  
				    	 
				    	 RadioButton.click();  
				    	 
				    	 description.sendKeys(null);

				    	 savebutton.click();
				    	 
				    	 System.out.println("All the fields are entered");
				     }
				       //check for invalid values inthe fields
				         
				     public void InvalidValues() {
				         
				          NameField.equals(NameField);
				    	 
				    	 NoOfClasses.equals(NoOfClasses);
				    	   
				    	 PGNDropdown.equals(PGNDropdown);  
				    	 
				    	 RadioButton.equals(RadioButton);  
				    	 
				    	 description.equals(description);

				             boolean InvalidValues = false;

				         
				         if (NameField.getAttribute("value").isEmpty()
				        		 &&(description.getAttribute("value").isEmpty())) {	 
				        	 InvalidValues=true;
				        	
				        	 throw new AssertionError ("One or more fieldsof Batch form contain invalid values");
				              
				     }
				     }  
				         //Invalid details error message should appear
				     
				     public void CheckErrorMsg() {
				    	 
				    	 
				    	 boolean Invalidvalues =false;
				    	 
				    	 if(NameField.getAttribute("value").isEmpty());{
				    	 
				    	 Invalidvalues=true;
				    	 throw new AssertionError ("Invalid input is entered");
				    	// log.info( "Admin entered invalid inputs");
				     }
				}
				 // validation of Missing Mandatory field
				       
				     
				           public void ValidateMissingMandatoryField() {
				    	        
				    	     boolean EmptyMandatoryFields = false;

				    	        if (NameField.getAttribute("value").isEmpty() 
				    	        
				    	        &&(NoOfClasses.getAttribute("value").isEmpty())) {
				    	        	EmptyMandatoryFields = true; 
				    	        }

				    	        
				    	        if (EmptyMandatoryFields) {
				    	            
				    	            throw new AssertionError("Missing Mandatory fields");
				    	        }
				           }
				           
				           //delete
				           //@FindBy(xpath="//input[@value='deletebtn']") WebElement DeleteIcon;
				       	
				       	@FindBy(xpath="//input[@id='alert']")WebElement alert;
				       	@FindBy(xpath="//input[@id='BatchName']")WebElement BatchName;
				       	@FindBy(xpath="//*[id='Yes_button']") WebElement YesButton;
				       	@FindBy(xpath="//*[id='No_button']") WebElement NoButton;
				       	
				       	@FindBy(xpath="//*[id='Table-row']") WebElement tablerow;
				       	@FindBy(xpath="//*[id='Table-column']") WebElement tablecolumns;
				       	
				       	public void DeleteBatch(WebDriver driver) {
							this.driver = driver;
							PageFactory.initElements(driver, this);
						}
						//Verify Delete icon is enabled
						 public void verifyDeleteicon() {
							   Boolean Delete = DeleteIcon.isEnabled();
							   if(DeleteIcon.isEnabled()) {
								   System.out.println("DeleteIcon is Enable");
								  
							   }
							   else {
								   System.out.println("DeleteIcon is not  Enable");
								  log.info("Delete icon is enabled");
							   }
						 }
							// Admin clicks edit icon  
							  public void DeleteIconClick() {
								  
								  DeleteIcon.click();
								  log.info("Admin cliks Delete icon");
							  }
						
						//Accept alert with yes or no options
							  public void verifyDeleteAlert() {
							        
							       Alert alert = driver.switchTo().alert();

							        
							        String alertMessage = alert.getText();

							      //   if (alertMessage.contains("Are you sure you want to delete?")) {
							         //   System.ot.println("The alert message with yes or no displays ");}
							        
				                   alert.accept();
							  }
				                   
							  //Verify Yes button
							  public void YesBtn() {
									YesButton.click();
								}
							  //verify no button
								public void NoBtn() {
									NoButton.click();
								}
								//verifyBatchDeletedAlert pops in the Table

				public void BatchDeletedAlert () {
				    
				    Alert alert = driver.switchTo().alert();

				     String alertMessage = alert.getText();

				     if (!alertMessage.contains("Are you sure you want to delete this batch 04?")) {
				       System.out.println("Are you sure want to delete ?");
				    }
				     alert.accept();

				     String deletedBatchName = "Deleted Batch 02"; 
				    boolean batchDeleted = true;

				    
				            if (BatchName.equals(deletedBatchName)) {
				            	System.out.println("Batch name is Deleted"); 
				                }
				            else {
				            	System.out.println("Batch name is not Deleted");	
				            }
				}
				   

				//check whether the batch is still available in the table
				public void BatchAvailable() {
					
					boolean batchavTable;
					if (BatchName("02").isDisplayed()) {
						System.out.println("Deleted Batch is still present in the Table");
					}
						else {
							System.out.println("Deleted Batch is not present in the Table");
					}
				}
					

				private WebElement BatchName(String string) {
					
					return null;
				}
				
				//deletemultiple
				//@FindBy(xpath="//input[@type='Delete']")WebElement  DeleteIcon;
				@FindBy(xpath="//tr[contains(@data-id-02']")WebElement dataTablerow02;
				@FindBy(xpath="//Button[@Disabled='true']") WebElement DisableDeleteBtn;
				@FindBy(xpath="//input[@type='checkbox']") WebElement SingleCheckBox;
				@FindBy(xpath="//input[@Type='checkbox1 and checkbox2") WebElement multipleCheckBox;
				
				//verify none of the datatable chekbox selected
				  public void verifyNoCheckboxSelected() {
				        
				        List<WebElement> checkboxes = driver.findElements(By.id("checkbox"));
				        boolean tablecheckbox;
				       // for (WebElement checkbox : checkboxes) {
				            if (!SingleCheckBox.isSelected()) {
				               System.out.println("One or more checkboxes in the data table are not selected");
				            }
				            else {
				            	System.out.println("One or more checkboxes in the data table are selected");
				            }
				        }
				//Verify delete icon disabled under ManageBatch
				public void verifyDeleteIconMB() {
			          Boolean Delete = DeleteIcon.isEnabled();
			          if(DeleteIcon.isEnabled()) {
			           System.out.println("DeleteIcon is Enabled");
			           
			          }
			          else {
			           System.out.println("DeleteIcon is not Enabled");
			          }
			          
			         }
				//verify one check box/row is selected
				public void checkboxsel() {
					
				        
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
				public void DeleteIcon() {
					DeleteIcon.click();
					log.info("Delete Icon under MB is selected");
				}
			//Delete one batchrow
				public void RowTableDel() {
					dataTablerow02.isSelected();
					DeleteIcon.click();
					log.info("02 Row in the BatchDataTable is Deleted");
				}      
				//one/or two is Selected
				public void TwoRowsSelected() {
				multipleCheckBox.isSelected();
					boolean twochkbox = true;
				if (multipleCheckBox.isSelected()) {
					System.out.println("Tworows in BatchDataTable is Selected");}
					else {
						System.out.println("Tworows in BatchDataTable  is not Selected");
					}
				log.info("TwoRow in the BatchDataTable is Selected");
				}
				
				//edit
				//@FindBy(xpath="//input[@type='edittext']")WebElement  EditIcon;
				
				//@FindBy(xpath="//input[@id='PopUp']")WebElement popup;
				//@FindBy(xpath="//input[@name='Name']")WebElement NameField;
				
				//@FindBy(xpath="//input[@text=noclasses") WebElement NoOfClasses;
				
				//@FindBy(xpath="//input[@id='Description']") WebElement description;
				
				//@FindBy(xpath="//a[@id='ProgramName-DropDown']") WebElement PGNDropdown;
				
				//@FindBy(xpath="button[text()='Radiobtn']") WebElement RadioButton;
				//
				//@FindBy(xpath="button[id=savebtn']") WebElement savebutton;
				
				
				@FindBy(xpath="//table[@id='data-table-row']//tr[1]")WebElement DTRow;
				
				@FindBy(name="name")WebElement Name;
				
				@FindBy(xpath="	//div[@role='alert']")WebElement invalidMesg;
				
				@FindBy(xpath="//input[@id='MandatoryField']") WebElement MandatoryField;
				
				 
					// Admin clicks edit icon  
					  public void EditiconClick() {
						  
						  EditIcon.click();
						  log.info("Admin cliks edit icon");
					  }
				   //verify popup with batch details appears
					 

					 // Update the fields with valid values	   
					 
				        
			            //The updated batch details should appear on the data table
					  public void UpdatedBatchDetails() {
						  log.info("Batch details are updated");
					  }
					  
				
					
					  //Verify Error msg-Invalid inputs
					  public void InvalidErrMsg() {
					  boolean Invalidvalues1 =false;
				    	 
				    	 if(NameField.getAttribute("value").isEmpty());{
				    	 
				    		 Invalidvalues1=true;
				    	 throw new AssertionError ("Invalid input is entered");
				    	// log.info("batch table entered with invalid inputs");
				     }}
				//Erase data from Mandatory field
					  public void deleteMandatory() {
				    	   MandatoryField.clear();
				    	   log.info(" Mandatory field data is erased");
					  }
					  //Erase data from description field
					  public void deleteDescription() {
				    	   description.clear();
				    	   log.info(" -------Description field data is erased---------");
				       }

}
		            
		        




