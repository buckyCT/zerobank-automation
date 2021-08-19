package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PayBillsPage extends BasePage{

    @FindBy(id = "sp_amount")
    public WebElement amountInput;

    @FindBy(id = "sp_date")
    public WebElement dateInput;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(xpath = "//div[@id='alert_content']/span")
    public WebElement confirmationMessage;

    @FindBy(linkText = "Add New Payee")
    public WebElement addNewPayeeTab;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameInput;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddressInput;

    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccInput;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetailsInput;

    @FindBy(id = "add_new_payee")
    public WebElement addBtn;

    @FindBy(xpath = "//div[@id='alert_content'][contains(text(),'The new payee')]")
    public WebElement successMessage;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement purchaseFCTab;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropdownNeedToBeInSelect;

    public Select currencyDropdown(){
        return new Select(currencyDropdownNeedToBeInSelect);
    }

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCost;

    @FindBy(id = "pc_amount")
    public WebElement amountInputForeignCurrency;

}
