Feature: Pagination in Manage Attendance

  Background:
    Given Admin is logged into the LMS portal as an Admin
    And Admin is on the dashboard page after login
    When Admin clicks the "attendance" button on the navigation bar

  Scenario: Verify sheet one is displayed on default in the data table
    Then Data table should display 1 page when entries are available

  Scenario: Verify right arrow is enabled when sheet one is displayed in the data table
    Then Right arrow should be enabled in page one when entries are more than 5 are available

  Scenario: Verify left arrow is disabled when sheet one is displayed in the data table
    Then Left arrow should be disabled in page one when entries are more than 5 are available

  Scenario: Verify right arrow is enabled when sheet two is displayed in the data table when entries are more than 10
    Then Right arrow should be enabled in page two when entries are more than 10 are available

  Scenario: Verify left arrow is enabled when sheet two is displayed in the data table
    Then Left arrow should be enabled in page two in attendance module

  Scenario: Verify right arrow is disabled when sheet two is displayed in the data table when entries are less than 10
    Then Data table should display 1 page when entries are available

  Scenario: Verify pagination controls enabled
    Then Pagination controls should be enabled when entries are more than 5 in the data table

  Scenario: Verify pagination controls disabled
    Then Pagination controls should be disabled when entries are less than 5 in the data table

  Scenario: Verify next page is enabled
    Given Admin clicks the +Add New attendance button after reaching the Manage attendance page
    And Admin is in the add attendance details popup window
    When Admin creates 6 new attendance entries
    Then Next page should be enabled when total attendance entries are above 5

  Scenario: Verify next page is disabled
    Given Admin is in the add attendance details popup window
    And Admin creates less than or equal to 5 new attendance entries
    Then Next page should be disabled when total attendance entries are 5 or below
