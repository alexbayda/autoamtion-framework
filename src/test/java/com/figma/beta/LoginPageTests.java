package com.figma.beta;

import com.figma.beta.pageobject.LoginPage;
import com.figma.beta.testdatalayer.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTests extends BaseTest {


    private final LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    TestData testData = new TestData();


    @BeforeEach
    void setUp() {
        loginPage.openLoginPage();
        driver.manage().deleteAllCookies();
    }


    @Test
    public void testSuccessfulLogin() {
        loginPage.openLoginPage();
        assertTrue(loginPage.isLogInButtonDisplayed());
        loginPage.waitToLoad(loginPage.usernameLocator);
        loginPage.enterUsername(testData.login);
        loginPage.enterPassword(testData.password);
        loginPage.clickLoginButton();
        loginPage.waitToLoad(loginPage.navigationBar);
    }

    @Test
    public void testInvalidEmail() {
        testData.setAnyLogin("test");
        testData.setAnyPassword("test");
        loginPage.openLoginPage();
        assertTrue(loginPage.isLogInButtonDisplayed());
        loginPage.waitToLoad(loginPage.usernameLocator);
        loginPage.enterUsername(testData.getAnyLogin());
        loginPage.enterPassword(testData.getAnyPassword());
        loginPage.clickLoginButton();
        loginPage.waitToLoad(loginPage.emailError);
    }

    @Test
    public void testInvalidPassword() {
        testData.setAnyPassword("invalidPassword");
        loginPage.openLoginPage();
        assertTrue(loginPage.isLogInButtonDisplayed());
        loginPage.waitToLoad(loginPage.usernameLocator);
        loginPage.enterUsername(testData.login);
        loginPage.enterPassword(testData.getAnyPassword());
        loginPage.clickLoginButton();
        loginPage.waitToLoad(loginPage.passwordEmailError);
    }

}
