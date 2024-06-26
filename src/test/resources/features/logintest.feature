Feature: Testing of Login functionality

  Background:
    Given I am on Orange Live HRM home page

  @smoke @sanity @regression
  Scenario: verify user should login successfully
    When I enter username on login page as "Admin"
    And I enter password on login page as "admin123"
    And I click on Login button
    Then I should see the message "Dashboard" after successful login

  @sanity @regression
  Scenario: verify that the logo display on Home page
    When I logged in to the application with credentials as username "Admin" and password "admin123"
    Then I should be able to see the logo displayed


  @regression
  Scenario: verify user should log out successfully
    When I logged in to the application with credentials as username "Admin" and password "admin123"
    And I click on user profile logo
    And I mouse hover on Logout and click
    Then I should be able to see the Login Panel text as "Login"

  @regression
  Scenario Outline: verify error message when logged in using invalid credentials
    When I enter username on login page as "<username>"
    And I enter password on login page as "<password>"
    And I click on Login button
    Then I should see error message as "<errorMessage>"
    Examples:
      | username          | password | errorMessage        |
      |                   |          | Required            |
      | test123@gmail.com |          | Required            |
      |                   | test123  | Required            |
      | test123@gmail.com | test123  | Invalid credentials |
