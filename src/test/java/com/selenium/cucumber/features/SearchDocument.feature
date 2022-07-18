Feature: Search Feature to test Document Search functionality

  Background: I am on the welcome page
    Given I launch the Login page
    When I login using valid "admin@prontoinsurance.com" and "Sp1tf1re"
    Then I should see Welcome page

  @SmokeTest
  Scenario Outline: I login to website to go to Document Search page
    When I click "SEARCH DOCUMENT" menu on welcome page
    Then I verify "DOC TAG" text displayed on Document Search page
