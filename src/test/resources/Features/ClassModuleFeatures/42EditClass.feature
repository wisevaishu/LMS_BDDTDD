#57-67

Feature: Edit class Validation

Background: Admin clicks Edit button in manage class after reaching manage class page
Given Admin is in  Edit class detail popup window


Scenario: Validate admin able to update class with valid data in mandatory fields
When Admin enters all mandatory field values with valid data and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id)
Then Admin should see particular class details is updated in the data table

Scenario: Validate admin able to  update class with invalid data in mandatory fields
When Admin enters all mandatory field values with invalid data and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id, )	
Then Error message should appear in alert

Scenario Outline: Validate admin able to  update class with valid data  in all fields
When Admin enters values in all fields with valid data and clicks save button "<Batch ID>" "<No of Classes>" "<Class Date>" "<Class Topic>" "<Staff Id>" "<Class description>" "<Comments>" "<Notes>" "<Recordings>"	
Then Admin should see particular class details is updated in the data table

Examples: 
    |Batch Id| No of classes | Class Date | Topic | StaffID | Class Description | Comments | Notes | Recording |
    | 7576 | 1 | 09/13/23 | Python | U01 | Advanced Python | ok | c:\ClassNotes | c:\Recordings |

Scenario Outline: Validate admin able to  update  class with invalid data  in all fields
When Admin enters with invalid data in optional fields and clicks save button "<Batch ID>" "<No of Classes>" "<Class Date>" "<Class Topic>" "<Staff Id>" "<Class description>" "<Comments>" "<Notes>" "<Recordings>"
Then Error message should appear in alert

Examples: 
    |BatchId| No of classes | Class Date | Topic | StaffID | Class Description | Comments | Notes | Recording |
    | 8977 | 1 | 09/13/23 | Python | U01 | 0124 | ok | "%@#%" | "****" |
#########################
Scenario Outline: Validate admin able to update class missing fields
When Admin enters data missing value in one of the fields and clicks save button "<Batch ID>" "<No of Classes>" "<Class Date>" "<Class Topic>" "<Staff Id>" "<Class description>" "<Comments>" "<Notes>" "<Recordings>"
Then "<fieldname>" is missing

Examples: 
    |BatchId| No of classes | Class Date | Topic | StaffID | Class Description | Comments | Notes | Recording | fieldname|
    | " "| 1 | 09/13/23 | Python | U01 | Advanced Python | ok | c:\ClassNotes | c:\Recordings |Batch ID is missing|
    | 2223 | " " | 09/13/23 | Python | U01 | Advanced Python | ok | c:\ClassNotes | c:\Recordings |No of class is missing|
    | 2245 | 1 |   | Python | U01 | Advanced Python | ok | c:\ClassNotes | c:\Recordings | Class Date is missing|
    | 7576 | 1 | 09/13/23 | Python | " " | Advanced Python | ok | c:\ClassNotes | c:\Recordings | Staff ID is missing|
    | 7221 | 1 | 01/13/23 | Python | U02 | Advanced Python | ok | c:\ClassNotes | c:\Recordings | class cannot be  created for the passed date|

Scenario: Validate cancel button function in Edit class details popup window
When Admin clicks Cancel button without entering values in the fields	
Then Admin should land on Manage Class page

Scenario Outline: Validate cancel button function in Edit class details popup window with values in field
When Admin clicks Cancel button entering values in the fields	 "<Batch ID>" "<No of Classes>" "<Class Date>" "<Class Topic>" "<Staff Id>" "<Class description>" "<Comments>" "<Notes>" "<Recordings>"
Then Admin should land on Manage Class Page and validate particular class details are not changed  in the data table

Examples: 
    |Batch Id| No of classes | Class Date | Topic | StaffID | Class Description | Comments | Notes | Recording |
    | 7576 | 1 | 09/13/23 | Python | U01 | Advanced Python | ok | c:\ClassNotes | c:\Recordings |
