package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PayBillsStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @When("the user enters {string} dollars and {string} then clicks pay button")
    public void the_user_enters_dollars_and(String amount, String date) {
        payBillsPage.amountInput.sendKeys(amount);
        payBillsPage.dateInput.sendKeys(date);
        payBillsPage.payButton.click();
    }

    @Then("The payment was successfully submitted message should be displayed")
    public void the_payment_was_successfully_submitted_message_should_be_displayed() {
        String expected = "The payment was successfully submitted.";
        Assert.assertTrue(payBillsPage.confirmationMessage.isDisplayed());
        Assert.assertEquals(expected,payBillsPage.confirmationMessage.getText());
    }

    @Then("Please fill out this field message! should be displayed")
    public void please_fill_out_this_field_message_should_be_displayed() {
        String validationMessage = payBillsPage.amountInput.getAttribute("validationMessage");
        System.out.println(validationMessage);
    }

}
