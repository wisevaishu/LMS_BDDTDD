Feature: Pagination in manage assignment
Background: Admin click +Add New assignment button after reaching to manage assignment page


@Scenario1
Scenario: Verify next page is enabled
Given Admin is in add assignment details popup window
When Admin creates 6 new assignment
Then In this case total class entries above 5 next page is enabled ( On multiples of 5 new page will be enabled)

@Scenario2
Scenario: verify next page is disabled
Given Admin is in add assignment details popup window
When Admin creates less than or equal to 5 new  assignment 
Then  In this case entries are less than 5 in data table pagination controls disabled
