Feature: Dashboard Page

Background: 
Given Admin launch browser
When Admin gives the correct LMS
Then Admin should land on home page
And Admin click Home Page Login
Then Admin enter ValidUser and Password
And Admin click Login button

Scenario: Verify Dashboard Page
Then Admin should see manage program as header 
And HTTP response >= 400 the "<dashboardurl>" is broken
Then Admin should see "LMS-Learning Management system" as title
And Admin should see LMS title on top left corner of page
And Admin should see correct spelling in navigation bar text
Then Admin should see correct spelling and space in LMS title
And Admin should see the navigation bar text on the top right side

Scenario Outline: Verify Menus in appropriate places
Given Admin in Dashboard Page
Then Admin should see Menus in the the appropriate places "<Menuname>" and "<Position_no>"
Examples: 
|Menuname  |Position_no|
|Student   |1          |
|Program   |2          |
|Batch     |3          |
|Class     |4          |
|User      |5          |
|Assignment|6          |
|Attendance|7          |
|Logout    |8          |

Scenario: Verify Logout button function
Given Admin in Dashboard Page
Then Admin click Logout from navigation bar
And Admin in Login Page



