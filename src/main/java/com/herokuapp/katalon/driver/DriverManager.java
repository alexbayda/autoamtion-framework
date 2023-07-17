package com.herokuapp.katalon.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("404");
        }
        return driver.get();
    }


    public static void setup(BrowserType browser) {
        switch (browser) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
            }
            default -> throw new IllegalArgumentException("Invalid browser type" + browser);
        }
        getDriver().manage().window().maximize();
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}


