Feature: Breadcrumb Navigation to Home Page
  
As a user
I want to be able to navigate back to the Home page from the About Us page using the breadcrumb
So that I can easily return to the homepage

Scenario: Verify breadcrumb navigation to Home page from About Us page
Given I am on the About Us page
When I click on the Home in the breadcrumb
Then I should be redirected to the Home page
And the page title should be Home