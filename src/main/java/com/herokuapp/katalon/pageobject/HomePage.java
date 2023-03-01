package com.herokuapp.katalon.pageobject;

import com.herokuapp.katalon.logger.Logs;
import com.herokuapp.katalon.utilities.WebDriverUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#sidebar-wrapper > ul > li:nth-child(4) > a")
    private WebElement loginHamburgerButtonLocator;

    @FindBy(id = "menu-toggle")
    public WebElement hamburgerMenuLocator;

    @FindBy(id = "btn-login")
    public WebElement loginButtonLocator;

    Logs logs = new Logs();


    public void openHomePage() {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebDriverUtils.waitForElement(driver, hamburgerMenuLocator, 30);
        logs.process("Homepage has successfully opened");
    }

    public void openLoginPage() {
        hamburgerMenuLocator.click();
        loginHamburgerButtonLocator.click();
        logs.process("Login page has successfully opened");
    }

    public boolean isHomepageElementDisplayed(WebElement element) {
        WebDriverUtils.waitForElement(driver, element, 30);
        return true;
    }

    //JavaScript in Selenium to click an Element
    public void JsClickLogin() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginButtonLocator);
    }

}
