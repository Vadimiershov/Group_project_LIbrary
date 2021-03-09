package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BasePage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US2_LogOut_Step_Definitions extends BasePage {
LoginPage loginPage = new LoginPage();


    @Given("the user login as a {string}")
    public void the_user_login_as_a(String string) {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
    loginPage.loginField.sendKeys(ConfigurationReader.getProperty("LoginStudent11"));
    loginPage.passwordField.sendKeys(ConfigurationReader.getProperty("PassStudent11"));
    loginPage.loginButton.click();

    }

    @When("the user is on {string} page")
    public void the_user_is_on_page(String string) {
        BrowserUtils.waitForVisibility(loginPage.pageTitle,3);
        String actualPage = loginPage.pageTitle.getText();
        Assert.assertTrue(actualPage.equalsIgnoreCase(actualPage));
    }
    @When("the student clicks the dropdown button")
    public void the_student_clicks_the_dropdown_button() {
            loginPage.roleOfStudent.click();

    }
    @When("the student clicks the logout button")
    public void the_student_clicks_the_logout_button() {
            loginPage.logOutButtonStudent11.click();
    }
    @Then("the user sees the loginPage")
    public void the_user_sees_the_login_page() {
        String expectedTab = "Login - Library";
        String actualTab= Driver.getDriver().getTitle();
        Assert.assertTrue(expectedTab.equals(actualTab));

    }

    @Given("the user librarian logs in as a {string}")
    public void theUserLibrarianLogsInAsA(String arg0) {

        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
        loginPage.loginField.sendKeys(ConfigurationReader.getProperty("LoginLibrarian11"));
        loginPage.passwordField.sendKeys(ConfigurationReader.getProperty("PassLibrarian11"));
        loginPage.loginButton.click();
    }

    @When("the librarian is on dashboard page")
    public void theLibrarianIsOnDashboardPage() {
        String actualPage = loginPage.pageTitle.getText();
        Assert.assertTrue(actualPage.equalsIgnoreCase(actualPage));
    }

    @And("the librarian clicks the dropdown button")
    public void theLibrarianClicksTheDropdownButton() {
        loginPage.roleOfLibrarian.click();

    }

    @And("the librarian clicks the logout button")
    public void theLibrarianClicksTheLogoutButton() {
        loginPage.logOutButtonLibr11.click();
    }

    @Then("the user librarian sees the loginPage")
    public void theUserLibrarianSeesTheLoginPage() {
        String expectedTab = "Login - Library";
        String actualTab= Driver.getDriver().getTitle();
        Assert.assertTrue(expectedTab.equals(actualTab));
    }
}
