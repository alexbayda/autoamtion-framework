package com.herokuapp.katalon;

import com.herokuapp.katalon.driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    WebDriver driver = Driver.getDriver("edge");


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}