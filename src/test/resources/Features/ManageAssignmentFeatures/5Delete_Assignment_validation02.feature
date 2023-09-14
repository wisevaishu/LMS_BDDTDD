Feature: Delete Assignment validation
Background: Admin clicks row level delete button after landing to manage assignment page
 



@Scenario1
Scenario: Validate accept in alert
Given Admin is in delete alert
When Admin clicks yes button
Then Success message and validate particular Assignment details are deleted from the data table

@Scenario2
Scenario: Validate reject in alert
Given Admin is in delete alert
When Admin clicks no button
Then Success message and validate particular Assignment details are deleted from the data table


