package com.herokuapp.katalon;

import com.herokuapp.katalon.driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {


    WebDriver driver = new ChromeDriver();
//    WebDriver driver = Driver.getDriver("chrome");

    @BeforeEach
    public void fullScreen(){
        driver.manage().window().maximize();

    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}