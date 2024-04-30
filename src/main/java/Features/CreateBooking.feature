@smokeTest
Feature: To create a new booking in restful-booker

  @smokeTest
  Scenario Outline: To create new booking using cucumber Data Table
    Given user has access to endpoint "/booking"
    When user creates booking
      | firstname   | lastname   | totalprice   | depositpaid   | checkin   | checkout   | additionalneeds   |
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> |
    Then user should get the response code 200
    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin | checkout | additionalneeds |
