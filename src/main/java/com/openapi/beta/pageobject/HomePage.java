package com.openapi.beta.pageobject;

import com.openapi.beta.logger.Logs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"gatsby-focus-wrapper\"]/div[1]/div[1]/div/a[2]")
    private WebElement loginButtonLocator;

    Logs logs = new Logs();

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.get("https://www.figma.com");
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
