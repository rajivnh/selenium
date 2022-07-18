Feature: Feature to test Template functionality

  Background: I am on the Welcome page
    Given I launch the Login page
    When I login using valid "admin@prontoinsurance.com" and "Sp1tf1re"
    Then I should see Welcome page

  @SmokeTest
  Scenario Outline: I login to website to go to Template page
    When I click "MANAGE TEMPLATE" menu on welcome page
    Then I verify "TEMPLATE ID" text displayed on Template page
