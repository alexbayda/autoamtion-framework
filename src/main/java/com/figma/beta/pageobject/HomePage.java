package com.figma.beta.pageobject;

import com.figma.beta.logger.Logs;
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

    @FindBy(id = "login-button")
    private WebElement loginButtonLocator;

    Logs logs = new Logs();



    public void openHomePage() {
        driver.get("https://www.weebly.com/ca");
        logs.process("Homepage has successfully opened");
    }

    public void openLoginPage() {
        loginButtonLocator.click();
        logs.process("Login page has successfully opened");
    }


    public boolean isLogoutButtonDisplayed() {
        loginButtonLocator.isDisplayed();
        return true;
    }
}
