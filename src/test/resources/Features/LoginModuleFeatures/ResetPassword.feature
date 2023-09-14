Feature: Reset password

Background:
Given Admin launch browser
When Admin gives the correct LMS
Then Admin should land on home page
And Admin click Login button from Home Page 
Then Admin in Login Page
And Admin Clicks Reset Password Link
And Admin lands on Reset password page

Scenario: Verify  reset password link Page
Then Admin should see correct spellings in all fields in "ResetPasswordPage"
And Admin should see the "ResetSubmit" button
Then Admin should see 2 text field in "ResetSubmit" page
And Admin should see text boxes in disabled stage

Scenario: verify text box is in enabled in new password field
When Admin clicks on "new_password" field
Then Admin should see "new_password" text box is enabled state

Scenario: verify text box is in enabled in retype password field
When Admin clicks on "retype_password" field
Then Admin should see "new_retypepassword" text box is enabled state

Scenario Outline: Validate reset password with valid details
When Admin enters "<password>" and "<retypepassword>"
Then Admin clicks submit button
And Admin see corresponding "<messages>"
Examples: 
| password      | retyppassword    | messages                                                 |
| samepassword  | samepassword     | Your password has been reset Please click here to login  |
| emptypassword | emptypassword    | please try again                                         |
| password      | differentpassword| please try again																		      | 
