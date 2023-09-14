#90-91
Feature: Pagination in manage class

Background: Logged on the LMS portal as Admin and Admin click +Add New Class button after reaching to Manage class page
Given Admin is in add class details popup window

Scenario: Verify next page is enabled	
When Admin creates 6  new class
Then total class entries above 5 next page is enabled ( On multiples of 5 new page will be enabled)

Scenario: verify next page is disabled		
When Admin creates less than or equal to 5 new class 	
Then total class entries  5 or below next page is disabled

