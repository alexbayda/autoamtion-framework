package com.herokuapp.katalon.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverManager {
    private static WebDriver driver;


    //different property files for different envs dev/qa/stage - String env
    //borgia webdriver management


    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("404");
        }
        return driver;
    }


    public static void setup(String browser) throws IOException {
        Properties props = new Properties();
        FileInputStream path = new FileInputStream("src/main/resources/config.properties");
        props.load(path);

        switch (browser) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", props.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
//                System.setProperty("webdriver.gecko.driver", props.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                System.setProperty("webdriver.edge.driver", props.getProperty("webdriver.edge.driver"));
                driver = new EdgeDriver();
            }
            default -> throw new IllegalArgumentException("Invalid browser type" + browser);
        }
        driver.manage().window().maximize();
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}
