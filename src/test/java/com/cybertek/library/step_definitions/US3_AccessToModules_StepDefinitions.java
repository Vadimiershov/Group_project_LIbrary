package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BasePage;
import com.cybertek.library.pages.BorrowingBooksModule;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.pages.UsersModule;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class US3_AccessToModules_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    UsersModule usersModule = new UsersModule();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        loginPage.homePageLanding();
    }


    @Given("the student on the home page")
    public void the_student_on_the_home_page() {
        loginPage.studentLogin();
    }


    @Given("the librarian on the homepage")
    public void the_librarian_on_the_homepage() {
        loginPage.loginLibrarian();
    }


    @Then("the user should see following modules")
    public void the_user_should_see_following_modules(List<String> expectedModules) {

        List<String> actualModules = BrowserUtils.getElementsText(usersModule.listOfModulesLinks);
        System.out.println(actualModules);
        System.out.println(expectedModules);
        Assert.assertTrue(actualModules.equals(expectedModules));
    }


}
