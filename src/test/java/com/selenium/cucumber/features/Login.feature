Feature: Login Feature

  @SmokeTest
  Scenario Outline: I login the website with invalid username and invalid password
    Given I am on the login page
    When I enters Credentials to LogIn
      | username                  | password |
      | rajivk@beyontec.com       | 12345678 |
      | admin@prontoinsurance.com | Sp1tf1re |    
    Then I verify invalid login message
