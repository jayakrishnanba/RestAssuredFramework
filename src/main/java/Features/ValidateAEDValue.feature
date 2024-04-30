@smokeTest
Feature: API call is successful and returns valid price

  @smokeTest
  Scenario: To validate the API call is successful and returns valid AED Value
    When User enters the request parameter
    Then Verify the response is returned as AED Value for dollar value

