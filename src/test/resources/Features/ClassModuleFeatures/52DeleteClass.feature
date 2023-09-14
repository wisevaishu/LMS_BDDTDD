#71-72
Feature: Delete class Validation

Background: Admin clicks row level delete button after landing to manage class page
Given Admin is in delete alert

Scenario: Validate accept in alert
When Admin clicks yes button	
Then Success message and validate particular class details are deleted from the data table

Scenario: Validate reject in alert
When Admin clicks no button	
Then Admin should land on manage class page and validate particular class details are not deleted from the data table
