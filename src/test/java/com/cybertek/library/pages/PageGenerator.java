package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class PageGenerator {


    public PageGenerator(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
}
