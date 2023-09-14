Feature: Delete multiple class validation
Background: Admin logged into LMS portal and clicks Assignment button on the navigation bar 
Given Admin is on Manage Assignment Page

Scenario: Verify delete multiple Assignment  button is enabled
When Admin clicks single row level check box in the data table	
Then Admin should see delete icon below the header is enabled

Scenario: verify tick mark is visible after clicking on check box
When Admin clicks single row level check box in the data table	
Then Admin should see tick mark in check box 

Scenario: verify admin able to click multiple check box
When Admin clicks multiple row level check box in the data table	
Then Admin should see tick mark in check box  of the selected rows