Feature: Checking the items in the cart functionality
  As a standard user of SauceDemo
  I want to check if the items are on the cart

  Scenario: Check items of  the cart successfully
    Given I am on the Cart Page
    When I need to find the items on the list
    Then I need to verify if they are on the cart