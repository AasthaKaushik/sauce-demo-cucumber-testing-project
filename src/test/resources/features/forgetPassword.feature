Feature: Forget Password funtionality

As a user
I want to be able to reset my password if I forget it
So that I can regain access to my account

Background:
Given I am on the login page
When I clicks on the Forgot your password

Scenario: Redirection to password reset page from login 
Then I should be redirected to the password reset page

Scenario: Verify I am able to submit a valid email on forget Password page
And I should be redirect to the password reset page
And In email input field, enter a valid registered email address
And The page should contain a Submit button
Then I get back to the login page

Scenario: Verify I am able to submit a invalid email on forget password page
And I should be redirected to the password reset page
And In email input field, enter a valid registered email address
And The page should contain a Submit button
Then I will not get back to login page
 