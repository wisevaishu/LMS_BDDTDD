Feature: Forget Username and Password

Background:
Given Admin launch browser
When Admin gives the correct LMS
Then Admin should land on home page
And Admin click Login button from Home Page 
Then Admin in Login Page
And Admin Clicks Forgot Username or Password Link
And Admin lands on forgot username or password page

Scenario: Verify the Forget Username and Password Page
When HTTP response >= 400 the "<forgotusernamepasswordurl>" is broken
Then Admin should see "<Email>" in gray color
And Admin should see "Email" and "*" in text field
Then Admin should see the "sendlink" button
And Admin should see correct spellings in all fields in "ForgotUserPasswordPage"

Scenario: Validate email sent for forgot password
When Admin enter "ValidEmail"
Then Admin clicks send link button 
And Admin should receive link in mail for reset username or password



