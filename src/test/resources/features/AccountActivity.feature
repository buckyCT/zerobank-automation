Feature: Testing Account Activity tab

  Background:
    Given the user is logged in
    When the user switches to "Account Activity" tab

  Scenario: Account Activity title
    Then Page title should be "Zero - Account Activity"

  Scenario: Dropdown default option
    Then Account dropdown should have "Savings" selected

  Scenario: Dropdown all options
    Then Account dropdown should have following options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: Transaction table
    Then Transactions table should have column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |