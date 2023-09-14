Feature: Validate date picker
Background: 
Given Admin is in add class details popup window

Scenario: Validate date picker
When Admin clicks date from date picker	
Then selected date should be their in class date text box

Scenario: validate date picker should be correct format
When Admin clicks date from date picker	
Then selected date should be in  mm/dd/yyyy format

Scenario: Validate right arrow in data picker to navigate to next month 
When Admin clicks right arrow in the date picker near month	
Then Next month calender should visible

Scenario: Validate left arrow in data picker to navigate to previous month
When Admin clicks left arrow in the date picker near month	
Then previous month calender should visible

Scenario: Validate current date is highlighted in the date picker
When Admin clicks date picker button	
Then Admin should see current date is highled in the date picker

Scenario: Validate selected date is highlighted in the date picker
When Admin clicks date picker button and selects future date	
Then Admin should see selected date is highled in the date picker

Scenario: Validate cancel button function in class details popup window
When Admin clicks Cancel button without entering values in the fields	
Then Admin should land on Manage Class page

Scenario: Validate cancel button function in class details popup window with values in field
When Admin clicks Cancel button entering values in the fields	
Then Admin should land on Manage Class Page and validate new class is not created in the data table

