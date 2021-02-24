package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BasePage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogOut_US2_Step_Definitions extends BasePage {
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
        String expectedTitle="Login - Library";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
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
}
