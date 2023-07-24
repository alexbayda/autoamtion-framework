package com.herokuapp.katalon;

import com.herokuapp.katalon.driver.DriverManager;
import com.herokuapp.katalon.driver.RobustWebDriver;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

public class StaleElementTest {


    By LOCATOR_REFRESH = By.xpath("//a[.='click here']");
    By LOCATOR_DYNAMIC_CONTENT = By.xpath("(//div[@id='content']//div[@class='large-10 columns'])[1]");

    @Test
    void givenDynamicPage_whenRefreshingAndAccessingSavedElement_thenSERE() {
        ChromeOptions options = new ChromeOptions();
        WebDriver chromeDriver = new ChromeDriver(options);

        RobustWebDriver driver = new RobustWebDriver(chromeDriver);

        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_content?with_content=static");
        final WebElement element = driver.findElement(LOCATOR_DYNAMIC_CONTENT);

        driver.findElement(LOCATOR_REFRESH).click();
        assertTrue(element.isDisplayed());
        assertThrows(StaleElementReferenceException.class, element::getText);
    }


    @Test
    void givenDynamicPage_whenRefreshingAndAccessingSavedElement_thenHandleSERE() {
        ChromeOptions options = new ChromeOptions();
        WebDriver chromeDriver = new ChromeDriver(options);
        RobustWebDriver driver = new RobustWebDriver(chromeDriver);

        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_content?with_content=static");
        final WebElement element = driver.findElement(LOCATOR_DYNAMIC_CONTENT);

        if (!retryingFindClick(LOCATOR_REFRESH)) {
            Assertions.fail("Element is still stale after 5 attempts");
        }
        assertThrows(() -> retryingFindGetText(LOCATOR_DYNAMIC_CONTENT));
    }

    private void retryingFindGetText(By locatorDynamicContent) {
        try {
            DriverManager.getDriver().findElement(locatorDynamicContent).getText();
        } catch (StaleElementReferenceException ex) {
            System.out.println("Element is stale: " + ex.getMessage());
        }
    }

    public boolean retryingFindClick(By locator) {
        var driver = DriverManager.getDriver();
        boolean result = false;
        int attempts = 0;
        while (attempts < 5) {
            try {
                driver.findElement(locator).click();
                result = true;
                break;
            } catch (StaleElementReferenceException ex) {
                System.out.println(ex.getMessage());
            }
            attempts++;
        }
        return result;
    }
}
