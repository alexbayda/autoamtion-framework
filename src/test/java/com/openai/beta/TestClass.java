package com.openai.beta;

import com.openapi.beta.pageobject.HomePage;
import com.openapi.beta.pageobject.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

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
    public void testSuccessfulLogin() {
        homePage.openHomePage();
        Duration timeout = Duration.ofSeconds(1);
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        assertTrue(homePage.isLogoutButtonDisplayed());
        homePage.openLoginPage();
        assertTrue(loginPage.isLogoutButtonDisplayed());
        loginPage.enterUsername("alex.bayda@yahoo.ca");
        loginPage.enterPassword("1q2w3e4r");
        loginPage.clickLoginButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
