Feature: Cart functionality
Background:
  	Given user Is on the home page

  Scenario: View empty cart message
    When user clicks on the cart
    Then user should see message "Your cart is empty."

  Scenario: Verify product is added to cart when clicked from homepage
    When user clicks on the Grey Jacket image
    And clicks "Add to cart"
    Then verify product is added to cart

  Scenario: Verify navigation to product page from image click
    When user click the Noir Jacket image
    Then Correct product page is displayed

  Scenario: Verify multiple products can be added
    When I add Grey Jacket and then add Striped Top
    Then Cart contains Two different products

  Scenario: Verify quantity updates when same product is added twice
    When I add Noir Jacket twice
    Then Cart should show quantity = two

  Scenario: Verify cart retains items after navigating to other pages
    When User add Striped Top to cart and navigate away then return
    Then Item should be present in cart
    
   Scenario: Verify cart icon shows item count after adding product
   When User adds Nior Jacket to cart
   And User checks the cart
   Then Item count should update  
    
   Scenario: Verify remove button in cart

    When user adds Grey Jacket to the cart
    And user clicks on the cart icon
    And user removes the product from the cart
    Then the cart should be empty and product count should be zero
    
    
    Scenario: Verify checkout button redirects to homepage
    When user adds a product to the cart
    And user clicks on the CartIcon
    When  user clicks on the Checkout button
    Then user should be redirected to the homepage

    