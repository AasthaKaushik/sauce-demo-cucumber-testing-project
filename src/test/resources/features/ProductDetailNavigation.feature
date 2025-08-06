Feature: Product Detail Navigation

As a user,
I want to view more details about a product by clicking on it
So that I can make an informed purchase decision

Scenario: Verify that clicking on a product opens the product detail page
Given I am on the homePage
When I click on a product like Grey jacket
Then I should be redirected to the product detail page

  Scenario: Verify clicking on product
    Given I am on the catalogProductPage
    When I click on a product White sandals
    Then I should be redirected to the product detail page of White sandals