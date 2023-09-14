 @Attendance
 Feature: Manage Attendance Page Verification

  Background:
    Given Admin is in the Manage Attendance page At first 

 @1_Page_Header
  Scenario: Validate the header of the page
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see "Manage Attendance" in the header
    
 @2_response_time
  Scenario: Validate response time from dashboard page to attendance page
    When Admin clicks "Attendance" on the navigation bar
    Then Maximum navigation time should not exceed 30 seconds

@3_broken_link
  Scenario: Validate the broken link
    When Admin clicks "Attendance" on the navigation bar
    Then HTTP response code should be greater than or equal to 400
    And the link is broken

@4_LMS_title
  Scenario: Verify LMS title
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see "LMS - Learning management system" as the title

@5_alignment_Header
  Scenario: Verify the alignment of the Manage Attendance header
    When Admin clicks "Attendance" on the navigation bar
    Then Manage Attendance header should be on the left side of the page

@6_textin_page
  Scenario: Validate text in manage attendance page
    When Admin clicks "Attendance" button on the navigation bar in attendance module
    And Admin gets all text from the portal page
    Then Admin should see correct spelling for all the fields

@7_Header_delete_icon
  Scenario: Verify delete icon below the header
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see a disabled delete icon below the "Manage Attendance"

@8_verify_Search_Attendance
  Scenario: Verify search bar on the Attendance page
    When Admin clicks "Attendance" on the navigation bar in attendance module
    Then Admin should see a search bar on the attendance page

@9_Verify_+Add_New_Attendance
  Scenario: Verify +Add New Attendance button on Attendance page
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see a "+Add New Attendance" button on the attendance page

@10_Data_Table
  Scenario: Verify data table on the attendance page
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see a data table on the Manage Attendance Page
    And the table should have the following column headers: "Check box symbol", "Class ID", "Student Id", "Present", "Edit / Delete"

@11_Edit_icon
  Scenario: Verify Edit icon in the data table
    When Admin clicks "Attendance" on the navigation bar
    Then Edit icons should be present in each row of the data table when entries are available

@12_Edit_icon_nodata
  Scenario: Verify Edit icon when no data in the table
    When Admin clicks "Attendance" on the navigation bar
    Then Edit icons should not be present in the data table when there are no entries in the attendance page

@13_delete_icon
  Scenario: Verify delete icon in the data table
    When Admin clicks "Attendance" on the navigation bar
    Then Delete icons should be present in each row of the data table when entries are available

@14_Delete_icon_nodata
  Scenario: Verify delete icon when no data in the table
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should not see Delete icons in the data table when there are no entries in attendance page

@15_sort_icon
  Scenario: Verify sort icon in the data table
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see sort icons near the column headers except for "Edit" and "Delete" in attendance page

@16_check_box_dataTable 
  Scenario: Verify check box in the data table
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see a check box in all rows of the data table in attendance page

@17_number_of_entries
  Scenario: Validate the number of entries displaying
    When Admin clicks "Attendance" on the navigation bar
    Then Above the footer, Admin should see the text "Showing x to y of z entries" below the table in attendance page
    And x - starting record number on that page
    And y - ending record number on that page
    And z - Total number of records
   
@18_Pagination_control
  Scenario: Verify Pagination control below the data table
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see the pagination controls under the data table in attendance page

@19_Footer
  Scenario: Validate footer text
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see the text "In total there are number of Attendances" in the data table footer in attendance page


