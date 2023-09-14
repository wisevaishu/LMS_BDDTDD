Feature: Login Feature

Scenario: Verify the Login Page
Given Admin launch browser
When Admin gives the correct LMS
Then Admin should land on home page
And Admin click Login button from Home Page 
Then Admin in Login Page
And HTTP response >= 400 the "<loginurl>" is broken
And Admin see "<Please login to LMS application>" in the header
And Admin should see correct spellings in all fields in "LoginPage"
And Admin should see 2 text field in "login" page
And Admin should see input field on the center of page
And Admin should see the "login" button
And Admin should see forgot username or password link
And Admin should see "<user>" in gray color
And Admin should see "<password>" in gray color

 


 

