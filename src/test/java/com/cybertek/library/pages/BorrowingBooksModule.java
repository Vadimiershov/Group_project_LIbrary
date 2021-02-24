package com.cybertek.library.pages;

import com.cybertek.library.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BorrowingBooksModule extends BasePage{

    @FindBy(tagName = "th")
    public List<WebElement> borrowingBooksTableHeader;

}
