@smokeTest
Feature: To validate the response message

  @smokeTest
  Scenario: To validate the response message using cucumber
    Given When user submits input schema
    When User submits the request
    Then Validate the response schema matches with the input schema

