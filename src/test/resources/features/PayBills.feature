Feature: Pay Bills tab

  Background:
    Given the user is logged in
    When the user switches to "Pay Bills" tab

  Scenario: Pay Bills title
    Then Page title should be "Zero - Pay Bills"

  Scenario: Successful Pay Operation
    And the user enters "5" dollars and "2021-08-01" then clicks pay button
    Then The payment was successfully submitted message should be displayed

  @incomplete
  Scenario: Unsuccessful Pay Operation
    And the user enters "" dollars and "" then clicks pay button
    Then Please fill out this field message! should be displayed