package com.herokuapp.katalon.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverManager {

    //move temp screenshots to build directory
    //complete properties file
    //fix chrome + edge driver

    // to be able to set env property though cli or xml property file //to be able to create new Properties only when EnvSetup is called



    //check testNG docs to see if they changed passing parameters

    //Process class
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("404");
        }
        return driver;
    }


    public static void setup(BrowserType browser) throws IOException {
        Properties props = new Properties();
        FileInputStream path = new FileInputStream("src/main/resources/config.properties");
        props.load(path);

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


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
