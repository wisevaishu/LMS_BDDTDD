Feature: Add New Attendance

  Background:
    Given Admin is on the Manage Attendance page after login
    And Admin clicks the "+ Add New Attendance" button after reaching the Attendance details popup window

  Scenario: Validate admin able to create new attendance data with all values
    When Admin fills all the values and clicks save
    Then Admin should see success message in popup window and sees new attendance details in manage attendance details DB
  
   Scenario Outline: Validate admin able to create new attendance data with missing values
    When Admin fills the values missing and clicks save 
    Then Admin should see <expected_message>

    Examples:
      | expected_message                      |
      | Program name is missing               |
      | Class name is missing                 |
      | Student name is missing               |
      | Attendance is missing                 |
      | Attendance date is missing            |
      | Invalid attendance date               |

   

