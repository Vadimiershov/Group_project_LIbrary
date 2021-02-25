package com.cybertek.library.pages;

import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static com.cybertek.library.utilities.Memory.getMemory;

public class User_Page_Librarian extends BasePage {

    @FindBy(xpath = "(//span[@class='title'])[2]")
    public WebElement usersButton;

    @FindBy(xpath = "//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")
    public WebElement addUser;

    @FindBy(xpath = "(//div[@class='modal-body'])[1]")
    public WebElement addUserWindow;

    @FindBy(xpath = "//h3")
    public WebElement userManagement;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement inputUserName;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    public WebElement inputPassword;

    @FindBy(xpath = "(//input[@name='email'])[1]")
    public WebElement inputEmail;

    @FindBy(xpath = "//select[@id='user_group_id']")
    public WebElement userGroup;

    @FindBy(xpath = "//select[@id='status']")
    public WebElement status;

    @FindBy(xpath = "//input[@name='start_date']")
    public WebElement startDate;


    @FindBy(xpath = "//input[@name='end_date']")
    public WebElement endDate;


    @FindBy(xpath = "//textarea[@name='address']")
    public WebElement address;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveChanges;


    @FindBy(xpath = "(//tbody//td)[3]")
    public WebElement verificationByName;

    @FindBy(xpath = "//table[@id='tbl_users']//td[3]")
    public List<WebElement> userTable;

    @FindBy(xpath = "//select[@name='tbl_users_length']")
    public WebElement showRecordsDropdown;

    @FindBy(how = How.CSS, using = "tbody>tr")
    public List<WebElement> table;

    @FindBy(xpath = "//a[@class='nav-link']")
    public List<WebElement> listOfModulesLinks;

    @FindBy(xpath = "//table[@id='tbl_users']//td[4]")
    public List<WebElement> userTableEmails;

    @FindBy(xpath = "//table[@id='tbl_users']//td[3]")
    public List<WebElement> userTableNames;

    @FindBy(xpath = "//button[@type='cancel']")
    public WebElement closeButton;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement firstEditButton;

    @FindBy(xpath = "(//div[@class='modal-body'])[1]")
    public WebElement editWindowVisibility;




    public boolean confirmUser(String key) {
        List<WebElement> table = userTableNames;

        for (WebElement webElement :
                table) {
            String actualValue = webElement.getText();
            if (actualValue.equals(getMemory().retrieveValue(key))) {
                return true;
            }
        }
        return false;
    }



    public String generateNewPassword(){
        Faker passFaker = new Faker();
        String faker= passFaker.finance().iban();

        return faker;
    }
}




