Feature: Attendance details popup window  verification
 
  Scenario Outline: Verify <element>
    Given: Admin is Manage attendance page after login
    When Admin clicks the "+ Add New Attendance" button
    Then Admin should see <expected_result>

   Examples:
      | element                                            | expected_result                                                     |
      | all label text                 							 			 | Correct spellings in the labels                                     |
      | dropdown box is present                            | 4 dropdowns should be present                                       |
      | close button in attendance details popup window    | Close button should be present on the popup window                  |
      | the alignment of the close button                  | Close button should be in the top right corner                      |
      | the text on first dropdown select a program name    | The first dropdown box should have the text "Select a Program Name" |
      | the text on second dropdown select class  name     | The second dropdown box should have the text "Select Class Name"    |
      | the text on third dropdown select students         | The third dropdown box should have the text "Select Students"       |
      | the text on fourth dropdown select attendance      | The fourth dropdown box should have the text "Select Attendance"    |
      | all the text inside the dropdown box is gray color | Text in gray color                                                  |
      | save button is present                             | Save button should be present in the popup window                   |
      |cancel button is present                            | Cancel button should be present in the popup window                 |
      | order of the label in attendance details page      | The order of the labels should be Program name, Class Name, Student Name, Attendance, Attendance Date. |
  

  Scenario Outline: Verify <element> dropdown
  
  Given: Admin clicks the "+ Add New Attendance" button after reaching Attendance details PopPup window
    When Admin clicks <element> dropdown
    Then <element> in the dropdown should match with <element> in the respective page table

    Examples:
      | element        |
      | Program Name   |
      | Class Name     |
      | Attendance     |

  Scenario Outline: Validate attendance field dropdown all mandatory keywords
  Given: Admin clicks the "+ Add New Attendance" button after reaching Attendance details PopPup window
    When Admin clicks Attendance dropdown
    Then the Attendance field should have keywords such as <keywords>
    And Admin should see correct spellings in dropdown text
     Examples:
    | keywords                            |
    | present, absent, late, excused      |
    
  
  Scenario: Validate date picker
  Given: Admin clicks the "+ Add New Attendance" button after reaching Attendance details PopPup window
    When Admin clicks date from date picker in attendance module
    Then the selected date should be in the given format

  Scenario Outline: Validate navigation arrows in date picker
  Given: Admin clicks the "+ Add New Attendance" button after reaching Attendance details PopPup window
    When Admin clicks <arrow> arrow in the date picker near month
    Then <new_month> month calendar should be visible

    Examples:
      | arrow       | new_month  |
      | right arrow | Next month |
      | left arrow  | Previous month |

  Scenario: Validate date highlights in date picker
  Given: Admin clicks the "+ Add New Attendance" button after reaching Attendance details PopPup window
    When Admin clicks date picker button in attendance module
    Then Admin should see the current date highlighted in the date picker

  Scenario: Validate selected date highlights in date picker
  Given: Admin clicks the "+ Add New Attendance" button after reaching Attendance details PopPup window
    When Admin clicks date picker button and selects a future date
    Then Admin should see the selected date highlighted in the date picker