Feature: Adding item to cart functionality
  As a standard user of SauceDemo
  I want to add first item on the list to the cart

  Scenario: Add first item to the cart successfully
    Given I am on the Inventory Page of Sauce demo
    When I add first item on the list
    Then Added successfully