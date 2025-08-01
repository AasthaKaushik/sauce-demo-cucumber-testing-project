Feature: View Product Details

As a user
I want to view the details of a product
So that I can learn more about it before making a purchase

Scenario: Clicking on a product redirects to its detail page
Given I am on the homepage
When I click on a product like "Grey jacket"
Then I should be redirected to the product detail page