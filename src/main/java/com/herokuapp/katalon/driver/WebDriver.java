package com.herokuapp.katalon.driver;


import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriver {
    private final org.openqa.selenium.WebDriver driver;
    private static WebDriver instanceOfDriver;

    private WebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }


    public static WebDriver getInstance() {
        instanceOfDriver = new WebDriver();
        return instanceOfDriver;
    }

    public org.openqa.selenium.WebDriver getDriver() {
        return driver;
    }
}

