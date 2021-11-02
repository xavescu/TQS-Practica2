Feature: Belly

  Scenario: a few cukes
    Given I have 4 cukes in my belly
    When I wait 4 hour
    Then my belly should growl
