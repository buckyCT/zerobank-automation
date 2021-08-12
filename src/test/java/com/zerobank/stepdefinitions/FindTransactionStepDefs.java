package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FindTransactionStepDefs {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("the user accesses the Find Transactions tab")
    public void theUserAccessesTheFindTransactionsTab() {
        accountActivityPage.findTransactionTab.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void theUserEntersDateRangeFromTo(String from, String to) {
        BrowserUtils.waitFor(1);
        accountActivityPage.dateFrom.clear();
        accountActivityPage.dateTo.clear();
        accountActivityPage.dateFrom.sendKeys(from);
        accountActivityPage.dateTo.sendKeys(to);
    }

    @And("clicks search")
    public void clicksSearch() {
        accountActivityPage.findButton.click();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void resultsTableShouldOnlyShowTransactionsDatesBetweenTo(String from, String to) throws ParseException {
        BrowserUtils.waitFor(2);

        Date dateFrom = new SimpleDateFormat("yyyy-MM-dd").parse(from);
        Date dateTo = new SimpleDateFormat("yyyy-MM-dd").parse(to);

        AccountActivityPage accountActivityPage = new AccountActivityPage();

        List<Date> actualDateList = new ArrayList<>();

        for(WebElement w : accountActivityPage.filteredTransactionDates){
            actualDateList.add( new SimpleDateFormat("yyyy-MM-dd").parse(w.getText()) );
        }

        for (int i=0; i<actualDateList.size(); i++){
            Assert.assertTrue( (actualDateList.get(i).after(dateFrom) || actualDateList.get(i).equals(dateFrom))
                                    && (actualDateList.get(i).before(dateTo) || actualDateList.get(i).equals(dateTo))
                             );
        }
    }

    @And("the results should be sorted by most recent date")
    public void theResultsShouldBeSortedByMostRecentDate() throws ParseException {
        AccountActivityPage accountActivityPage = new AccountActivityPage();

        List<Date> actualDateList = new ArrayList<>();

        for(WebElement w : accountActivityPage.filteredTransactionDates){
            actualDateList.add( new SimpleDateFormat("yyyy-MM-dd").parse(w.getText()) );
        }

        for (int i=0; i<actualDateList.size()-1; i++){
            Assert.assertTrue( (actualDateList.get(i).after(actualDateList.get(i+1)) || actualDateList.get(i).equals(actualDateList.get(i+1))) );
        }
    }

    @And("the results table should only not contain transactions dated {string}")
    public void theResultsTableShouldOnlyNotContainTransactionsDated(String date) throws ParseException {

        AccountActivityPage accountActivityPage = new AccountActivityPage();

        Date dateNotExpected = new SimpleDateFormat("yyyy-MM-dd").parse(date);

        List<Date> actualDateList = new ArrayList<>();

        for(WebElement w : accountActivityPage.filteredTransactionDates){
            actualDateList.add( new SimpleDateFormat("yyyy-MM-dd").parse(w.getText()) );
        }

        for (Date d : actualDateList){
            Assert.assertNotEquals(d, dateNotExpected);
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        BrowserUtils.waitFor(2);
        new AccountActivityPage().descriptionInput.clear();
        new AccountActivityPage().descriptionInput.sendKeys(string);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        BrowserUtils.waitFor(1);
        List<WebElement> filteredTransactionDescriptions = new AccountActivityPage().filteredTransactionDescriptions;
        List<String> actualList = new ArrayList<>();
        for (WebElement w : filteredTransactionDescriptions){
            actualList.add(w.getText());
        }
        for(String s : actualList){
            Assert.assertTrue(s.contains(string));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        BrowserUtils.waitFor(1);
        List<WebElement> filteredTransactionDescriptions = new AccountActivityPage().filteredTransactionDescriptions;
        List<String> actualList = new ArrayList<>();
        for (WebElement w : filteredTransactionDescriptions){
            actualList.add(w.getText());
        }
        for(String s : actualList){
            Assert.assertFalse(s.contains(string));
        }
    }

}
