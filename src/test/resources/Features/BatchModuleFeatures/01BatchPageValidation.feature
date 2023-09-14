


Feature: BatchPageValidation
 #Background: Logged on the LMS portal
 
     
  
  Scenario: Logged in the LMS Application
     Given  Admin is on LMS dashboard page after login
       When   Admin clicks "Batch" button from navigation bar
       Then Admin should be able to see "ManageBatch" page in the LMSApplication
   

  Scenario: Validate header in your Batch page
  Given  Admin is on LMS dashboard page after login
     When   Admin clicks "Batch" button from navigation bar
       Then Admin should see the "ManageBatch" in the header


  Scenario: Validate pagination in the Batch Page
  Given  Admin is on LMS dashboard page after login
     When   Admin clicks "Batch" button from navigation bar
       Then Admin should see the pagination controls under the data table in batch module
    
 
  Scenario: Validate data table headers in the Batch Page	
  Given  Admin is on LMS dashboard page after login
     When   Admin clicks "Batch" button from navigation bar
       Then Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete
    

  Scenario: Validate Delete button in Batch Page
    Given  Admin is on LMS dashboard page after login
     When   Admin clicks "Batch" button from navigation bar
     Then Admin should be able to see the "Delete" icon button that is disabled
    

 	Scenario: Validate Newbatch in Batch Page
 	  Given  Admin is on LMS dashboard page after login
     When   Admin clicks "Batch" button from navigation bar
     Then Admin should be able to see the "ANewbatch" button
    
    
  Scenario: Validate data rows
     Given  Admin is on LMS dashboard page after login
      When   Admin clicks "Batch" button from navigation bar
      Then Each row in the data table should have a checkbox
    
    
    Given  Admin is on LMS dashboard page after login
     When   Admin clicks "Batch" button from navigation bar
     Then Each row in the data table should have a edit icon that is enabled
    
      
      
    Given  Admin is on LMS dashboard page after login
     When   Admin clicks "Batch" button from navigation bar
     Then Each row in the data table should have a delete icon that is enabled
    
  
 	Scenario: Validate pop up for adding batch
 	   Given  Admin is on LMS dashboard page after login
      When Admin clicks "ANewBatch" button
      Then A new pop up with Batch details appears  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    