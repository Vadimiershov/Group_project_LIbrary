package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.UsersModule;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class US11_UserTable_StepDefinition {

    UsersModule usersModule = new UsersModule();

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedColumnNames) {
        List<String> actualColumnNames = BrowserUtils.getElementsText(usersModule.tableHeaders);
        Assert.assertEquals(expectedColumnNames,actualColumnNames);
    }

}
