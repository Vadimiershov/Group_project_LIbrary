package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US1_Login_Step_Definitions {
  LoginPage homePage = new LoginPage();

    @Given("user has landed on a login page")
    public void user_has_landed_on_a_login_page() {
        homePage.homePageLanding();
    }


    @When("given user login as a {string}")
    public void given_user_login_as_a(String role) {

        if (role.equalsIgnoreCase("Test Student 11")) {
            homePage.loginField.sendKeys(ConfigurationReader.getProperty("LoginStudent11"));
            homePage.passwordField.sendKeys(ConfigurationReader.getProperty("PassStudent11"));
            homePage.loginButton.click();
            String actualRoleSt = homePage.roleOfStudent.getText();
            Assert.assertTrue(actualRoleSt.contains(role));


        } else if (role.equalsIgnoreCase("Test Librarian 11")) {
            homePage.loginField.sendKeys(ConfigurationReader.getProperty("LoginLibrarian11"));
            homePage.passwordField.sendKeys(ConfigurationReader.getProperty("PassLibrarian11"));
            homePage.loginButton.click();
            String actualRoleLb = homePage.roleOfLibrarian.getText();
            Assert.assertTrue(actualRoleLb.contains(role));
        }
    }

    @Then("the user on a {string}")
    public void the_user_on_a(String page) {

        String actualPage = homePage.pageTitle.getText();
        Assert.assertTrue(actualPage.contains(page));


    }

    @Given("User login as a librarian")
    public void userLoginAsALibrarian() {
        homePage.homePageLanding();
        homePage.loginLibrarian();
    }
}