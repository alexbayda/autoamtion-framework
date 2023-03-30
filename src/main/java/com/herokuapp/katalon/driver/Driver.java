package com.herokuapp.katalon.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver { //add file GitIgnore
    private static WebDriver driver; //need to getDriver without a parameter

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            switch (browser) {
                case "chrome" -> {
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                }
                case "firefox" -> {
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                    driver = new FirefoxDriver();
                }
                case "edge" -> {
                    System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
                    driver = new EdgeDriver();
                }
                default -> System.out.println("Invalid browser type");
            }
        }
        return driver;
    }
}
