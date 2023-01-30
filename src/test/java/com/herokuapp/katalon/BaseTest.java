package com.herokuapp.katalon;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

import static com.herokuapp.katalon.driver.WebDriver.getInstance;

public abstract class BaseTest {

    protected static final WebDriver driver = getInstance().getDriver();

    @AfterEach
    void tearDown() {
        driver.close();
    }

//    @AfterAll
//    static void cleanUp() {
//        driver.quit();
//    }
}
