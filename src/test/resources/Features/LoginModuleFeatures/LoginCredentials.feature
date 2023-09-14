Feature: Login Feature using Credentials

Background: 
Given Admin launch browser
When Admin gives the correct LMS
Then Admin should land on home page
And Admin click Home Page Login

Scenario: Validate login with valid credentials
Given Admin enter ValidUser and Password
When Admin click Login button
Then Admin lands on Dashboard Page 

Scenario Outline: Validate login with invalid credentials
Given Admin enter "<Username>" and "<Password>"
When  Admin click Login button
Then Admin should see "<Errormessage>" in Login Module
Examples:
|Username       |Password       |Errormessage                      |
|invalidusername|invalidpassword|please check username or password |
|validusername	|invalidpassword|please check password             |
|invalidusername|validpassword	|please check username             |
|emptyusername  |validpassword  |please check username/password    |
|validusername  |emptypassword  |please check username/password    |
|emptyusername  |emptypassword  |please check username/password    |

Scenario: verify login button action through keyboard
Given Admin enter ValidUser and Password
When Admin click Login button through keyboard
Then Admin lands on Dashboard Page

Scenario: verify login button action through keyboard
Given Admin enter ValidUser and Password
When Admin click Login button through Action Click
Then Admin lands on Dashboard Page

  