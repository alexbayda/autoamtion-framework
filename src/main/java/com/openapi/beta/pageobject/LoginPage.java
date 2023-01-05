package com.openapi.beta.pageobject;

import com.openapi.beta.logger.SLF4J;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    static final Duration timeout = Duration.ofSeconds(1);
    By usernameLocator = By.id("email");
    By passwordLocator = By.id("current-password");
    By loginButtonLocator = By.xpath("//*[@id=\"auth-view-page\"]/button[2]");

    private final WebDriver driver;

    SLF4J logging = new SLF4J();

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage typeUsername(String username) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        driver.findElement(usernameLocator).sendKeys(username);
        logging.process("Username filled");
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        logging.process("Password filled");
        return this;
    }

    public HomePage submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        logging.process("Successfully logged in");
        return new HomePage(driver);
    }

//    public LoginPage submitLoginExpectingFailure() {
//        driver.findElement(loginButtonLocator).submit();
//        return new LoginPage(driver);
//    }

//    public HomePage loginAs(String username, String password) {
//        typeUsername(username);
//        typePassword(password);
//        return submitLogin();
//    }

}

//https://comaqa.gitbook.io/selenium-webdriver-lectures/page-object-pattern.-arkhitektura-testovogo-proekta./ispolzovanie-patterna-page-object.