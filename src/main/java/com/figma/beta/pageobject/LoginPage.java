package com.figma.beta.pageobject;

import com.figma.beta.logger.Logs;
import com.figma.beta.testdatalayer.dto.UserDto;
import com.figma.beta.utilities.WaitToLoad;
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

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    Logs logs = new Logs();

    static final Duration timeout = Duration.ofSeconds(15);

    @FindBy(id = "weebly-email")
    public WebElement emailLocator;

    @FindBy(id = "weebly-username")
    public WebElement userNameLocator;
    @FindBy(id = "weebly-password")
    private WebElement passwordLocator;

    @FindBy(id = "weebly-lookup")
    private WebElement lookUpSpace;

    @FindBy(xpath = "//*[@id=\"weebly-login\"]/div[2]/div[2]")
    public WebElement loginError;

    @FindBy(xpath = "//*[@id=\"weebly-lookup\"]/div[2]/div/button")
    public WebElement nextButton;

    @FindBy(xpath = "//*[@id=\"weebly-login\"]/div[2]/div/button")
    public WebElement logInButton;



    public void openLoginPage() {
        driver.get("https://www.weebly.com/app/front-door/signin?path=login#/");
        WaitToLoad.waitForElement(driver, lookUpSpace, 30);
        logs.process("LoginPage has successfully opened");
    }

    public void enterUsername(String username) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated((By) emailLocator));
        emailLocator.sendKeys(username);
        logs.process("Username filled");
    }

    public void enterPassword(String password) {
        passwordLocator.sendKeys(password);
        logs.process("Password filled");
    }

    public void clickNextButton() {
        nextButton.submit();
        logs.process("Successfully clicked");
    }
    public void clickLoginButton() {
        logInButton.submit();
        logs.process("Successfully clicked");
    }

    public boolean lookUpSpace() {
        lookUpSpace.isDisplayed();
        return true;
    }

    public void signIn(UserDto user) {
        emailLocator.sendKeys(user.getEmail());
        nextButton.click();
        WaitToLoad.waitForElement(driver, logInButton, 30);
        passwordLocator.sendKeys(user.getPassword());
        logInButton.click();
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