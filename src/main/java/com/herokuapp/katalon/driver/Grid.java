package com.herokuapp.katalon.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Grid {

        WebDriver driver;

        @Test
        void setUp() throws MalformedURLException {
                EdgeOptions options = new EdgeOptions();
                driver = new RemoteWebDriver(new URL("http://192.168.0.193:4444"), options);
                driver.get("https://google.com");
        }
}
