Feature: Login and Navigation
  As a user
  I want to login and see the home page


  Scenario: Successful login and home page displayed correctly
    Given I am on the login page
    When I login with valid credentials
    And I navigate to the home page
    Then I should see the list of product