Feature: Login Feature

  @SmokeTest
  Scenario Outline: I login the website with invalid username and invalid password
    Given I am on the login page
    When I try to login with "<username>" and "<password>"
    Then I verify invalid login message

    Examples: 
      | username            | password |
      | rajivk@beyontec.com | 12345678 |
