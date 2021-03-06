package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.pages.User_Page_Librarian;
import com.cybertek.library.pages.UsersModule;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.cybertek.library.utilities.Memory.getMemory;

public class US4_AddingUserLibrarian_StepDefinitions extends BrowserUtils {


    LoginPage homePage = new LoginPage();
    User_Page_Librarian librarianPage = new User_Page_Librarian();
    UsersModule usersModule = new UsersModule();

    @Given("user is on the homePage")
    public void user_is_on_the_home_page() {
        homePage.homePageLanding();

    }

    @Given("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        homePage.loginLibrarian();
        /** background has finished here **/
    }


    @When("librarian clicks on Add User button")
    public void librarian_clicks_on_add_user_button() {
        BrowserUtils.waitForClickability(librarianPage.usersButton, 5);
        librarianPage.usersButton.click();
        String expected = "User Management";
        String actual = librarianPage.userManagement.getText();
        Assert.assertTrue(actual.contains(expected));
    }

    @When("librarian should see Add User prompt window")
    public void librarian_should_see_add_user_prompt_window() {
        librarianPage.addUser.click();
        BrowserUtils.waitForVisibility(librarianPage.addUserWindow, 5);
        Assert.assertTrue(librarianPage.addUserWindow.isDisplayed());

    }

    @And("librarian can input new user's name {string}")
    public void librarian_can_input_new_user_s(String key) {
        librarianPage.inputUserName.click();
        librarianPage.inputUserName.sendKeys(getMemory().retrieveValue(key));
    }


    @And("librarian can input new user's password {string}")
    public void librarianCanInputNewUserSPassword(String password) {
        librarianPage.inputPassword.click();
        librarianPage.inputPassword.sendKeys(password);
    }

    @And("I generate new full name and email address and save it as {string} and {string}")
    public void generateEmail(String name, String email) {
        List<String> list = generateUserInfo();
        String fullName = list.get(0);
        String emailValue = list.get(1);
        getMemory().storeValue(email, emailValue);
        getMemory().storeValue(name, fullName);
    }


    @And("librarian can input new user's email {string}")
    public void librarianCanInputNewUserSEmail(String email) {
        librarianPage.inputEmail.click();
        librarianPage.inputEmail.sendKeys(getMemory().retrieveValue(email));

    }

    @And("librarian can input new user's user group{string}")
    public void librarianCanInputNewUserSUserGroup(String group) {

        Actions actions = new Actions(Driver.getDriver());
        actions.click(librarianPage.userGroup);
        Select select = new Select(librarianPage.userGroup);
        select.selectByVisibleText(group);

    }

    @And("librarian can input new user's status {string}")
    public void librarianCanInputNewUserSStatus(String status) {
        Actions actions = new Actions(Driver.getDriver());
        actions.click(librarianPage.status);
        Select select = new Select(librarianPage.status);
        select.selectByVisibleText(status);

    }

    @And("librarian can input new user's start date{string}")
    public void librarianCanInputNewUserSStartDate(String startDate) {
        Actions actions = new Actions(Driver.getDriver());
        actions.click(librarianPage.startDate);
        librarianPage.startDate.clear();
        actions.doubleClick();
        librarianPage.startDate.sendKeys(startDate);
        librarianPage.startDate.sendKeys(Keys.RETURN);

    }

    @And("librarian can input new user's end date {string}")
    public void librarianCanInputNewUserSEndDate(String endsDate) {

        Actions actions = new Actions(Driver.getDriver());
        actions.click(librarianPage.endDate);
        librarianPage.endDate.clear();
        actions.doubleClick();
        librarianPage.endDate.sendKeys(endsDate);
        librarianPage.endDate.sendKeys(Keys.RETURN);


    }

    @And("librarian can input new user's address {string}")
    public void librarianCanInputNewUserSAddress(String address) {
        Actions actions = new Actions(Driver.getDriver());
        actions.click(librarianPage.address);
        librarianPage.address.clear();
        librarianPage.address.sendKeys(address);

    }

    @When("librarian should be able to click on Save Changes")
    public void librarian_should_be_able_to_click_on_save_changes() {
        BrowserUtils.waitForVisibility(librarianPage.saveChanges, 5);
        librarianPage.saveChanges.click();

    }

    @Then("new user {string} is successfully created")
    public void newUserIsSuccessfullyCreated(String key) {

        BrowserUtils.wait(10);
        Assert.assertTrue(librarianPage.confirmUser(key));

    }


    @When("librarian is on the add user window and clicks Close Button")
    public void librarian_is_on_the_add_user_window_and_clicks_close_button() {
        BrowserUtils.waitForClickability(librarianPage.usersButton, 5);
        librarianPage.usersButton.click();
        String expected = "User Management";
        String actual = librarianPage.userManagement.getText();
        Assert.assertTrue(actual.contains(expected));
        BrowserUtils.waitForClickability(librarianPage.addUser, 5);
        librarianPage.addUser.click();


    }

    @Then("librarian should be able close Add User input window")
    public void librarian_should_be_able_close_add_user_input_window() {
        BrowserUtils.waitForClickability(librarianPage.closeButton, 5);
        librarianPage.closeButton.click();
        String expected = "User Management";
        String actual = librarianPage.userManagement.getText();
        Assert.assertTrue(actual.contains(expected));


    }

    @When("librarian clicks Edit User button")
    public void librarian_clicks_edit_user_button() {
        BrowserUtils.waitForClickability(librarianPage.usersButton, 5);
        librarianPage.usersButton.click();
        String expected = "User Management";
        String actual = librarianPage.userManagement.getText();
        Assert.assertTrue(actual.contains(expected));

        BrowserUtils.waitForClickability(librarianPage.firstEditButton, 5);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", librarianPage.firstEditButton);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", librarianPage.firstEditButton);

    }

    @When("librarian is able to see Edit User Information window")
    public void librarian_is_able_to_see_edit_user_information_window() {
        Assert.assertTrue(librarianPage.editWindowVisibility.isEnabled());

    }

    @Then("librarian can edit any user info and save changes")
    public void librarian_can_edit_any_user_info_and_save_changes() {
        BrowserUtils.waitForClickability(librarianPage.inputPassword, 5);
        librarianPage.inputPassword.click();
        BrowserUtils.wait(2);
        librarianPage.inputPassword.clear();
        librarianPage.inputPassword.sendKeys(librarianPage.generateNewPassword());
        BrowserUtils.wait(2);
        librarianPage.inputPassword.sendKeys(Keys.RETURN);
        BrowserUtils.wait(2);
        Actions actions =new Actions(Driver.getDriver());
        actions.click(librarianPage.saveChanges);
        BrowserUtils.wait(2);
        String expected = "User Management";
        String actual = librarianPage.userManagement.getText();
        Assert.assertTrue(actual.contains(expected));


    }

    public List<String> generateUserInfo() {
        List<String> list = new ArrayList<>(2);
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = firstName + " " + lastName;
        String email = firstName + "." + lastName + "@mailnator.com";
        list.add(fullName);
        list.add(email);

        return list;
    }

}


