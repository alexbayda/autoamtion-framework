package com.herokuapp.katalon;

import com.herokuapp.katalon.driver.Driver;
import com.herokuapp.katalon.utilities.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseTest {

    static WebDriver driver;

    @BeforeMethod
    public void fullScreen() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}