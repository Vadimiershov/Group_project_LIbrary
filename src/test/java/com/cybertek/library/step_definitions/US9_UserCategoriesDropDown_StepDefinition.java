package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BasePage;
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

public class US9_UserCategoriesDropDown_StepDefinition {

    UsersModule usersModule = new UsersModule();
    Select select;

    @When("User clicks in User Group Dropdown")
    public void user_clicks_on_user_group_dropdown() {
        usersModule.userGroupDropdown();
    }

    @Then("User should see the following options in User Group dropdown")
    public void user_should_see_the_following_options_in_user_group_dropdown(List<String> userGroupOption) {
        select = new Select(usersModule.userGroupDropdown);
        List<WebElement>webelements = select.getOptions();
        List<String>actualOptions = BrowserUtils.getElementsText(webelements);
        Assert.assertEquals(userGroupOption,actualOptions);

    }

    @And("User select {string} option in User Group Dropdown")
    public void userSelectOptionInUserGroupDropdown(String userGroupOption) {
        select = new Select(usersModule.userGroupDropdown);
        select.selectByVisibleText(userGroupOption);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),userGroupOption);
    }

    @Then("User able to see {string}and{string} in Group Column")
    public void userAbleToSeeAndInGroup(String students, String librarians) {
        List<String> actualInColumn = BrowserUtils.getElementsText(usersModule.userGroupInGroupColumn);
        Assert.assertTrue(actualInColumn.contains(students));
        Assert.assertTrue(actualInColumn.contains(librarians));
    }

    @Then("User able to see only {string} in Group Column")
    public void userAbleToSeeOnlyInGroupColumn(String students) {
        List<String>actualInColumn = BrowserUtils.getElementsText(usersModule.userGroupInGroupColumn);
        for (String s: actualInColumn) {
            System.out.println(s);
            BrowserUtils.waitForVisibility(usersModule.firstNameInTheColumn,5);
            Assert.assertEquals(s, students);
        }
    }


    @And("User click on {string} link")
    public void userClickOnLink(String users) {
        usersModule.usersLinkClick();
        String expected = users;
        String actual = usersModule.usersLink.getText();

        Assert.assertEquals(actual,expected);
    }
}
