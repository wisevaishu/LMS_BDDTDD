Feature: Admin validates the Sorting of program data



Background: Admin is on Manage Program page after clicks program on the navigation bar 



@Tag_001

Scenario: Validates sorting (data ordering) on the program Data table

	Given Admin is on Manage Program page 

	When Admin clicks the sort icon of Program Name column

	Then The data get sorted on the table based on the Program Name column values in ascending order

	

	Given The data is in the ascending order on the table based on Program Name column

	When Admin clicks the sort icon of Program Name column	

	Then The data get sorted on the table based on the Program Name column values in decending order

	

	Given Admin is on Manage Program page

	When Admin clicks the sort icon of Program Description column

	Then The data get sorted on the table based on the Program Description column values in acending order

	

	Given The data is in the ascending order on the table based on Program Description column

	When Admin clicks the sort icon of Program Description column	

	Then The data get sorted on the table based on the Program Description column values in decending order

	

	Given Admin is on Manage Program page

	When Admin clicks the sort icon of Program Status column

	Then The data get sorted on the table based on the Program Status column values in acending order

	

	Given The data is in the ascending order on the table based on Program Status column

	When Admin clicks the sort icon of Program Status column	

	Then The data get sorted on the table based on the Program Status column values in decending order