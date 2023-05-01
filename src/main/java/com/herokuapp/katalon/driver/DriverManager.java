package com.herokuapp.katalon.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class DriverManager {

    //watch about gradle

    //selenoid +linux +docker

    //selenede - create new project and make same flow (E2E sauce labs test) + maven


    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("404");
        }
        return driver;
    }


    public static void setup(BrowserType browser) {
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type" + browser);
        }
        driver.manage().window().maximize();
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
