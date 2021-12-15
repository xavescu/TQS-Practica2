Feature: Tests a page using Selenium WebDriver
  In order to evaluate Selenium Framework
  As a developer
  I want to interact with my JSAlerts page

  Scenario: I have the JS alert expected when I click the button - Alert
    Given I go to the js alerts page
    When I click on "Click for JS Alert" button
    And I close the JS Alert
    Then I have "You successfully clicked an alert" as result message

  Scenario: I have the JS alert expected when I click the button - Confirm(Cancel)
    Given I go to the js alerts page
    When I click on "Click for JS Confirm" button
    And I close the JS Alert
    Then I have "You clicked: Cancel" as result message

  Scenario: I have the JS alert expected when I click the button - Confirm(Ok)
    Given I go to the js alerts page
    When I click on "Click for JS Confirm" button
    And I accept the JS Alert
    Then I have "You clicked: Ok" as result message

  Scenario: I have the JS alert expected when I click the button - Prompt(No value)
    Given I go to the js alerts page
    When I click on "Click for JS Prompt" button
    And I accept the JS Alert
    Then I have "You entered:" as result message

  Scenario: I have the JS alert expected when I click the button - Prompt(Some value - Accept)
    Given I go to the js alerts page
    When I click on "Click for JS Prompt" button
    And I enter "Sample" to the JS Alert
    And I accept the JS Alert
    Then I have "You entered: Sample" as result message

  Scenario: I have the JS alert expected when I click the button - Prompt(Some value - Cancel)
    Given I go to the js alerts page
    When I click on "Click for JS Prompt" button
    And I enter "Sample" to the JS Alert
    And I close the JS Alert
    Then I have "You entered: null" as result message