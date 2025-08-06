Feature: Shopify catalog Functionality

  Scenario:  Verify Add to Cart button works from product page
    Given I am on the product detail page for Black Heels
    When I click the Add to Cart button
    Then the product should be added to the cart


  Scenario:  Verify Sold Out product cannot be added to cart
    Given I am on the catalog page
    When I click on a product marked SOLD OUT
    Then there should be SOLDOUT button must be disable