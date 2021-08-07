Feature: Testing Account Summary tab

  Scenario: Account types
    Given the user is logged in
    Then Account summary page should have to following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: Credit Accounts table
    Given the user is logged in
    Then Credit Accounts table must have columns
      | Account     |
      | Credit Card |
      | Balance     |