Feature: Delete multiple attendance validation

Background: Admin logged into LMS portal and clicks attendance button on the navigation bar 
            Given Admin is in manage attendance page

	Scenario Outline: Verify delete multiple class button is enabled
    When Admin clicks <checkbox_type> row level checkbox in the data table
    Then Admin should see delete icon below the header is enabled in attendance module

    Examples:
      | checkbox_type     |
      | single            |
      | multiple          |

Scenario Outline: Verify tick mark is visible after clicking on checkbox for single data
    When Admin clicks <checkbox_type> row level checkbox in the data table
    Then Admin should see tick mark in checkbox

    Examples:
      | checkbox_type     |
      | single            |
      | multiple          |

Scenario Outline: Verify admin is able to click multiple checkboxes
    When Admin clicks <checkbox_type> row level checkboxes in the data table
    Then Admin should see tick marks in checkboxes of the selected rows

    Examples:
      | checkbox_type     |
      | single            |
      | multiple          |
      
    Scenario Outline: Verify accept alert in delete multiple attendance by selecting <checkbox_type> checkbox
    Given Admin clicks delete button under header after selecting the <checkbox_type> checkboxes in the data table & Admin is in delete alert
    When Admin clicks yes button of delete alert popup
    Then Success message and selected attendance detail are deleted from the data table

    Examples:
      | checkbox_type     |
      | single            |
      | multiple          |

  Scenario Outline: Verify reject alert in delete multiple attendance by selecting <checkbox_type> checkbox
    Given Admin clicks delete button under header after selecting the <checkbox_type> checkboxes in the data table & Admin is in delete alert
    When Admin clicks no button from attendance module
    Then Redirected to the attendance page and selected attendance details are not deleted from the data table

    Examples:
      | checkbox_type     |
      | single            |
      | multiple          |
