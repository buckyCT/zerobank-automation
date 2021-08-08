package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountActivityStepDefs {

    @When("the user switches to {string} tab")
    public void the_user_switches_to_tab(String tabName) {
        int index=0;
        List<String> elementsText = BrowserUtils.getElementsText(new AccountSummaryPage().tabs);
        for (String s : elementsText) {
            if (s.equals(tabName)){
                index = elementsText.indexOf(s);
            }
        }
        new AccountSummaryPage().tabs.get(index).click();
    }

    @Then("Account dropdown should have {string} selected")
    public void account_dropdown_should_have_selected(String expected) {
        String actual = new AccountActivityPage().accountDropdown().getFirstSelectedOption().getText();
        Assert.assertEquals(expected,actual);
    }

    @Then("Account dropdown should have following options")
    public void account_dropdown_should_have_following_options(List<String> expectedList) {
        List<String> actualList = BrowserUtils.getElementsText(new AccountActivityPage().accountDropdown().getOptions());
        for (String expected : expectedList) {
            Assert.assertTrue(actualList.contains(expected));
        }
    }

    @Then("Transactions table should have column names")
    public void transactions_table_should_have_column_names(List<String> expectedList) {
        BrowserUtils.waitFor(3);
        List<String> actualList = BrowserUtils.getElementsText(new AccountActivityPage().tableHeadColumns);
        Assert.assertEquals(expectedList,actualList);
    }

}
