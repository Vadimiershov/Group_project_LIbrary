package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.UsersModule;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US10_StatusDropdown_StepDefinition {

    UsersModule usersModule = new UsersModule();
    Select select;

    @When("User clicks on Status Dropdown")
    public void user_clicks_on_status_dropdown() {
        usersModule.statusDropdown();
    }

    @Then("User should see the following options")
    public void user_should_see_the_following_options(List<String> statusOption) {
        select = new Select(usersModule.statusDropdown);
        List<WebElement> webelements = select.getOptions();
        List<String> actualText = BrowserUtils.getElementsText(webelements);
        Assert.assertEquals(statusOption,actualText);
    }

    @And("User select {string} status")
    public void userSelectStatus(String active) {
        select = new Select(usersModule.statusDropdown);
        select.selectByValue(active);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),active);
    }

    @Then("User should see only {string} users in the table below under Status column")
    public void userShouldSeeOnlyUsersInTheTableBelowUnderStatusColumn(String status) {
        List<String> actual = BrowserUtils.getElementsText(usersModule.statusColumnInTable);
        for (String s : actual) {
            Assert.assertEquals(s,status);

        }
    }

}
