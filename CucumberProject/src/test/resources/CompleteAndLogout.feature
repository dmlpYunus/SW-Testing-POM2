Feature: Checkout and logout functionality
  As a standard user of SauceDemo
  I want to make Checkout and logging out

  Scenario: proceed Checkout Page successfully
    Given I am on the Checkout Page
    When I need fill the information blanks and finish shopping
    Then I should log out