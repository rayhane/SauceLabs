Feature: Adding product Functionnality
  As a user of SauceLabs
  I want to Add product and to verify that it has been adding sucessfuly

    Scenario: Adding product successfuly
      Given I have entered a valid username and password
      And I click  on the Loginn Button
      When I click on Add button
      And click to chart
      Then check product

      Scenario: Remove product successfully
        Given I have entered a valid username and password
        And I click  on the Loginn Button
        And I click on Add button
        And click to chart
        When I click on Remove button
        Then check product


  Scenario: checkout successfully
    Given I have entered a valid username and password
    And I click  on the Loginn Button
    And I click on Add button
    And click to chart
    When I click on checkout
    And  enter name
    And enter firstname
    And enter codepostal
    And click continue
    And click finish
    Then checkout successfuly