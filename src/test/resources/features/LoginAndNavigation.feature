Feature: Login
  Scenario: Valid login and navigation
    Given I am on the login page
    When I login with valid credentials
    Then I should see the home page