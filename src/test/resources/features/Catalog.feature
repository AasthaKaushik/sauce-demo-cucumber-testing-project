Feature: Catalog Page Product Verification
 
Background:
Given I am on the homepage link
 
   
   
Scenario: Navigate to catalog page from account page
   When I click on the catalog link
   Then I should be on catalog page
Scenario: Catalog page should display all expected products
   When I click on the catalog
   And I am on catalog page
   Then The following products should be listed on the catalog page:
     | Black heels |
     | Bronze sandals |
     | Brown shades |
     | Grey jacket |
     | Noir jacket |
     | Striped top |
     | White sandals |