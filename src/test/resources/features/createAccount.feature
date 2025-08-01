Feature: Account Creation
  Scenario: Create account with valid details
    Given I am on the Create Account page
    When I enter "abcdas" in the First Name field
    And I enter "efghed" in the Last Name field
    And I enter "abc@12357688qq.com" in the Email Address field
    And I enter "uunbsdjfsds1ssasddd2345" in the Password field
    And I click the Create button
    Then I should be redirected to the homepage with the Log out link visible


  Scenario: Submit empty Create Account form
    Given I am on the Create Account page
    When I click the Create button without entering any details
    Then I should see error messages for email and password field


  Scenario: Enter invalid email format during account creation
    Given I am on the Create Account page
    When I enter "Aastha" in the First Name field
    And I enter "Kaushik" in the Last Name field
    And I enter "aastha123" in the Email Address field
    And I enter "Aastha123" in the Password field
    And I click the Create button
    Then I should see a validation error for invalid email format


  Scenario: Create account with existing email
    Given I am on the Create Account page
    When I enter "Aastha" in the First Name field
    And I enter "Kaushik" in the Last Name field
    And I enter "aastha12@abc.com" in the Email Address field
    And I enter "Aastha12345" in the Password field
    And I click the Create button
    Then I should see an error message saying the email already exists