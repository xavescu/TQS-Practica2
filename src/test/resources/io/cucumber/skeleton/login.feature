Feature: Tests a page using Selenium WebDriver
  In order to evaluate Selenium Framework
  As a developer
  I want to interact with my login

  Scenario: I login with a wrong user
    Given I go to the login page
    When I add "dummy" as user
    And I add "dummy" as pass
    And I click on Login button
    Then I see error message User

  Scenario: I login with a wrong pass
    Given I go to the login page
    When I add "tomsmith" as user
    And I add "dummy" as pass
    And I click on Login button
    Then I see error message Password

  Scenario: I login with the correct credentials
    Given I go to the login page
    When I add "tomsmith" as user
    And I add "SuperSecretPassword!" as pass
    And I click on Login button
    Then I see success message

  Scenario: Logged in I'm able to logout successfully
    Given I go to the login page
    When I add "tomsmith" as user
    And I add "SuperSecretPassword!" as pass
    And I click on Login button
    And I click on Logout button
    Then I see success logout message