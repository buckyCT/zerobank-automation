package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class PurchaseForeignCurrencyStepDefs {

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void theUserAccessesThePurchaseForeignCurrencyCashTab() {
        new PayBillsPage().purchaseFCTab.click();
    }

    @Then("following currencies should be available")
    public void followingCurrenciesShouldBeAvailable(List<String> expectedOptions) {
        BrowserUtils.waitFor(1);
        PayBillsPage payBillsPage = new PayBillsPage();

        List<String> actualOptions = BrowserUtils.getElementsText(payBillsPage.currencyDropdown().getOptions());

        for (String expectedOption : expectedOptions) {
            Assert.assertTrue(actualOptions.contains(expectedOption));
        }
    }

}
