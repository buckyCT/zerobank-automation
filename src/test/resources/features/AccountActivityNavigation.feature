
Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user is logged in

  @1
  Scenario: Savings account redirect
    When the user clicks on Savings link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account dropdown should have "Savings" selected

  @2
  Scenario: Brokerage account redirect
    When the user clicks on Brokerage link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account dropdown should have "Brokerage" selected

  @3
  Scenario: Checking account redirect
    When the user clicks on Checking link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account dropdown should have "Checking" selected

  @4
  Scenario: Credit Card account redirect
    When the user clicks on Credit card link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account dropdown should have "Credit Card" selected

  @5
  Scenario: Loan account redirect
    When the user clicks on Loan link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account dropdown should have "Loan" selected