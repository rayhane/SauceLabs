Feature: Login Functionality for SauceLabs
  As a user of SauceLabs
  I want to be able to log in with my account
  So that I can acces my account-related features and manage my orders
  Scenario: Successful Login With valid credentials
    Given I have entered a valid email and password
    When I click  on the Login Button
    Then I should be logged in successfully

  Scenario Outline:Unsuccesful login with invalid email and password
    Given I have entered a invalid <name> and <passi>
    When I click  on the Login Button
    Then I should see an error message indicating error_message
    Examples:
      | name                   | passi         |
      | "rayhane@gmail.com "   | "rayhane00ZO" |
      | "moedfkerzl@gmail.com" | "louey10"     |


  Scenario: Logout
      Given I have entered a valid email and password
      And I click  on the Login Button
      When I click on the menu Button
      And I click on 'logout'
      Then I should be logged out successfuly

