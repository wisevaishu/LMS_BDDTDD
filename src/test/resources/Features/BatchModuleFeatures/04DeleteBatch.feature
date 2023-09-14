Feature: Delete Batch
Background: Logged on the LMS portal
Admin is on dashboard page after Login
Admin clicks Batch from navigation bar"

Scenario:  Validate row level delete icon
Given The delete icon on row level in data table is enabled
When Admin clicks the delete icon
Then Alert appears with yes and No option

Scenario:  Validate accept alert
Given Admin clicks the delete icon
When You click yes option
Then Batch deleted alert pops and batch is no more available in data table

Scenario:  Validate reject alert
Given Admin clicks the delete icon
When you click No option
Then Batch is still listed in data table