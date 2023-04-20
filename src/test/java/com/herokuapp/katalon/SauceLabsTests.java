package com.herokuapp.katalon;

import com.herokuapp.katalon.driver.DriverManager;
import com.herokuapp.katalon.driver.EnvironmentSetup;
import com.herokuapp.katalon.driver.StartDriver;
import com.herokuapp.katalon.pageobject.SauceLabs;
import com.herokuapp.katalon.utilities.TestListener;
import org.testng.annotations.*;

import java.io.IOException;

import static com.herokuapp.katalon.utilities.RandomSelector.getRandom;

@Listeners(TestListener.class)
public class SauceLabsTests extends BaseTest {

    private SauceLabs sauceLabs;
    private DriverManager driverManager;

    public SauceLabsTests() {
        System.out.println("***SauceLabsTests constructor called...***");
    }


//    @BeforeMethod
//    public void setUp() throws IOException {
//        System.out.println("***Setting up...***");
//        sauceLabs = new SauceLabs();
//        EnvironmentSetup.connectEnv();
//    }

    @BeforeMethod
    @Parameters(value = {"env"})
    public void setUp(String env) throws IOException {
        System.out.println("***Setting up...***");
        sauceLabs = new SauceLabs();
        EnvironmentSetup.connectEnv(env);
    }

    @AfterTest
    public void tearDown() {
        System.out.println("***Tearing down...***");
        DriverManager.getDriver().close();
    }

    @StartDriver
    @Test
    public void checkOutE2E() throws IOException {
        sauceLabs.openHomePage();
        sauceLabs.signInFromJSONFile();
        getRandom(sauceLabs.getAddToCardButtonList());
        sauceLabs.buyRandomItem();
        sauceLabs.fillFormFromCsvAndBuy();
    }

    @Test
    public void negativeLogin() throws IOException {
        sauceLabs.openHomePage();
        sauceLabs.loginWithNegativeCredentials();
    }

    @Test
    public void logoutE2E() throws IOException {
        sauceLabs.openHomePage();
        sauceLabs.signInFromJSONFile();
        sauceLabs.logout();
    }
}

