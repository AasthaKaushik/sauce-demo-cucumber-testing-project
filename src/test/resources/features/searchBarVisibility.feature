Feature: Search Bar Visibility on Home Page

As a shopper
I want to be able to easily find the search bar on the homepage
So that I can search for products quickly

Background:
Given I am on the homepage

Scenario: Verify that search bar is visible on the home page 
Then I should see the search bar
And The search bar should be clickable
	
Scenario: Verify that I can search using a valid product keyword
When I enter a valid product keyword like "jacket" in the search bar  
And I click on the search icon  
Then I should be redirected to the search results page  
And I should see products related to the keyword jacket

Scenario: Verify that I search with random keyword 
When I enter an invalid or random keyword like "xyz" in the search bar  
And I press the Enter key or click on the search icon  
Then I should be redirected to the search results page  
And system should display message like No results found