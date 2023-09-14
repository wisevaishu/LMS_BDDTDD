Feature: Manage assignment page Verification
Background: 
Given Logged on the LMS portal as Admin
 
@Scenario1
Scenario: Verify landing in manage assignment page
Given Admin is on dashboard page after Login
When Admin clicks "assignment" button on the navigation bar
Then Admin should see URL with "Manage assignment" in assignment module

@Scenario_Response_Time
Scenario: Capture the response time to navigate to manage assignment page
Given Admin is on dashboard page after Login
When Admin clicks "assignment" button on the navigation bar
Then Get the response time for navigation from dashboard page to manage assignment page
 
 @Scenario_Verify_Header
Scenario: Verify manage assignment page Header
Given    Admin is on dashboard page after Login
When     Admin clicks "assignment" button on the navigation bar
Then Admin should see header with "Manage assignment" in assignment module

@Scenario_Verify_Text
Scenario: Validate text in manage assignment page
Given    Admin is on dashboard page after Login
When Admin clicks "assignment" button on the navigation bar and get all text from the portal page
Then Admin should see correct spelling for the all the fields

@Delete_Icon_Visibility
Scenario: Verify delete icon below the header
Given    Admin is on dashboard page after Login
When Admin clicks "assignment" button on the navigation bar
Then Admin should see disabled delete icon below the "Manage assignment" in assignment module

@Search_Bar
Scenario: Admin is on dashboard page after Login
When Admin clicks "assignment" button on the navigation bar
Then Admin should see search bar on the manage assignment page

@csenario_Add_New_Assignment_Button
Scenario: Verify add new assignment button  on manage assignment page
Given    Admin is on dashboard page after Login
When Admin clicks "assignment" button on the navigation bar
Then Admin should see +Add New assignment button on the manage assignment page

# @Scenario_Data_Table
# Scenario: Verify data table on the manage assignment page
# Given    Admin is on dashboard page after Login
#When Admin clicks "assignment" button on the navigation bar
#Then Admin should see data table on the manage assignment page With following column headers. 
#(check box symbol ,Assignment name, Assignment description, Assignment Date, Assignment Grade, Edit,Delete)

#@Data_Table_Edit_Button
#Scenario: Verify Edit icon in the data table
#Given    Admin is on dashboard page after Login
#When  Admin clicks "assignment" button on the navigation bar
#Then Edit Icon in each row of data table only  when entries are available

#@No_Edit_Button
#Scenario: Verify Edit icon when no data in the table
#Given    Admin is on dashboard page after Login
#When Admin clicks "assignment" button on the navigation bar
#Then Edit Icon will not be present in data table

#@Delete_button_Data_Table
#Scenario: Verify delete icon in the data table
#Given    Admin is on dashboard page after Login
#When Admin clicks "assignment" button on the navigation bar
#Then Delete Icon in each row of data table only  when entries are available

#@Delete_button_No_Data
#Scenario: Verify delete icon when no data in the table
#Given Admin is on dashboard page after Login
#When Admin clicks "assignment" button on the navigation bar
#Then Delete Icon will not be present in data table

#@Sort_Icon
#Scenario: Verify sort icon in the data table
#Given    Admin is on dashboard page after Login
#When Admin clicks "assignment" button on the navigation bar
#Then Admin should see sort icon near the column headers except for Edit and Delete

#@Check_box_Data_Table
#Scenario: Verify check box in the data table
#Given    Admin is on dashboard page after Login
#When Admin clicks "assignment" button on the navigation bar
#Then  Admin should see check box in the all rows  of data table when entries available

#@Number_entries
#Scenario: Validate the number entries displaying
#Given    Admin is on dashboard page after Login
#When Admin clicks "assignment" button on the navigation bar
#Then  Above the footer Admin should see the text as ""Showing x to y of z entries"" below the table.                                                              Note: with or without entries"

##Scenario: Verify Pagination control below the data table
#Given    Admin is on dashboard page after Login
#When  Admin clicks "assignment" button on the navigation bar
#Then Admin should see the pagination controls under the data table

#@Footer_Text
#Scenario: Validate footer  text
#Given    Admin is on dashboard page after Login
#When Admin clicks "assignment" button on the navigation bar
#Then Admin should see the text with total number assignments in the data table. 
#( In total there are number of assignments)

##@Tag
#Scenario: Validate search box function
#Given    Admin is on manage assignment page
#When Admin enters following  entries into search box 
#Then Displays entries with that assignment name
 
 #Given    Admin is on manage assignment page
 
#When Admin enters assignment  name is not existing the table into search box  
#Then Displays empty details in the data table

#And Admin enters assignment description into search box  
#When Admin enters assignment description which is not existing the table into search box  
#When Admin enters assignment description which is not existing the table into search box  
#When Admin enters assignment due date which is not existing the table into search box  
#When Admin enters grade value  into search box  
#When Admin enters grade value which is not existing the table into search box  


#Then Displays entries with that assignment description
#Then Displays empty details in the data table
#Then Displays entries with that assignment due date
#Then Displays empty details in the data table
#Then Displays entries with that assignment  grade
#Then Displays empty details in the data table



