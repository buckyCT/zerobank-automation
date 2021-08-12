package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.NoSuchElementException;

public class AccountActivityNavigationStepsDef {

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        String expectedUrl = "http://zero.webappsecurity.com/bank/account-activity.html";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void theUserClicksOnLinkOnTheAccountSummaryPage(String link) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        switch (link) {
            case "Savings" -> accountSummaryPage.savings1.click();
            case "Brokerage" -> accountSummaryPage.brokerage.click();
            case "Checking" -> accountSummaryPage.checking.click();
            case "Credit Card" -> accountSummaryPage.creditCard.click();
            case "Loan" -> accountSummaryPage.loan.click();
            default -> throw new NoSuchElementException();
        }
    }
}
