#68-70

Feature: Delete class Validation

Background: Admin logged into LMS portal and clicks class button on the navigation bar 
Given Admin is on Manage Class Page
When Admin clicks delete button in data table row level

Scenario: Verify Delete class alert
Then Admin should see alert

Scenario: Verify  accept enabled in alert
Then Alert should have yes button to accept 

Scenario: Verify reject enabled in alert
Then Alert should have No button to reject
