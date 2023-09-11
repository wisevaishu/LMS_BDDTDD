Feature: Hompe page verification

Background:
Given Admin launch browser

Scenario:Verify for broken link
Given Admin gives the correct LMS
When HTTP response >= 400 the "<homeurl>" is broken

Scenario: Verify admin is able to land on home page
When Admin gives the correct LMS
Then Admin should land on home page

Scenario: Verify admin is able to land on home page with invalid URL
When Admin gives Invalid URL
When HTTP response >= 400 the "<invalidurl>" is broken

Scenario Outline: Verify the appearance of LMS Page
Given Admin gives the correct LMS
Then Admin checks corresponding "<appearances>" 
Examples:
| appearances            |
| text_spelling          |
| logo                   |
| logo_aligned           |
| login_button_Visiblity |
| login_button_clickable |
| Broken_Logo_Image      |



