Feature: Login Functionality
  Scenario: Login with valid credentials
    Given I am on the login page
    When I enter a valid email address and valid password
    And I click on the "Sign In" button
    Then I should be redirected to the account page