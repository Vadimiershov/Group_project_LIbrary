package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Borrowing_Page {

    public Borrowing_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //@FindBy(xpath = "(//thead)[2]//th")
    @FindBy(xpath = "//th")
    public List<WebElement> borrowedBooksTableColumnNames;

}
