Feature: Login Test

  Scenario: Login with invalid credentials
    Given the user logs in with "qwe" and "asd"
    Then the user should see login or password are wrong error

  Scenario: Login with valid credentials
    Given the user is logged in
    Then the user should be on Account Summary page