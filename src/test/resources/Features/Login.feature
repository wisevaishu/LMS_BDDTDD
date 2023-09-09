Feature: Login Feature

Background: 
Given Admin click Login button from Home Page
Then Admin in Login Page
 
Scenario: Validate login with valid credentials
Given Admin enter ValidUser and Password
When Admin click Login button
Then Admin lands on Dashboard Page    

 

