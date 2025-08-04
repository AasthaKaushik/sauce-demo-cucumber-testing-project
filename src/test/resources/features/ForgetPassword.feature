Feature: Forget Password funtionality

As a user
I want to be able to reset my password if I forget it
So that I can regain access to my account

Background:
Given I am on the login Page
When I clicks on the Forgot your password
And I should be redirected to the password reset page

Scenario: Redirection to password reset page from login 
Then I am on the password reset page

Scenario: Verify I am able to submit a valid email on forget Password page
And In email input field, enter a valid registered email address
Then I get back to the login page

Scenario: Verify I am able to submit a invalid email on forget password page
And In email input field, enter a invalid registered email address
Then I will not get back to login page
 