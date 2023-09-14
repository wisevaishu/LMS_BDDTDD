Feature: Admin validating Multiple Delete program





Background: Admin is on dashboard page after login and clicks program on the navigation bar	

Background: Admin clicks Delete button under header after selecting the check box in the data table

Background: Admin clicks Delete button under header after selecting the multiple checkboxes in the data table



@Tag_001

Scenario: Validate common Delete button enabled after clicking on any checkbox

	Given Admin is in Manage Program Page 

	When Admin clicks any checkbox is in data table on manage program page

	Then Admin should see common delete option enabled under header Manage Program 

	



@Tag_002

Scenario: Validate multiple program deletion by selecting single checkbox

	Given Admin is on Confirm Deletion alert on program page

	

	When Admin clicks "Yes" button on the alert on program delete alert

	Then Admin should land on Manage Program page and can see the selected program is deleted from the data table

	

	

	When Admin clicks "No" button on the alert on program delete alert

	Then Admin should land on Manage Program page and can see the selected program is not deleted from the data table

	

@Tag_003

Scenario: Validate multiple program deletion by selecting multiple check boxes

	Given Admin is on Confirm Deletion alert on program page

	

	When Admin clicks "Yes" button on the alert on program delete alert

	Then Admin should land on Manage Program page and can see the selected programs are deleted from the data table 

	

	When Admin clicks "No" button on the alert on program delete alert

	Then Admin should land on Manage Program page and can see the selected programs are deleted from the data table