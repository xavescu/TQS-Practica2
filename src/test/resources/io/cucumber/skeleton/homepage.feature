Feature: Tests a page using Selenium WebDriver
  In order to evaluate Selenium Framework
  As a developer
  I want to interact with my homepage

  Scenario: My homepage has the expected linkText
  Given I go to the home page
  Then I should see a "Add/Remove Elements" linkText

  Scenario: My homepage has the expected amount of linkTexts
  Given I go to the home page
  Then I should see 46 linkTexts

  Scenario: My homepage has the expected amount of linkTexts
    Given I go to the home page
    Then I should see 44 list elements
  
  Scenario: My homepage is able to send us to the Add/Remove Section
  Given I go to the home page
  When I click on "Add/Remove Elements" linkText
  Then I go to the Add Remove Elements section
