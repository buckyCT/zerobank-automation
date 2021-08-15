package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class PayeeStepDefs {
    @Given("Add New Payee tab")
    public void addNewPayeeTab() {
        new PayBillsPage().addNewPayeeTab.click();
    }

    @And("creates new payee using following information")
    public void createsNewPayeeUsingFollowingInformation(Map<String,String> map) {
        BrowserUtils.waitFor(1);
        PayBillsPage payBillsPage = new PayBillsPage();

        payBillsPage.payeeNameInput.sendKeys(map.get("Payee Name"));
        payBillsPage.payeeAddressInput.sendKeys(map.get("Payee Address"));
        payBillsPage.payeeAccInput.sendKeys(map.get("Account"));
        payBillsPage.payeeDetailsInput.sendKeys(map.get("Payee details"));

        payBillsPage.addBtn.click();
    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed")
    public void messageTheNewPayeeTheLawOfficesOfHydePriceScharksWasSuccessfullyCreatedShouldBeDisplayed() {
//        BrowserUtils.waitFor(1);
        Assert.assertTrue(new PayBillsPage().successMessage.isDisplayed());
    }
}
