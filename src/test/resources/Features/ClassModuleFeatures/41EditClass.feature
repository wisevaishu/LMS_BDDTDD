#55-56

Feature: Edit class Validation

Background: Admin logged into LMS portal and clicks class button on the navigation bar
Given Admin is on Manage Class Page

Scenario: Verify Edit class popup window		
When Admin clicks Edit button in data table 	
Then Edit popup window appears with heading Class Details

Scenario: Verify values in popup window		
When Admin clicks Edit button from one of the row in data table 	
Then Edit popup window appears with same row values in the all fields
