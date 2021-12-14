Feature: Tests a page using Selenium WebDriver
  In order to evaluate Selenium Framework
  As a developer
  I want to interact with my Add/Remove Elements page

  Scenario: The section has the expected initial state (only 1 [Add Element] button)
    Given I go to the Add Remove Elements section page
    Then I should see a "Add Element" button
    
  Scenario: The section has the expected initial state (only 1 [Add Element] button)
    Given I go to the Add Remove Elements section page  
    Then I should see 1 Buttons
    
  Scenario: A new element is added if we click Add Element button
    Given I go to the Add Remove Elements section page
    When I click on "Add Element" button
    Then I should see a "Delete" button

  Scenario: A new element is added if we click Add Element button
    Given I go to the Add Remove Elements section page
    When I click on "Add Element" button
    Then I should see 2 Buttons

  Scenario: A new element is added if we click Add Element button
    Given I go to the Add Remove Elements section page
    When I click on "Add Element" button
    When I click on "Delete" button
    Then I should see 1 Buttons