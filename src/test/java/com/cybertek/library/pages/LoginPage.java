package com.cybertek.library.pages;

import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement loginField;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary btn-block']")
    public WebElement loginButton;


    @FindBy(xpath = "//div[@id='inputEmail-error']")
    public WebElement errorMessageWrongPass;

    @FindBy(xpath = "(//h2)[1]")
    public WebElement numberOfUsersButton;

    @FindBy(xpath = "(//a/span)[5]")
    public WebElement roleOfStudent;

    @FindBy(xpath = "(//span[@class='title'])[1]")
    public WebElement pageTitle;

    @FindBy(xpath = "(//a/span)[7]")
    public WebElement roleOfLibrarian;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public WebElement logOutButtonStudent11;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public WebElement logOutButtonLibr11;


    public void homePageLanding() {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
        String expectedTab = "Login - Library";
        String actualTab = Driver.getDriver().getTitle();
        Assert.assertTrue(expectedTab.equals(actualTab));

    }

    public void loginLibrarian() {
        loginField.sendKeys(ConfigurationReader.getProperty("LoginLibrarian11"));
        passwordField.sendKeys(ConfigurationReader.getProperty("PassLibrarian11"));
        loginButton.click();

        String actualRoleLb = roleOfLibrarian.getText();
        String expectedRole = "Test Librarian 11";
        Assert.assertTrue(actualRoleLb.contains(expectedRole));


    }
    public void studentLogin() {
        loginField.sendKeys(ConfigurationReader.getProperty("LoginStudent11"));
        passwordField.sendKeys(ConfigurationReader.getProperty("PassStudent11"));
        loginButton.click();

        String actualRoleLb = roleOfStudent.getText();
        String expectedRole = "Test Student 11";
        Assert.assertTrue(actualRoleLb.contains(expectedRole));

    }
}