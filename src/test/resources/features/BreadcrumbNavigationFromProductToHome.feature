Feature: Breadcrumb Navigation
  Scenario: Navigate from Grey jacket to Home using breadcrumb
    Given I am on the "Grey jacket" product page
    When I click on the Frontpage link in the breadcrumb
    And I should be redirected to the Frontpage
    When I click on the Home link in the breadcrumb
    Then I should be redirected to the Home page from front page

