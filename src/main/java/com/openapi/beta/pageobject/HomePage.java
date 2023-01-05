package com.openapi.beta.pageobject;

import com.openapi.beta.logger.SLF4J;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"gatsby-focus-wrapper\"]/div[1]/div[1]/div/a[2]")
    private WebElement loginButtonLocator;

    SLF4J logging = new SLF4J();

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.get("https://www.figma.com");
        logging.process("Homepage has successfully opened");
    }

    public void openLoginPage() {
        loginButtonLocator.click();
        logging.process("login page has successfully opened");
    }


    public boolean isLogoutButtonDisplayed() {
        loginButtonLocator.isDisplayed();
        return true;
    }
}
