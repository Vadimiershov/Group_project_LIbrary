package com.cybertek.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BooksModule extends BasePage{

    @FindBy(id = "book_categories")
    public WebElement bookCategoriesDropdown;

    @FindBy(xpath = "//thead//th")
    public List<WebElement> BooksTableColumnNames;

}
