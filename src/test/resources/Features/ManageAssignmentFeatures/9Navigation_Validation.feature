Feature: Navigation function validation from manage assignment page to other pages  

Background: Admin is manage assignment page after logged in

Given Admin is on Manage assignment Page

Scenario Outline: Verify admin is able to navigate from manage assignment to other page
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
