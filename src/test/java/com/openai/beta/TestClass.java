package com.openai.beta;

import com.openapi.beta.pageobject.HomePage;
import com.openapi.beta.pageobject.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestClass extends BaseTest implements TestWatcher {

    private final HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    private final LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);


    @BeforeEach
    void setUp() {
        // code to be executed before each test
    }

    @Test
    public void testHomePage() {
        homePage.openHomePage();
        assertTrue(homePage.isLogoutButtonDisplayed());
        homePage.openLoginPage();
    }

    @Test
    public void testSuccessfulLogin() {
        homePage.openHomePage();
        assertTrue(homePage.isLogoutButtonDisplayed());
        homePage.openLoginPage();
        assertTrue(loginPage.isLogInButtonDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        loginPage.enterUsername("alex.bayda@yahoo.ca");
        loginPage.enterPassword("1q2w3e4r");
        loginPage.clickLoginButton();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
