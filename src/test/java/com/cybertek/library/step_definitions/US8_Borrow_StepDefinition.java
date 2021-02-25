
package com.cybertek.library.step_definitions;
import com.cybertek.library.pages.Borrowing_Page;
import com.cybertek.library.pages.Landing_Page;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.List;
    public class US8_Borrow_StepDefinition {
        LoginPage loginPage = new LoginPage();
        Landing_Page landing = new Landing_Page();
        Borrowing_Page borrowing_page= new Borrowing_Page();

//        @Given("the user on the homepage")
//        public void the_user_on_the_homepage() {
//            String url = ConfigurationReader.getProperty("URL");
//            Driver.getDriver().get(url);
//            LoginPage loginPage = new LoginPage();
//            loginPage.loginField.sendKeys(ConfigurationReader.getProperty("LoginStudent11"));
//            loginPage.passwordField.sendKeys(ConfigurationReader.getProperty("PassStudent11"));
//            loginPage.loginButton.click();
//        }

        @When("the user click Borrowing Books module")
        public void the_user_click_borrowing_books_module() {
            landing.borrowBooksButton.click();
        }
        @Then("the user should see the following column names under Borrowed Books:")
        public void the_user_should_see_the_following_column_names(List<String> ExpectedResult) {
            List<String> actualResult = BrowserUtils.getElementsText(borrowing_page.borrowedBooksTableColumnNames);
            System.out.println(actualResult);
            System.out.println(ExpectedResult);
            Assert.assertEquals(actualResult,ExpectedResult);
        }
    }



