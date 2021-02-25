package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BooksModule;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class US6_Tables_Student_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    BooksModule booksModule=new BooksModule();


    @Given("the user on the homepage")
    public void the_user_on_the_homepage() {
        loginPage.homePageLanding();
        loginPage.studentLogin();
    }


    @Then("the user should see the following column names:")
    public void the_user_should_see_the_following_column_names(List<String> expectedDataTable) {
        List<String> actualDataTable = BrowserUtils.getElementsText(booksModule.BooksTableColumnNames);
        System.out.println(expectedDataTable);
        System.out.println(actualDataTable);
        Assert.assertEquals(expectedDataTable,actualDataTable);

    }
}
