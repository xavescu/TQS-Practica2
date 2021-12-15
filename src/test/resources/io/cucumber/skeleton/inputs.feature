Feature: Tests a page using Selenium WebDriver
  In order to evaluate Selenium Framework
  As a developer
  I want to interact with my Inputs page

  Scenario: The section has the expected Input (number type)
    Given I go to the Inputs section page
    Then I should see 1 number inputs

  Scenario: The Input is initialize with the expected value (empty)
    Given I go to the Inputs section page
    Then Input value is empty

  #Scenario: The Input value is increase by 1 if we click the up arrow
   # Given I go to the Inputs section page
    #When I click the increment arrow
    #Then Input value is "1"

  Scenario: The Input value is decrease by 1 if we click the down arrow
    Given I go to the Inputs section page