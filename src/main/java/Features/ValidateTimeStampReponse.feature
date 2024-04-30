@smokeTest
Feature: To validate the Timestamp response

  @smokeTest
  Scenario: To validate the Timestamp response is not less than 3 seconds
    When User enters the input request
    Then Validate the timestamp response is not less than 3 seconds

