Feature: Admin validates the Pagination program



Background: Admin is on Manage Program page after logged in 



@Tag_001

Scenario: Verify Next page link

	Given Admin is on Manage Program page

	When Admin clicks "Next" page link on the program table

	Then Admin should see the pagination has "Next" link on manage program page

	

@Tag_002

Scenario: Verify Last page link

	Given Admin is on Manage Program page

	When Admin clicks "Last" page link on the program table

	Then Admin should see the last page record on the table with Next page link are disabled on manage program page

	

@Tag_003

Scenario: Verify First page link

	Given Admin is on last page Program table

	When Admin clicks "First" page link on the program table

	Then Admin should see the previous page record on the table with pagination has previous page link on manage program page

	

@Tag_004

Scenario: Verify Previous page link 

	Given Admin is on previous program page

	When Admin clicks "Start" page link on the program table

	Then Admin should see the very first page record on the table with previous page link are disabled on manage program page