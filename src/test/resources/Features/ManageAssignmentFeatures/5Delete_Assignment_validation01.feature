Feature: Delete Assignment Validation

Background: Admin logged into LMS portal and Assignment class button on the navigation bar 
Given Admin is on Manage Assignment Page
When Admin clicks delete button in data table row level

Scenario: Verify Delete class alert
Then Admin should see alert

Scenario: Verify  accept enabled in alert
Then Alert should have yes button to accept 

Scenario: Verify reject enabled in alert
Then Alert should have No button to reject