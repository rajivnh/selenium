Feature: Feature to test Plugin functionality

  Background: I am on the Welcome page
    Given I launch the Login page
    When I login using valid "admin@prontoinsurance.com" and "Sp1tf1re"
    Then I should see Welcome page

  @SmokeTest
  Scenario Outline: I login to website to go to Plugin page
    When I click "MANAGE PLUGIN" menu on welcome page
    Then I verify "PLUGIN ID" text displayed on Plugin page
