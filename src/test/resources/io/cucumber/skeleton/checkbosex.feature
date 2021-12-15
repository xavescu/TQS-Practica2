Feature: Tests a page using Selenium WebDriver
  In order to evaluate Selenium Framework
  As a developer
  I want to interact with my Checkboxes page

  Scenario: The section has the expected checkboxes
    Given I go to the Checkboxes section page
    Then I should see 2 checkboxes

  Scenario: The section has the expected checkboxes state
    Given I go to the Checkboxes section page
    Then "checkbox 1" checkbox IS NOT checked
    And "checkbox 2" checkbox IS checked

  Scenario: The checkbox change the state correctly when we click it
    Given I go to the Checkboxes section page
    When I click "checkbox 1" checkbox
    Then "checkbox 1" checkbox IS checked

  Scenario: The checkbox change the state correctly when we click it twice
    Given I go to the Checkboxes section page
    When I click "checkbox 1" checkbox
    And I click "checkbox 1" checkbox
    Then "checkbox 1" checkbox IS NOT checked
