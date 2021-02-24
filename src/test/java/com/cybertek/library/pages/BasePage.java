package com.cybertek.library.pages;

import com.cybertek.library.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage extends PageGenerator {

    @FindBy(css = "a[href='#dashboard']")
    public WebElement dashboardLink;

    @FindBy(css = "a[href='#users']")
    public WebElement usersLink;

    @FindBy(css = "a[href='#books']")
    public WebElement booksLink;

    @FindBy(xpath = "//a[@id='navbarDropdown']/span")
    public WebElement accountUserName;

    @FindBy(css = "a[href='#borrowing-books']")
    public WebElement borrowingBooksLink;

    public void usersLinkClick() {
        BrowserUtils.waitForClickability(usersLink, 5);
        usersLink.click();
    }

    public void booksLinkClick() {
        BrowserUtils.waitForVisibility(booksLink, 5);
        usersLink.click();
    }

    public void borrowingBooksClick() {
        BrowserUtils.waitForVisibility(borrowingBooksLink, 5);
        borrowingBooksLink.click();
    }
}
