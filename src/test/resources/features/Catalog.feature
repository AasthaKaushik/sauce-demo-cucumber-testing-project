Feature: Catalog Page Product Verification

  Scenario: Navigate to catalog page from account page
    Given I am on the homepage link
    When I click on the catalog link
    Then I should be on catalog page
  Scenario: Catalog page should display all expected products
    Given I am on the catalogpage

    Then The following products should be listed on the catalog page:
      | Black heels |
      | Bronze sandals |
      | Brown shades |
      | Grey jacket |
      | Noir jacket |
      | Striped top |
      | White sandals |