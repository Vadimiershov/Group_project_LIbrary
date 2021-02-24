package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.pages.User_Page_Librarian;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Books_records_Librarian_US5 {


    LoginPage loginPage = new LoginPage();
    User_Page_Librarian pageLibrarian = new User_Page_Librarian();

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.homePageLanding();
    }

    @And("I login as a librarian")
    public void iLoginAsALibrarian() {
        loginPage.loginLibrarian();

    }

    @When("I click on {string} link")
    public void i_click_on_link(String link) {

        switch (link.toLowerCase()) {
            case "dashboard":
                loginPage.dashboardLink.click();
                break;
            case "users":
                loginPage.usersLink.click();
                break;
            case "books":
                loginPage.booksLink.click();
                break;
        }
    }

    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer expected) {

        BrowserUtils.wait(5);
        Select select = new Select(pageLibrarian.showRecordsDropdown);
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, String.valueOf(expected));
        ;


    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {
        Select select = new Select(pageLibrarian.showRecordsDropdown);

        List<WebElement> webElements = select.getOptions();
        List<String> actualTexts = BrowserUtils.getElementsText(webElements);

        Assert.assertEquals(options, actualTexts);

    }

}

