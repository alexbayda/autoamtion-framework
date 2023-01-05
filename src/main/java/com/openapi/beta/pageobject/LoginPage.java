package com.openapi.beta.pageobject;

import com.openapi.beta.logger.Logs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    Logs logs = new Logs();

    static final Duration timeout = Duration.ofSeconds(1);

    @FindBy(id = "email")
    private WebElement usernameLocator;

    @FindBy(id = "current-password")
    private WebElement passwordLocator;

    @FindBy(xpath = "//*[@id=\"auth-view-page\"]/button[2]")
    private WebElement loginScreenLoginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {
        driver.get("https://www.figma.com/login?locale=en");
        logs.process("LoginPage has successfully opened");
    }

    public void enterUsername(String username) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        usernameLocator.sendKeys(username);
        logs.process("Username filled");
    }

    public void enterPassword(String password) {
        passwordLocator.sendKeys(password);
        logs.process("Password filled");
    }

    public void clickLoginButton() {
        loginScreenLoginButton.submit();
        logs.process("Successfully logged in");
    }

    public boolean isLogInButtonDisplayed() {
        loginScreenLoginButton.isDisplayed();
        return true;
    }
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



//https://comaqa.gitbook.io/selenium-webdriver-lectures/page-object-pattern.-arkhitektura-testovogo-proekta./ispolzovanie-patterna-page-object.