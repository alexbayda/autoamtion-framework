package com.herokuapp.katalon;

import com.herokuapp.katalon.pageobject.SauceLabs;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.herokuapp.katalon.utilities.RandomRadioButtonClicker.getRandom;

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

}
