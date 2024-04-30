@smokeTest
Feature: To validate the response message

  @smokeTest
  Scenario: To validate the response message using cucumber
    When user enters request
    Then Validate success message in response

