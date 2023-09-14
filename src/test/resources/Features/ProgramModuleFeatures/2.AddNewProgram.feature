Feature: Admin validate Adding new Program


Background: 

Given Admin is on Manage Program Page after clicks Program on the navigation bar

And Admin is on Manage Program Page

And Admin is on Program Details popup window



@Tag_001

Scenario: Validate program Details Popup window

	When Admin clicks "+ A New Program" button on manage program page	

	Then Admin should see a popup open for Program Details with empty form along with "Cancel" and "Save" button "close" icon on the top right corner

				

@Tag_002

Scenario: Validate input fields and their text boxes in the Program details form

	Then Admin should see two input fields and their respective text boxes in the program details window

	

@Tag_003

Scenario: Validate radio button for Program Status

	Then Admin should see two radio button for Program Status

		

	

@Tag_004

Scenario: Empty form submission

	When Admin clicks "Save" button without entering any data on program details popup

	Then Admin gets a Error message alert on program page

	

@Tag_005

Scenario Outline: Enter only Program Name

	Given Admin is on Program Details popup window

	When Admin enters the sheetname "<sheetname>" and row number <rownum> on program

	Then Admin should get a message alert "Name is required" on program details popup

	And Admin should get a message alert "Description is required" on program details popup

	

	Examples:

	|sheetname			|rownum |

	|AddProgram			|1			|

	|AddProgram			|2			|



@Tag_006

Scenario: Select Status only	

	When Admin selects only "Status" and click "Save" button on program details popup

	Then Admin should get a message alert "Name and Description are required" on program details popup

	

@Tag_007

Scenario Outline: Validate invalid values on the column 

	When Admin enters the sheetname "<sheetname>" and row number <rownum> on add program

	Then Admin gets a Error message alert on program page

	

	Examples:

	|sheetname			|rownum |

	|AddProgram			|3			|

	

@Tag_008

Scenario: Validate Cancel/close icon on Program details form

	When Admin clicks "Cancel/Close" icon on Program Details form

	Then Program details popup window should be closed without saving

	

@Tag_009

Scenario Outline: Validate Save button on Program Details form

	When Admin enters the sheetname "<sheetname>" and row number <rownum> on program module

	Then Admin gets a message "Successfully Program created" and able to see the new program added on the data table

	

	Examples:

	|sheetname			|rownum |

	|AddProgram			|4			|

	

@Tag_010

Scenario: Validate cancel button on Program Details form

	Then Admin can see the program details popup disappear without creating any program