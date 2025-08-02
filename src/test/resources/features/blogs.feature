Feature: Shopify Blog Functionality
 
 
  Scenario:  Verify blog page opens from homepage
    Given User is on the homepage
    When I click on the Blog link in the sidebar
    Then I should  see First Post on blog page
 
  Scenario:  Verify blog content is visible
    Given I am on the Blog page
    When I click the First Post
    Then I should see the blog content

  Scenario: Verify Shopifys ecommerce blog link works
    Given I am on the First Postpage
    When I click the Shopify’s ecommerce blog link
    Then it should open in a new tab
 
  Scenario:  Verify ecommerce template link works
    Given I am on the page
    When I click the ecommerce template link
    Then Shopify’s template page should open in a new tab
 
  Scenario:  Verify ecommerce hosting link works
    Given I am on the firstpage on Homepage
    When I click the ecommerce hosting link
    Then hosting info should open in a new tab
 
  Scenario:  Verify shopping cart software link works
    Given I am on the Firstpostpage
    When I click the shopping cart software link
    Then cart software info should open
 
  Scenario:  Verify “admin area” link is visible
    Given I am viewing the First Post
    Then I should see the text admin area
    Then it should be a clickable hyperlink
 
  Scenario:  Verify external links open in new tab
    Given I am on the BlogFirstpostpage
    When I click an external link
    Then it should open in a new browser tab
 
  
 
  