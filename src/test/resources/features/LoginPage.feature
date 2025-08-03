Feature: Login Functionality

As a user
I want to be able to log in with valid credentials
So that I can access my account and perform action
 
  Scenario: Successful login with valid credentials
   Given I am on the login page
   When I enter a valid email address and valid password
   And I click on the "Sign In" button
   Then I should be redirected to the account page
   
 Scenario: Unsuccessful login with invalid credentials
   Given I am on the login page
   When I enter an invalid email or password
   And I click on the "Sign In" button
   Then I should see an error message indicating invalid credentials
   
 Scenario: Login attempt with empty email and password fields
   Given I am on the login page
   When I leave both email and password fields empty
   And I click on the "Sign In" button
   Then I should see an error message
