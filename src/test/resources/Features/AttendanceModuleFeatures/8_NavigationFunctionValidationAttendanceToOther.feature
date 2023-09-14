Feature: Navigation function validation from manage attendance page to other pages  
Background:  Admin is on the Manage Attendance page after login

Scenario Outline: Verify admin is able to navigate to "<page>" from Manage Attendance page
  Given Admin is on the Manage Attendance page after login
  When Admin clicks the "<page>" button in the navigation bar
  Then Admin should be able to land on the "<page>" page

  Examples:
    | page         |
    | Student      |
    | Program      |
    | Batch        |
    | User         |
    | Assignment   |
    | Class        |
  
   
    Scenario: Verify admin is able to navigate to Login from Manage Attendance page
     When Admin clicks the Logout  button in the navigation bar
     Then Admin should be able to land on the Login page