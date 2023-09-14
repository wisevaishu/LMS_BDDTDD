Feature: Delete multiple batches 

Background: Logged on the LMS portal
#Admin is on dashboard page after Login
#Admin clicks "Batch" from navigation bar



Scenario:  Validate the delete icon below the header 
Given None of the checkboxes in data table are selected

Then The delete icon under the "Manage Batch" header should be disabled

Scenario: Check for single row delete  
Given One of the checkbox or row is selected
When Click delete icon below "Manage Batch" header
Then The respective row in the data table is deleted

Scenario:  Check for multi row delete
Given Two or more checkboxes or row is selected
When Click delete icon below "Manage Batch" header
Then The respective row in the data table is deleted