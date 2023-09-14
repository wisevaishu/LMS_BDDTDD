#92-98
Feature: Navigation function validation from manage class page to other pages  

Background: Admin is in manage class page after logged in
Given Admin is on Manage Class Page

Scenario Outline: Verify admin is able to navigate from manage class to student page
When Admin clicks "<pages>" button in the navigation bar	
Then Admin should able to land on "<pages>" page

Examples:
|pages|
|Student|
|Program|
|Batch|
|User|
|Class|
|Assignment|
|Attendance|
|Logout|

