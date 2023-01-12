package com.figma.beta;

import com.figma.beta.pageobject.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTests extends BaseTest{

    private final HomePage homePage = PageFactory.initElements(driver, HomePage.class);


    @BeforeEach
    void setUp() {
        homePage.openHomePage();
        driver.manage().deleteAllCookies();
    }


    @Test
    public void testHomePage() {
        assertTrue(homePage.isLogoutButtonDisplayed());
        homePage.openLoginPage();
    }
}
