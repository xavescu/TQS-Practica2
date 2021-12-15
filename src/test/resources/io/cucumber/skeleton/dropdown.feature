Feature: Tests a page using Selenium WebDriver
  In order to evaluate Selenium Framework
  As a developer
  I want to interact with my Checkboxes page

  Scenario: The section has the expected dropdowns
    Given I go to the Dropdown section page
    Then I should see 1 dropdowns
    And Dropdown has the disabled value option selected
    And I take a screenshot with filename "DropDown initialize"

  Scenario: The dropdown has the expected options to select
    Given I go to the Dropdown section page
    Then Dropdown has 3 available options

  Scenario: We can select the Option 1
    Given I go to the Dropdown section page
    When I select 1 option of the dropdown
    Then 1 option of the dropdown is selected
    And I take a screenshot with filename "DropDown Option 1 selected"

  Scenario: We can select the Option 2
    Given I go to the Dropdown section page
    When I select 2 option of the dropdown
    Then 2 option of the dropdown is selected
    And I take a screenshot with filename "DropDown Option 2 selected"