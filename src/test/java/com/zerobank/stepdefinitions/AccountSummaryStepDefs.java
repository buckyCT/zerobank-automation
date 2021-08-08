package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountSummaryStepDefs {

    @Then("Account summary page should have to following account types")
    public void account_summary_page_should_have_to_following_account_types(List<String> expectedList) {
        List<String> actualList = BrowserUtils.getElementsText(new AccountSummaryPage().accountTypes);
        Assert.assertEquals(expectedList,actualList);
    }

    @Then("Credit Accounts table must have columns")
    public void credit_Accounts_table_must_have_columns(List<String> expectedList){
        List<String> actualList = BrowserUtils.getElementsText(new AccountSummaryPage().getTableHeadColumns(3));
        Assert.assertEquals(expectedList,actualList);
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

}
