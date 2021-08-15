package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(css = "select#aa_accountId")
    private WebElement accountDropdownNeedToBeInSelect;

    public Select accountDropdown(){
        return new Select(accountDropdownNeedToBeInSelect);
    }

    @FindBy(xpath = "//table/thead//th")
    public List<WebElement> tableHeadColumns;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactionTab;

    @FindBy(id = "aa_fromDate")
    public WebElement dateFrom;

    @FindBy(id = "aa_toDate")
    public WebElement dateTo;

    @FindBy(xpath = "//button[text()='Find']")
    public WebElement findButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[1]")
    public List<WebElement> filteredTransactionDates;

    @FindBy(id = "aa_description")
    public WebElement descriptionInput;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[2]")
    public List<WebElement> filteredTransactionDescriptions;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[3]")
    public List<WebElement> filteredTransactionDeposits;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[4]")
    public List<WebElement> filteredTransactionWithdrawal;

    @FindBy(id = "aa_type")
    private WebElement typeDropdownNeedToBeInSelect;

    public Select typeDropdown(){
        return new Select(typeDropdownNeedToBeInSelect);
    }

}
