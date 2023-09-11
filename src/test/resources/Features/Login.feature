Feature: Login Feature

Background: 

Scenario: Verify the Login Page
Given Admin gives the correct LMS
Then Admin should land on home page
And Admin click Login button from Home Page 
Then Admin in Login Page
And HTTP response >= 400 the "<loginurl>" is broken
And Admin see "<Please login to LMS application>" in the header
And Admin should see correct spellings in all fields

Scenario: Validate login with valid credentials
Given Admin enter ValidUser and Password
When Admin click Login button
Then Admin lands on Dashboard Page    


 

