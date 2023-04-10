package com.herokuapp.katalon;

import com.herokuapp.katalon.pageobject.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomePageTests extends BaseTest {

    private HomePage homePage;


    @BeforeMethod
    void setUp() {
        homePage.openHomePage();
        assertTrue(homePage.isHomepageElementDisplayed());
    }


    @Test
    public void testHomePage() {
        homePage.openLoginPage();
        assertTrue(homePage.isHomepageElementDisplayed());
    }
}
