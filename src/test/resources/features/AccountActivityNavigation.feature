Feature: Navigating to specific accounts in Accounts Activity

  Scenario Outline: <link> account redirect
    Given the user is logged in
    When the user clicks on "<link>" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account dropdown should have "<link>" selected

    Examples:
      | link        |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |