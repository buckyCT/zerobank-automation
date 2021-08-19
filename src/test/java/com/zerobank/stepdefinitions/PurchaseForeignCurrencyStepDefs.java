package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.util.List;

public class PurchaseForeignCurrencyStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void theUserAccessesThePurchaseForeignCurrencyCashTab() {
        payBillsPage.purchaseFCTab.click();
    }

    @Then("following currencies should be available")
    public void followingCurrenciesShouldBeAvailable(List<String> expectedOptions) {
        BrowserUtils.waitFor(1);

        List<String> actualOptions = BrowserUtils.getElementsText(payBillsPage.currencyDropdown().getOptions());

        for (String expectedOption : expectedOptions) {
            Assert.assertTrue(actualOptions.contains(expectedOption));
        }
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        BrowserUtils.waitFor(1);
        payBillsPage.currencyDropdown().selectByVisibleText("Select One");
        payBillsPage.calculateCost.click();
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        BrowserUtils.waitFor(1);
        payBillsPage.amountInputForeignCurrency.clear();
        payBillsPage.calculateCost.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();

        String alertText = alert.getText();
        String expectedAlertText = "Please, ensure that you have filled all the required fields with valid values.";
//        System.out.println(alertText);
//        System.out.println(expectedAlertText);

        Assert.assertEquals(expectedAlertText,alertText);
        alert.accept();
    }

}
