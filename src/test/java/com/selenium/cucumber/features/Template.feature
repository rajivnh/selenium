Feature: Welcome Feature

  @SmokeTest
  Scenario Outline: I login the website with valid username and invalid password
    Given I am on the login page
    When I try to login with "<username>" and "<password>"
    Then I verify ADD DOCUMENT menu is selected
    When I click on Manage Template on the menu item
    Then I verify if Template page is displayed

    Examples: 
      | username                  | password |
      | admin@prontoinsurance.com | Sp1tf1re |
