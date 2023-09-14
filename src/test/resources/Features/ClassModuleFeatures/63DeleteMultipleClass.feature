#78-79
Feature: Delete multiple class validation
Background: Admin clicks delete button under header after selecting the multiple check box in the data tabl
Given Admin is on Manage Class Page
When Admin clicks on under the header Delete button after selecting multiple checkboxes
Then Admin is in delete alert


Scenario: Verify accept alert in delete multiple class function by selecting multiple checkbox
When Admin clicks yes button	
Then Admin should land on manage class page and validate particular class details are deleted from the data table

Scenario: Verify reject alert in delete multiple class function by selecting multiple checkbox
When Admin clicks no button	
Then Admin should land on manage class page and validate particular class details are not deleted from the data table
