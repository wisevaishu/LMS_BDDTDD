Feature: Admin validate the Manage Program page

#Background:
#Given Admin is logged on the LMS portal
#And Admin is on dashboard page after login LMS portal

Background: 
Given Admin launch browser
When Admin gives the correct LMS
Then Admin should land on home page
And Admin click Home Page Login
Then Admin enter ValidUser and Password
And Admin click Login button
And Admin in Dashboard Page

@Tag_001
Scenario: Validate landing in program page	
When Admin clicks "Program" on the navigation bar to navigate proram page
Then Admin should see URL with "Manage Program"	page on program page

@Tag_002
Scenario: Admin valid the heading on Program Page
Then Admin should see a heading with text "Manage Program" on the program page	

@Tag_003
Scenario: Validate the text and pagination icon below the data table
Then Admin should see the text as "Showing x to y of z entries" along with pagination icon below the table on program table	

@Tag_004
Scenario: Validate the footer
Then Admin should see the footer as "In total there are z programs" on the manage program page

@Tag_005
Scenario: Validating the default state of Delete button
Given Admin is on dashboard page after login for program page
When Admin clicks "Program" on the navigation bar to navigate proram page
Then Admin should see a Delete button on the top left hand side as Disabled on manage program page

@Tag_006

Scenario: Validate Add New Program

	When Admin clicks "Program" on the navigation bar to navigate proram page

	Then Admin should see a "+A New Program" button on the program page above the data table

	

@Tag_007

Scenario: Validate the number of records(rows of data in the table) displayed

	When Admin clicks "Program" on the navigation bar to navigate proram page

	Then Admin should see the number of records (rows of data in the table) displayed on the page are 5 on manage program page

	

@Tag_008

Scenario: Verify data table on the Program Page

	When Admin clicks "Program" on the navigation bar to navigate proram page	

	Then Admin should see data table on the Manager Program page with following column headers: Program Name,Program Description,Program Status,Edit,Delete

	

@Tag_009

Scenario: Verify sort arrow icon on the data table

	When Admin clicks "Program" on the navigation bar to navigate proram page	

	Then Admin should see the sort arrow icon beside to each column header except Edit and Delete

	

@Tag_010

Scenario: Verify check box on the data table

	When Admin clicks "Program" on the navigation bar to navigate proram page

	Then Admin should see check box on the left side in all rows of the data table on manage program page

	

@Tag_011

Scenario: Verify Edit and Delete buttons

	When Admin clicks "Program" on the navigation bar to navigate proram page	

	Then Admin should see the Edit and Delete button on each row of the data table on manage program page

	

@Tag_012

Scenario: Verify search bar on the Program page

	When Admin clicks "Program" on the navigation bar to navigate proram page	

	Then Admin should see the search bar with text as "Search..." on manage program page

@Tag_013

Scenario: Search Program by Name

	When Admin enters "<Program name phrase>" in the search box on manage program page

	Then Admin should see the programs displayed based on the Program Name

	

@Tag_014

Scenario: Search Program by Description

	When Admin enters "<Program description phrase>" in the search box on manage program page

	Then Admin should see the programs displayed based on the Program Description

	

@Tag_015

Scenario: Search Program by Status

	When Admin enters "<Program status phrase>" in the search box on manage program page

	Then Admin should see the programs displayed based on the Program Status

	

@Tag_016

Scenario: Validating the Search with unrelated keyword

	When Admin enters the keywords not present in the data table on the Search box on manage program page

	Then Admin should see Zero enteries on the data table on manage program page