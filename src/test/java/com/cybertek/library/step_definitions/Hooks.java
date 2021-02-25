package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
  //  LoginPage loginPage = new LoginPage();

 //  @Before
 //       public void landingPage (){
  //     loginPage.homePageLanding();
  //     System.out.println("Before Hooks are in action");

 //  }

    @After
    public void tearDownScenario(Scenario scenario) {
        //if my scenario failed
        // go and take screen shot
        if (scenario.isFailed()) {
            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenario.getName());
        }
        //System.out.println("After annotation from Hooks is in action");
        Driver.closeDriver();
    }
}



