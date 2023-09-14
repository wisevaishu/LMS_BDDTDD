Feature: Pagination in manage Assigmment
 
Background: Logged on the LMS portal as Admin
Given The Admin is on dashboard page after Login
When Admin clicks Assigmment button on the navigation bar

Scenario: Verify sheet one is displayed on default in data table
Then Data table should display one page  when entries available in assignment module

Scenario: Verify  right arrow is enable when sheet one is displayed in data table
Then Right arrow should be enabled in page one  when entries are more than 5 available in assignment module

Scenario: Verify  left arrow is disable when sheet one is displayed in data table
Then Left arrow should be disabled in page one  when entries are more than 5 available in assignment module

Scenario: Verify  right arrow is enable when sheet two is displayed in data table when entries are more than 10
Then Right arrow should be enabled in page two when entries are more than 10 available in assignment module

Scenario: Verify  left arrow is enable when sheet two is displayed in data table
Then 	Left arrow should be enabled in page two in assignment module

#Scenario: Verify  right arrow is disable when sheet two is displayed in data table when entries are less than 10
#Then Data table should display  page 1  when entries available

Scenario: Verify pagination controls enabled
Then entries are more than 5 in data table pagination controls enabled in assignment module

Scenario: Verify pagination controls disabled
Then entries are less than 5 in data table pagination controls disabled in assignment module