Feature: proceed to Checkout Page functionality
  As a standard user of SauceDemo
  I want to proceed Checkout Page

  Scenario: proceed Checkout Page successfully
    Given I am on the Cart Page
    When I need to click checkout button
    Then I should be taken to Checkout Page