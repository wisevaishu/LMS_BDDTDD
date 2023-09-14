Feature: Delete multiple user
Background:
Scenario: Validate the delete icon below the header
Given None of the checkboxes in data table are selected
Then The delete icon under the "Manage User" header should be disabled in user module

Scenario: Check for single row delete
Given One of the checkbox or row is selected in user module
When Click delete icon below "Manage User" header
Then The respective row in the data table is deleted in user module

Scenario: Check for multi row delete
Given Two or more checkboxes or row is selected in user module
When Click delete icon below header
Then The respective row in the data table is deleted