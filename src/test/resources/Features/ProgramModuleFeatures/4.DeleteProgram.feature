Feature: Admin validating the Delete program



Background: Admin is on dashboard page after login and clicks program on the navigation bar

	

@Tag_001

Scenario: Delete feature

	Given Admin is on Manage Program page on Program page

	When Admin clicks "Delete" button on the data table for any data on manage program page

	Then Admin should see a alert open with heading "Confirm" along with "YES" or "NO" button for deletion

	And Then Admin should see a message "Are you sure you want to delete <program Name>?" on progrom delete alert

		

@Tag_002

Scenario: Click Yes on Deletion window	

	Given Admin is on Confirm deletion alert on program page

	When Admin clicks "YES" button on the alert on program delete alert

	Then Admin gets a message "Successfully Program Deleted" alert and able to see that Program deleted in the table

	

@Tag_003

Scenario: Click No on Deletion window

	When Admin clicks "NO" button on the alert on program delete alert

	Then Admin can see the deletion alert disappears without deleting

	

@Tag_004

Scenario: Validate Cancel/Close icon on confirm deletion alert

	When Admin clicks "Cancel/Close" icon on the alert

	Then Admin can see the deletion alert disappears without deleting