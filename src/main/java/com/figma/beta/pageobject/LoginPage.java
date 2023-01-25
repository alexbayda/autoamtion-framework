package com.figma.beta.pageobject;

import com.figma.beta.logger.Logs;
import com.figma.beta.testdatalayer.dto.UserDto;
import com.figma.beta.utilities.WaitToLoad;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    Logs logs = new Logs();

    static final Duration timeout = Duration.ofSeconds(15);

    @FindBy(id = "txt-username")
    public WebElement userNameLocator;
    @FindBy(id = "txt-password")
    private WebElement passwordLocator;

    @FindBy(xpath = "//*[@id=\"login\"]/div/div/div[1]/p[2]")
    public WebElement loginErrorMessage;

    @FindBy(xpath = "//*[@id=\"weebly-lookup\"]/div[2]/div/button")
    public WebElement nextButton;
    @FindBy(id = "btn-login")
    public WebElement logInButton;
    @FindBy(id = "btn-book-appointment")
    public WebElement bookAppointmentButton;




    public void openLoginPage() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        WaitToLoad.waitForElement(driver, logInButton, 30);
        logs.process("LoginPage has successfully opened");
    }

    public void enterUsername(String username) {
        userNameLocator.sendKeys(username);
        logs.process("Username filled");
    }

    public void enterPassword(String password) {
        passwordLocator.sendKeys(password);
        logs.process("Password filled");
    }

    public void clickLoginButton() {
        logInButton.submit();
        logs.process("Successfully clicked");
    }

    public boolean isElementDisplayed(WebElement element) {
        WaitToLoad.waitForElement(driver, element, 30);
        return true;
    }

    public void signIn(UserDto user) {
        userNameLocator.sendKeys(user.getUsername());
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