#18-27

Feature: Manage Class page verification

Background: Admin logged into LMS portal and clicks class button on the navigation bar  
Given Admin is on Manage Class Page

Scenario: Validate search box function
When Admin enters batch id into search box  
Then Displays entries with that batch Id

Scenario: Validate search box function
When Admin enters batch id which is not existing the table into search box  
Then Displays empty details in the data table
 
Scenario: Validate search box function
When Admin enters class no into search box  
Then Displays entries with that class no

Scenario: Validate search box function
When Admin enters class no which is not existing the table into search box  
Then Displays empty details in the data table

Scenario: Validate search box function
When Admin enters class topic into search box  
Then Displays entries with that  class topic

Scenario: Validate search box function
When Admin enters staff id into search box  
Then Displays entries with that  staff id

Scenario: Validate search box function
When Admin enters staff id which is not existing the table into search box  
Then Displays empty details in the data table

Scenario: Validate search box function
When Admin enters class date into search box  
Then Displays entries with that  class date

Scenario: Validate search box function
When Admin enters invalid class date into search box  
Then Displays empty details in the data table