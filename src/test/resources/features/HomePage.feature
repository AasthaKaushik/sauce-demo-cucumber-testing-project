Feature: Homepage Verification
  Scenario: Verify homepage loads correctly with correct title
    Given I navigate to the homepage url
    Then the home page should load without error
    And the browser tab should display the correct title