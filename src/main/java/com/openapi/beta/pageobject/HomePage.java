package com.openapi.beta.pageobject;

import com.openapi.beta.logger.SLF4J;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.openapi.beta.pageobject.LoginPage.timeout;

public class HomePage {

    By loginButtonLocator = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div[1]/div[1]/div/a[2]");
    By loginScreenLoginButtonLocator = By.xpath("//*[@id=\"auth-view-page\"]/button[2]");

    private final WebDriver driver;
    private String url = "https://www.figma.com/";


    SLF4J logging = new SLF4J();


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage openHomePage() {
        driver.get(url);
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));
        Assertions.assertEquals(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div[1]/div[1]/div/a[2]"), loginButtonLocator);
        logging.process("Homepage has successfully opened");
        return this;
    }

    public LoginPage openLoginPage() {
        Assertions.assertEquals(By.xpath("//*[@id=\"auth-view-page\"]/button[2]"), loginScreenLoginButtonLocator);
        driver.findElement(loginButtonLocator).click();
        logging.process("login page has successfully opened");
        return new LoginPage(driver);
    }

}
