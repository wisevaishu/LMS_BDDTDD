Feature: Delete attendance validation
 
 Background: Admin logged into LMS portal
 
 Scenario: Verify Delete attendance alert
 Given Admin is in manage attendance page 
 When Admin clicks delete button in data table row level	
 Then Admin should see alert of delete attendance

 Scenario: Verify  accept enabled in alert
 Given Admin is in manage attendance page 
 When Admin clicks delete button in data table row level for single deletion
Then Alert should have "yes" button to accept

 
 Scenario: Verify reject enabled in alert
 Given Admin is in manage attendance page 
 When Admin clicks delete button in data table row level 
Then 	Alert should have "No" button to reject

 
 
  Scenario Outline: Validate accept and reject in alert
    Given Admin clicks row level delete button & is in delete alert
    When Admin clicks <button> button
    Then <result>

    Examples:
      | button | result                                            |
      | yes    | Success message and selected attendance details |
      | no     | Redirected attendance page and selected attendance details are not deleted from the data table                       |
 