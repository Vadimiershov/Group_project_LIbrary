package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landing_Page {


        public Landing_Page(){
            PageFactory.initElements(Driver.getDriver(),this);
        }
        @FindBy(xpath = "//a[@href='#borrowing-books']")
        public WebElement borrowBooksButton;
    }



