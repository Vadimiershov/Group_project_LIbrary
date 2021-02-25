package com.cybertek.library.step_definitions;
import com.cybertek.library.pages.BooksModule;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class US7_BookSearch_StepDefinition {

    LoginPage loginPage = new LoginPage();
    Actions action = new Actions(Driver.getDriver());
    BooksModule booksModule = new BooksModule();

    @Given("the user has already loged in as a student")
    public void the_user_has_already_loged_in_as_a_student() {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
        loginPage.studentLogin();
    }

    @When("user click on the dropdown of book Categories")
    public void user_click_on_the_dropdown_of_book_categories() {
        action.moveToElement(booksModule.bookCategoriesDropdown).click().perform();

    }

    @Then("user should be able to see folloing categories")
    public void user_should_be_able_to_see_folloing_categories(List<String> expectedCategoriesOfBooks) {
        Select selectCategory = new Select(booksModule.bookCategoriesDropdown);
        List<String> actualCategories = BrowserUtils.getElementsText(selectCategory.getOptions());
        Assert.assertTrue(expectedCategoriesOfBooks.equals(actualCategories));
    }
}



