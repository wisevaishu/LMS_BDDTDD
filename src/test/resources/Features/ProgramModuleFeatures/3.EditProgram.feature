Feature: Admin validating the Edit program

Background: 

Given Admin is on Manage Program page



@Tag_001

Scenario: Validate Edit feature

	When Admin clicks "Edit" button on the data table for any row on manage program page

	Then Admin should see a popup open for Program details to edit

	

@Tag_002

Scenario Outline: Edit Program Name and Description

	When Admin enters the sheetname "<sheetname>" and row number <rownum> to edit program

	Then Admin gets a message "Successfully Program updated" and able to see the update name in the data table for that particular Program

	And Admin gets a Error message alert on program details popup window



Examples:

|sheetname   |rownum  |

|EditProgram |1       |

|EditProgram |2				|

|EditProgram |3 			|



@Tag_003	

Scenario: Change Program Status

	When Admin change the "Status" and clicks "Save" button on program details edit popup

	Then Admin gets a message "Successfully Program updated" and able to see the update Status in the data table for that particular Program



@Tag_004

Scenario: Validate Cancel button on Edit popup

	When Admin clicks "Cancel" button on Program Edit popup 

	Then Admin can see the program details popup disappear without creating any program on edit program