#1-17
Feature: Manage Class Page Verification

Background: Logged on the LMS portal as Admin

Given The Admin is on dashboard page after Login
When Admin clicks Class button on the navigation bar

Scenario: Verify landing in class page
Then Admin should see URL with "Manage Class"

Scenario: Capture the response time to navigate to manage class page
Then Get the response time for navigation from dashboard page to manage class page

Scenario: Verify Manage Class Page Header
Then Admin should see header with "Manage Class"

Scenario Outline: Validate text in manage class page 
And get all text from the portal page
Then Admin should see correct spelling for the all the "<fields>"

Examples:
|fields|
|Manage Programs Page|
|LMS - Learning Management System|
|Student|
|Program|
|Batch|
|class|
|User|
|Assignment|
|Logout|
|Manage Program|
|+ A New Program|
|Program Name|
|Program Description|
|Program Status|
|Edit|
|Delete|


Scenario: Verify delete icon below the header
Then Admin should see disabled delete icon below the "Manage Class"

Scenario: Verify search bar on the class page
Then Admin should see search bar on the class page

Scenario: Verify add new class button  on class page
Then Admin should see +Add New Class button on the class page

Scenario Outline: Verify data table on the class page
Then Admin should see data table on the Manage Class Page With following "<column headers>"

Examples:
|column headers|
|Check box symbol|
|Batch Id|
|Class No|
|Class Date| 
|Class Topic|
|Staff Id | 
|Description| 
|Comments|
| Notes| 
|Recording|
|Edit|
|Delete|

Scenario: Verify Edit icon in the data table
Then Edit Icon in each row of data table only  when entries are available

Scenario: Verify Edit icon when no data in the table
Then Edit Icon will not be present in data table

Scenario: Verify delete icon in the data table
Then Delete Icon in each row of data table only  when entries are available

Scenario: Verify delete icon when no data in the table 
Then Admin cant see delete  Icon in data table

Scenario: Verify sort icon in the data table
Then Admin should see sort icon near the column headers except for Edit and Delete

Scenario: Verify check box in the data table
Then Admin should see check box in the all rows  of data table 
 
#Scenario: Validate the number entries displaying
#Then Above the footer Admin should see the text as ""Showing x to y of z entries"" below the table 
#x- starting record number on that page
#y-ending record number on that page
#z-Total number of records  Note: with or without entries"

Scenario: Verify Pagination control below the data table 
Then Admin should see the pagination controls under the data table

Scenario: Validate footer  text
Then Admin should see the text with total number classes in the data table. ( " In total there are number of classes")

