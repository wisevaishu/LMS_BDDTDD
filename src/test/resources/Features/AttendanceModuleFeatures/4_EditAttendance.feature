Feature: Edit Attendance
  Background: Admin click +Add New Attendance button after reaching to Manage attendance page
              Admin is in  attendance details popup window

Scenario Outline: Validate admin able to update attendance data
    When Admin fills <field> with <value> and clicks save
    Then Admin should see <result>

    Examples:
      | field           | value             | result                  |
      | all values      | filled            | success message and DB  |
      | program name    | (empty)           | Program name is missing |
      | class name      | (empty)           | Class name is missing   |
      | student name    | (empty)           | Student name is missing |
      | attendance      | (empty)           | Attendance is missing   |
      | attendance date | (empty)           | Attendance date is missing |
      | attendance date | future date       | Invalidate attendance date |





