#37-54
Feature: Add New Class 

Background: Admin click +Add New Class button after reaching to Manage class page
Given Admin is in add class details popup window

Scenario: Validate all batch id is reflecting in the dropdown
When Admin clicks  Batch ID dropdown	
Then Batch id in the drop down should match with Batch id manage batch page table

Scenario: Validate admin able to add new class with valid data in mandatory fields
When Admin enters all mandatory field values with valid data and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id)
Then Admin should see new class details is added in the data table

Scenario: Validate admin able to add new class with invalid data in mandatory fields
When Admin enters all mandatory field values with invalid data and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id, )	
Then Error message should appear in alert

Scenario Outline: Validate admin able to add new class with valid data  in all fields
When Admin enters values in all fields with valid data and clicks save button "<Batch ID>" "<No of Classes>" "<Class Date>" "<Class Topic>" "<Staff Id>" "<Class description>" "<Comments>" "<Notes>" "<Recordings>"	
Then Admin should see new class details is added in the data table

 Examples: 
    |BatchId| No of classes | Class Date | Topic | StaffID | Class Description | Comments | Notes | Recording |
    | 7576 | 1 | 09/13/23 | Python | U01 | Advanced Python | ok | c:\ClassNotes | c:\Recordings |
    
Scenario Outline: Validate admin able to add new class with invalid data  in optional fields
When Admin enters with invalid data in optional fields and clicks save button "<Batch ID>" "<No of Classes>" "<Class Date>" "<Class Topic>" "<Staff Id>" "<Class description>" "<Comments>" "<Notes>" "<Recordings>"
Then Error message should appear in alert

Examples: 
    |BatchId| No of classes | Class Date | Topic | StaffID | Class Description | Comments | Notes | Recording |
    | 8977 | 1 | 09/13/23 | Python | U01 | 0124 | ok | "%@#%" | "****" |
    

Scenario Outline: Validate admin able to add new class missing fields
When Admin enters data missing value in one of the fields and clicks save button "<Batch ID>" "<No of Classes>" "<Class Date>" "<Class Topic>" "<Staff Id>" "<Class description>" "<Comments>" "<Notes>" "<Recordings>"
Then "<fieldname>" is missing

Examples: 
    |BatchId| No of classes | Class Date | Topic | StaffID | Class Description | Comments | Notes | Recording | fieldname|
    | " "| 1 | 09/13/23 | Python | U01 | Advanced Python | ok | c:\ClassNotes | c:\Recordings |Batch ID is missing|
    | 2223 | " " | 09/13/23 | Python | U01 | Advanced Python | ok | c:\ClassNotes | c:\Recordings |No of class is missing|
    | 7576 | 1 | 09/13/23 | Python | " " | Advanced Python | ok | c:\ClassNotes | c:\Recordings | Staff ID is missing|
    | 7221 | 1 | 01/13/23 | Python | U02 | Advanced Python | ok | c:\ClassNotes | c:\Recordings | class cannot be  created for the passed date|
    | 7223| 1 |   | Python | U02 | Advanced Python | ok | c:\ClassNotes | c:\Recordings | class cannot be  created for the passed date|


