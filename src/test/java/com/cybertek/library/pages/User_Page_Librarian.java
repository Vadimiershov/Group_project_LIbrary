package com.cybertek.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class User_Page_Librarian extends BasePage{

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


}


