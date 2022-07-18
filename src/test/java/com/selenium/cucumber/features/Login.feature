Feature: Feature to test valid and invalid Login functionality

  Background: I am on the login page
    Given I launch the Login page

  @SmokeTest
  Scenario Outline: I login the website with invalid emailid and password
    When I enters invalid credentials to login
      | emailId             | password |
      | rajivk@beyontec.com | 12345678 |
      | unknown@user.com    | Sp1tf1re |
    Then I verify " Invalid Email Id or Password. Please try again!" text displayed

  @SmokeTest
  Scenario Outline: I login the website with valid username and  password
    When I enter valid "<username>" and "<password>"
    Then I should see Welcome page

    Examples: 
      | username                  | password |
      | admin@prontoinsurance.com | Sp1tf1re |
