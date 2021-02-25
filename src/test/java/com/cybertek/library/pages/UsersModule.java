package com.cybertek.library.pages;

import com.cybertek.library.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UsersModule extends BasePage{

    @FindBy(xpath = "//select[@name='tbl_users_length']")
    public WebElement showRecordDropdown;

    @FindBy(tagName = "th")
    public List<WebElement> tableHeaders;

    @FindBy(id = "user_status")
    public WebElement statusDropdown;

    @FindBy(xpath = "//table[@id='tbl_users']//td[6]")
    public List<WebElement> statusColumnInTable;

    @FindBy(id = "user_groups")
    public WebElement userGroupDropdown;

    @FindBy(xpath = "//table[@id='tbl_users']//tbody//td[5]")
    public List<WebElement> userGroupInGroupColumn;

    @FindBy(xpath = "//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")
    public WebElement addUserButton;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchButton;

    //webElement for verification added user is in the table
    @FindBy(xpath = "//table[@id='tbl_users']//tr[1]//td[3]")
    public WebElement firstNameInTheColumn;

    @FindBy(xpath = "//a[@class='nav-link']")
    public List<WebElement> listOfModulesLinks;

    //method to click on Show records dropdown
    public void showDropdownRecords(){
        BrowserUtils.waitForClickability(showRecordDropdown,5);
        showRecordDropdown.click();
    }

    //method to click on Status dropdown
    public void statusDropdown(){
        BrowserUtils.waitForClickability(statusDropdown,5);
        statusDropdown.click();
    }

    //method to click on User Group dropdown
    public void userGroupDropdown(){
        BrowserUtils.waitForClickability(userGroupDropdown,5);
        userGroupDropdown.click();
    }

    //method to click on Add User Button
    public void clickAddUserButton(){
        BrowserUtils.waitForClickability(addUserButton,5);
        addUserButton.click();
    }


}
