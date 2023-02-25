Feature: Verify whether we are able to view, update and delete EMPLOYEES

  Scenario: Verify whether we are able to view the employee
    Given user hits the GET "/employees" endpoint
    Then user should be able to complete list of the EMPLOYEES