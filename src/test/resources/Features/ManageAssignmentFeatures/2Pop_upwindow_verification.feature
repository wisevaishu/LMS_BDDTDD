Feature: Assignment details Popup window verification
Background: Admin logged into LMS portal and clicks assignment button on the navigation bar 

@Scenario01
Scenario: Verify Assignment details popup window
Given Admin is on manage assignment Page
When Admin click +Add new assignment button
Then Admin should see a popup  with  heading "Assignment details" in assignment module

# Incomplete
@Scenario02
Scenario Outline: Verify input fields in Assignment details popup window
Given Admin is on manage assignment Page
When Admin click +Add new assignment button
Then Admin should see input "<Fields>" Text 
 Examples: 
 | Fields |
 |Program name|
 |batch number|
|Assignment Name|
|Assignment Description|
 | grade by|
  |Assignment due date|
  | Assignment File 1|
   | Assignment file 2|
   |Assignment file 3|
  
   #Pending
@Scenario03
Scenario Outline: Verify text box present in Assignment details popup window
Given Admin is on manage assignment Page
When Admin click +Add new assignment button
Then 6 textbox should be  present in Class details popup window
  

@Scenario04
Scenario: Verify drop down in Batch Number  in Assignment details popup window
Given Admin is on manage assignment Page
When Admin click +Add new assignment button
Then Admin should see  dropdown option for Batch Number
@Scenario05
Scenario: Verify drop down in Program name  in Assignment details popup window
Given Admin is on manage assignment Page
When Admin click +Add new assignment button
Then Admin should see  dropdown option for Program name

@Scenario06
Scenario: Verify calendar icon in Assignment due date  in Assignment details popup window
Given Admin is on manage assignment Page
When Admin click +Add new assignment button
Then Admin should see  calendar icon for assignment due date

@Scenario07
Scenario: Verify save button is present
Given Admin is on manage assignment Page
When Admin click +Add new assignment button
Then Admin should see  save button in the Assignment detail popup window

@Scenario08
Scenario: Verify cancel button is present
Given Admin is on manage assignment Page
When Admin click +Add new assignment button
Then Admin should see  cancel button in the Assignment detail popup window
 
 @Scenario09
 Scenario: Verify close button in  Assignment details popup window
Given Admin is on manage assignment Page
When Admin click +Add new assignment button
Then Admin should see  close button on the Assignment details popup window








