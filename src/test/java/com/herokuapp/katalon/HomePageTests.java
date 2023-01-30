package com.herokuapp.katalon;

import com.herokuapp.katalon.pageobject.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTests extends BaseTest {

    private final HomePage homePage = PageFactory.initElements(driver, HomePage.class);



    @BeforeEach
    void setUp() {
        driver.manage().deleteAllCookies();
        homePage.openHomePage();
        assertTrue(homePage.isHomepageElementDisplayed(homePage.hamburgerMenuLocator));
    }


    @Test
    public void testHomePage() {
        homePage.openLoginPage();
        assertTrue(homePage.isHomepageElementDisplayed(homePage.loginButtonLocator));
    }
}
