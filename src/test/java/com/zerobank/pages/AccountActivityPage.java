package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(css = "select#aa_accountId")
    private WebElement accountDropdownNeedToBeInSelect;

    public Select accountDropdown(){
        Select select = new Select(accountDropdownNeedToBeInSelect);
        return select;
    }

    @FindBy(xpath = "//table/thead//th")
    public List<WebElement> tableHeadColumns;

}
