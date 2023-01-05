package com.openai.beta;

import com.openapi.beta.pageobject.HomePage;
import com.openapi.beta.pageobject.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestClass extends BaseTest{
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }
    @Test
    public void testHomePage() {
        homePage.openHomePage();
        assertTrue(homePage.isLogoutButtonDisplayed());
        homePage.openLoginPage();
    }

    @Test
    public void testLogin() {
        loginPage.openLoginPage();
        loginPage.enterUsername("user123");
        loginPage.enterPassword("pass123");
        assertTrue(loginPage.isLogoutButtonDisplayed());
        loginPage.clickLoginButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
