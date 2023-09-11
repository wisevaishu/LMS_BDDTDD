Feature: Admin validate the Student page

Background: Validate login with valid credentials
Given Admin enter ValidUser and Password
When Admin click Login button
Then Admin lands on Dashboard Page    

@Tag_001
Scenario: Validate the title of the page
Given Admin is on the Dashboard page after logged in
When Admin clicks "Student" on the navigation bar
Then Admin should see the "Student details" page title 

@Tag_002
Scenario: Admin validate response time from Dashboard page to Student page
Given Admin is on the Dashboard page after logged in
When Admin clicks "Student" on the navigation bar
Then Maximun navigation time in milliseconds,defaults to 30 seconds

@Tag_003
Scenario: Admin validate the broken link
Given Admin is on the Dashboard page after logged in
When Admin clicks "Student" on the navigation bar to validate the broken link
Then HTTP response >=400, then the link is broken

@Tag_004
Scenario: Admin verify LMS title
Given Admin is on the Dashboard page after logged in 	
When Admin clicks "Student" on the navigation bar
Then Admin should see the "LMS-Learning management system" as title

@Tag_005
Scenario: Admin verify the alignment of the Student details title 
Given Admin is on the Dashboard page after logged in
When Admin clicks "Student" on the navigation bar
Then Student details title should be in center of the page

@Tag_006

Scenario: Admin validate drop down is present in the page
Given Admin is on the Dashboard page after logged in
When Admin clicks "Student" on the navigation bar
Then 2 drop down should be present in the "Student details" page

@Tag_007
Scenario: Admin validate the search bar in Student Name drop down
Given Admin is on the Dashboard page after logged in
When Admin clicks "Student" on the navigation bar
Then Admin should see "search box" inside the "Student Name" drop down 		

@Tag_008
Scenario: Admin validate the search bar in batch id drop down
Given Admin is on the Dashboard page after logged in
When Admin clicks "Student" on the navigation bar
Then Admin should see "search box" inside the "batch id" drop down

@Tag_009
Scenario: Admin validate text spelling in student name
Given Admin is on the Dashboard page after logged in
When Admin clicks "Student" on the navigation bar
Then Admin should see correct spelling select "Student Name" text

@Tag_010
Scenario: Admin validate text spelling in batch id
Given Admin is on the Dashboard page after logged in
When Admin clicks "Student" on the navigation bar
Then Admin should see correct spelling select "batch id" text

@Tag_011
Scenario: Validate student name in gray color in StudentName drop down
Given Admin is on the Dashboard page after logged in
When Admin clicks "Student" on the navigation bar
Then Admin should see select "student name" in gray color 

@Tag_012
Scenario: Validate batch id in gray color in batch id drop down
Given Admin is on the Dashboard page after logged in
When Admin clicks "Student" on the navigation bar	
Then Admin should see select "batch id" in gray color

@Tag_013
Scenario: Validate first drop down label is select Student Name
Given Admin is on the Dashboard page after logged in
When Admin clicks "Student" on the navigation bar	
Then Admin should see select "Student Name" in first

@Tag_014
Scenario: Validate second drop down lable is select batch id
Given Admin is on the Dashboard page after logged in
When Admin clicks "Student" on the navigation bar	
Then Admin should see select "batch id" in second

@Tag_015
Scenario: Validate scroll down inside student name dropdown 	
Given Admin is on the Dashboard page after logged in
When Admin clicks "Student" on the navigation bar	
Then Admin should able to scroll down to select the Student name

@Tag_016
Scenario: Validate scroll down inside batch id dropdown
Given Admin is on the Dashboard page after logged in
When Admin clicks "Student" on the navigation bar	
Then Admin should able to scroll down to select the batch id 

@Tag_017
Scenario: Validate select student name is fading
Given Admin is on Student details page
When Admin select "Student Name" from the drop down
Then Admin should not see select student name text

@Tag_018
Scenario: Validate select batch id is fading
Given Admin is on Student details page
When Admin select "batch id" from the drop down
Then Admin should not see select batch id text

@Tag_019
Scenario: Validate select student name using search box
Given Admin is on Student details page
When Admin clicks "Student Name" search box and enters "x" alphabet in the search box
Then Admin should see student name start with x is listed below		

@Tag_020
Scenario: Validate select batch id using search box
Given Admin is on Student details page
When Admin clicks "batch id" search box and enters x number in the search box
Then Admin should see batch id start with x is listed below

@Tag_021
Scenario: Validate selecting only student name will not display any details
Given Admin is on Student details page
When Admin selects only "Student Name"	
Then Student details should not be displayed

@Tag_022
Scenario: Validate selecting only batch id will not display any details
Given Admin is on Student details page
When Admin selects only "batch id"
Then Student details should not be displayed

@Tag_023
Scenario: Validate selecting student name and batch id
Given Admin is on Student details page
When Admin selects "Student Name" and batch id
Then Particular student informations should be display

@Tag_024
Scenario: Program link on navigation bar
Given Admin is on Student details page
When Admin clicks on "program" link on student page
Then Admin is redirect to Program page
When Admin clicks on "Batch" link on student page
Then Admin is redirect to Batch page
When Admin clicks on "Class" link on student page
Then Admin is redirect to Class page
When Admin clicks on "User" link on student page
Then Admin is redirect to User page
When Admin clicks on "Assignment" link on student page
Then Admin is redirect to User page
When Admin clicks on "Attendance" link on studet page
Then Admin is redirect to Attendance page
When Admin clicks on logout link on student page
Then Admin is redirect to login page