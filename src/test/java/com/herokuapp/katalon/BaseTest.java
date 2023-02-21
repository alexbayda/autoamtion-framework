package com.herokuapp.katalon;

import com.herokuapp.katalon.driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    WebDriver driver = Driver.getDriver("edge");

    @BeforeEach
    public void fullScreen(){
        driver.manage().window().maximize();

    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}