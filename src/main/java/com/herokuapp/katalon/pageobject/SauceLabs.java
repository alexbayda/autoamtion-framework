package com.herokuapp.katalon.pageobject;

import com.herokuapp.katalon.driver.DriverManager;
import com.herokuapp.katalon.logger.Logs;
import com.herokuapp.katalon.testdatalayer.dto.UserDto;
import com.herokuapp.katalon.utilities.CSVUtilities;
import com.herokuapp.katalon.utilities.JSONUtilities;
import com.herokuapp.katalon.utilities.RandomLoginGenerator;
import com.herokuapp.katalon.utilities.WebDriverUtils;
import lombok.Getter;
import org.example.model.UsersModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.herokuapp.katalon.utilities.RandomSelector.getRandom;
import static com.herokuapp.katalon.utilities.TakeScreenshot.takeScreenshot;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Getter
public class SauceLabs {


    UsersModel usersModel = new UsersModel();

    public SauceLabs() {
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    Logs logs = new Logs();

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement loginBox;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordBox;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement loginButton;

    @FindBy(css = ".btn")
    private List<WebElement> addToCardButtonList;

    @FindBy(css = ".shopping_cart_container")
    private WebElement shoppingCartBadge;

    @FindBy(css = ".inventory_list")
    private WebElement inventoryList;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cart;

    @FindBy(css = "#checkout")
    private WebElement checkoutButton;

    @FindBy(css = "#first-name")
    private WebElement checkOutFirstName;

    @FindBy(css = "#last-name")
    private WebElement checkOutLastName;

    @FindBy(css = "#postal-code")
    private WebElement checkOutPostalCode;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    private WebElement checkOutContinueButton;

    @FindBy(css = "#finish")
    private WebElement finishCheckoutButton;

    @FindBy(css = ".error-button")
    private WebElement errorMessageButton;

    @FindBy(css = "#react-burger-menu-btn")
    private WebElement hamburgerMenu;

    @FindBy(css = "#logout_sidebar_link")
    private WebElement logoutButton;

    public void openHomePage() {
        WebDriverUtils.waitForElement(loginBox, 15);
        assertTrue(passwordBox.isDisplayed());
        logs.process("Home Page successfully opened");
        takeScreenshot("Home Page successfully opened");
    }

    public void signInFromJSONFile() {
        JSONUtilities jsonUsers = new JSONUtilities();
        for (UserDto user : jsonUsers.getUsersList()) {
            loginBox.sendKeys(user.getUsername());
            passwordBox.sendKeys(user.getPassword());
            loginButton.click();
            WebDriverUtils.waitForElement(inventoryList, 15);
        }
    }

    public void loginWithNegativeCredentials() {
        String randomEmail = RandomLoginGenerator.getEmail();
        String randomPassword = RandomLoginGenerator.getPassword();
        loginBox.sendKeys(randomEmail);
        passwordBox.sendKeys(randomPassword);
        loginButton.click();
        WebDriverUtils.waitForElement(errorMessageButton, 5);
    }

    public void buyRandomItem() {
        getRandom(getAddToCardButtonList());
        elementIsDisplayed(shoppingCartBadge);
        cart.click();
        WebDriverUtils.waitForElement(checkoutButton, 15);
        checkoutButton.click();
        WebDriverUtils.waitForElement(checkOutFirstName, 15);
    }

    public void logout(){
        elementIsDisplayed(hamburgerMenu);
        hamburgerMenu.click();
        WebDriverUtils.waitForElement(logoutButton,10);
        logoutButton.click();
        elementIsDisplayed(loginButton);
    }

    public void elementIsDisplayed(WebElement element) {
        assertTrue(element.isDisplayed());
    }

    public void elementIsNotDisplayed(WebElement element) {
        assertFalse(element.isDisplayed());
    }

    public void fillFormFromCsvAndBuy() {
        CSVUtilities utilities = new CSVUtilities();
        for (UserDto user : utilities.usersList) {
            checkOutFirstName.sendKeys(user.getName());
            checkOutLastName.sendKeys(user.getSurname());
            checkOutPostalCode.sendKeys(user.getPostalCode());
        }
        WebDriverUtils.waitForElement(checkOutContinueButton, 15);
        checkOutContinueButton.click();
        WebDriverUtils.waitForElement(finishCheckoutButton, 15);
        finishCheckoutButton.click();
    }
}

