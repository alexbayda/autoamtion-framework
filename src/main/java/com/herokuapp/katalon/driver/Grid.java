package com.herokuapp.katalon.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Grid {

        public static void main(String[] args) throws Exception {
                URL hubUrl = new URL("http://localhost:4444/wd/hub");
                FirefoxOptions options = new FirefoxOptions();
                WebDriver driver = new RemoteWebDriver(hubUrl, options);
                driver.get("https://www.google.com");
        }
}