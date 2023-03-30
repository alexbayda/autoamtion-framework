package com.herokuapp.katalon;

import com.herokuapp.katalon.pageobject.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomePageTests extends BaseTest {

    private final HomePage homePage = PageFactory.initElements(driver, HomePage.class);


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
