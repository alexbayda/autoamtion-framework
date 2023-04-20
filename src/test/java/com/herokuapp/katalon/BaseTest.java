package com.herokuapp.katalon;

import com.herokuapp.katalon.driver.DriverManager;
import com.herokuapp.katalon.utilities.TestListener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.IOException;

import static com.herokuapp.katalon.driver.BrowserType.FIREFOX;

@Listeners(TestListener.class)
public class BaseTest {


    @BeforeTest
    public void setup() throws IOException {
        DriverManager.setup(FIREFOX); //set enum
    }



}