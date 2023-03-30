package com.herokuapp.katalon.pageobject;

import com.herokuapp.katalon.logger.Logs;
import com.herokuapp.katalon.testdatalayer.dto.UserDto;
import com.herokuapp.katalon.utilities.CSVUtilities;
import com.herokuapp.katalon.utilities.JSONUtilities;
import com.herokuapp.katalon.utilities.WebDriverUtils;
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
    private WebElement userNameLocator;
    @FindBy(id = "txt-password")
    private WebElement passwordLocator;

    @FindBy(xpath = "//*[@id=\"weebly-lookup\"]/div[2]/div/button")
    private WebElement nextButton;

    @FindBy(id = "btn-login")
    private WebElement logInButton;

    @FindBy(xpath = "//*[@id=\"login\"]/div/div/div[1]/p[2]")
    public WebElement loginErrorMessage;

    @FindBy(id = "btn-book-appointment")
    private WebElement bookAppointmentButton;


    public void openLoginPage() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        WebDriverUtils.waitForElement(driver, logInButton, 30);
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

    public void clickButton(WebElement button) {
        button.submit();
        logs.process("Successfully clicked");
    }

    public boolean isElementDisplayed(WebElement element) {
        WebDriverUtils.waitForElement(driver, element, 30);
        return true;
    }

    public void signIn(UserDto user) {
        userNameLocator.sendKeys(user.getUsername());
        passwordLocator.sendKeys(user.getPassword());
        logInButton.click();
    }

    public void signInFromCSVFile() {
        CSVUtilities csvUsers = new CSVUtilities();
        for (UserDto user : csvUsers.usersList) {
            userNameLocator.sendKeys(user.getName());
            passwordLocator.sendKeys(user.getPassword());
            logInButton.click();
        }
    }

    public void signInFromJSONFile() {
        JSONUtilities jsonUsers = new JSONUtilities();
        for (UserDto user : jsonUsers.getUsersList()){
            userNameLocator.sendKeys(user.getName());
            passwordLocator.sendKeys(user.getPassword());
            logInButton.click();
        }
    }
    public boolean isBookAppointmentButtonDisplayed(){
        isElementDisplayed(bookAppointmentButton);
        return true;
    }
}
