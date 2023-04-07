package com.herokuapp.katalon;

import com.herokuapp.katalon.pageobject.SauceLabs;
import com.herokuapp.katalon.utilities.TestListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.herokuapp.katalon.utilities.RandomSelector.getRandom;

@Listeners(TestListener.class)
public class SauceLabsTests extends BaseTest{


    SauceLabs sauceLabs;


    @BeforeMethod
    void setUp() {
        sauceLabs = new SauceLabs(driver);
    }

    @Test
    public void checkOutE2E(){
        sauceLabs.openHomePage();
        sauceLabs.signInFromJSONFile();
        getRandom(sauceLabs.getAddToCardButtonList());
        sauceLabs.buyRandomItem();
        sauceLabs.fillFormFromCsvAndBuy();
    }

    @Test
    public void negativeLogin() {
        sauceLabs.openHomePage();
        sauceLabs.loginWithNegativeCredentials();
        }
    }

