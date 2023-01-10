package com.openai.beta;

import com.openapi.beta.pageobject.HomePage;
import com.openapi.beta.pageobject.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestClass extends BaseTest{

    private final HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    private final LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);


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

    @Test
    public void testSuccessfulLogin() {
        assertTrue(homePage.isLogoutButtonDisplayed());
        homePage.openLoginPage();
        assertTrue(loginPage.isLogInButtonDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))); //move to pageObject
        loginPage.enterUsername("alex.bayda@yahoo.ca"); //move to a test data layer
        loginPage.enterPassword("1q2w3e4r"); //move to a test data layer
        loginPage.clickLoginButton();
    }

}
