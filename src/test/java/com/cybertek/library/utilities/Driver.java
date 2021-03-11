package com.cybertek.library.utilities;

//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import java.util.concurrent.TimeUnit;
//
//public class Driver {
//
//    private Driver() {
//    }
//
//    private static ThreadLocal<WebDriver>driverPool = new ThreadLocal<>();
//
//    public synchronized static WebDriver getDriver(){
//
//        if (driverPool.get()==null){
//            String browser = ConfigurationReader.getProperty("browser");
//            switch (browser){
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    driverPool.set(new ChromeDriver());
//                    driverPool.get().manage().window().maximize();
//                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                    break;
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driverPool.set(new FirefoxDriver());
//                    driverPool.get().manage().window().maximize();
//                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                    break;
//
//            }
//        }
//        return driverPool.get();
//    }
//    public static void closeDriver(){
//        if(driverPool.get() !=null){
//            driverPool.get().quit();
//            driverPool.remove();
//        }
//    }
//}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static final InheritableThreadLocal<WebDriver> driverThreadLocal = new InheritableThreadLocal<>();

    private Driver() {
    }

    public synchronized static WebDriver getDriver() {

        if (driverThreadLocal.get() == null) {

            String browser = ConfigurationReader.getProperty("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverThreadLocal.set(new ChromeDriver());
                    driverThreadLocal.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driverThreadLocal.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    driverThreadLocal.get().manage().window().setSize(new Dimension(1200, 900));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverThreadLocal.set(new FirefoxDriver());
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driverThreadLocal.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                    driverThreadLocal.get().manage().window().setSize(new Dimension(1200, 900));
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    }
                    WebDriverManager.iedriver().setup();
                    driverThreadLocal.set(new InternetExplorerDriver());
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Edge");
                    }
                    WebDriverManager.edgedriver().setup();
                    driverThreadLocal.set(new EdgeDriver());
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your OS doesn't support Safari");
                    }
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driverThreadLocal.set(new SafariDriver());
                    break;
                case "remote-chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setCapability("platform", Platform.ANY);
                    try {
                        driverThreadLocal.set(new RemoteWebDriver(new URL("http://3.235.179.180:4444/wd/hub"), chromeOptions));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        return driverThreadLocal.get();
    }

    public synchronized static void closeDriver() {

        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}




//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverException;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.safari.SafariDriver;
//
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//public class Driver {
//
//    private static final InheritableThreadLocal<WebDriver> driverThreadLocal = new InheritableThreadLocal<>();
//
//    private Driver() {
//    }
//
//    public synchronized static WebDriver getDriver() {
//
//        if (driverThreadLocal.get() == null) {
//
//            String browser = ConfigurationReader.getProperty("browser");
//            switch (browser) {
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    driverThreadLocal.set(new ChromeDriver());
//                    driverThreadLocal.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                    break;
//                case "chrome-headless":
//                    WebDriverManager.chromedriver().setup();
//                    driverThreadLocal.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
//                    driverThreadLocal.get().manage().window().setSize(new Dimension(1200, 900));
//                    break;
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driverThreadLocal.set(new FirefoxDriver());
//                    break;
//                case "firefox-headless":
//                    WebDriverManager.firefoxdriver().setup();
//                    driverThreadLocal.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
//                    driverThreadLocal.get().manage().window().setSize(new Dimension(1200, 900));
//                    break;
//                case "ie":
//                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
//                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
//                    }
//                    WebDriverManager.iedriver().setup();
//                    driverThreadLocal.set(new InternetExplorerDriver());
//                    break;
//                case "edge":
//                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
//                        throw new WebDriverException("Your OS doesn't support Edge");
//                    }
//                    WebDriverManager.edgedriver().setup();
//                    driverThreadLocal.set(new EdgeDriver());
//                    break;
//                case "safari":
//                    if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
//                        throw new WebDriverException("Your OS doesn't support Safari");
//                    }
//                    WebDriverManager.getInstance(SafariDriver.class).setup();
//                    driverThreadLocal.set(new SafariDriver());
//                    break;
//                case "remote-chrome":
//                    ChromeOptions chromeOptions = new ChromeOptions();
//                    chromeOptions.setCapability("platform", Platform.ANY);
//                    try {
//                        driverThreadLocal.set(new RemoteWebDriver(new URL("http://3.235.179.180:4444/wd/hub"), chromeOptions));
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    break;
//            }
//        }
//        return driverThreadLocal.get();
//    }
//
//    public synchronized static void closeDriver() {
//
//        if (driverThreadLocal.get() != null) {
//            driverThreadLocal.get().quit();
//            driverThreadLocal.remove();
//        }
//    }
//}
