Feature:Login functionality
  As a standard user od SauceDemo
  I want to login

  Scenario: Login successful
    Given I am on the login Page of Sauce demo
    When I enter valid username and password
    Then I should be taken to Inventory Page
