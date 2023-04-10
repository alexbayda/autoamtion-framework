package com.herokuapp.katalon.utilities;

import com.herokuapp.katalon.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverUtils {

    public static void waitForElement(WebDriver driver, WebElement elementToWait, int seconds) { //accept driver not as parameter get from drive class in method
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(elementToWait));
    }

    public static void waitForElementToDisappear(WebElement elementToWait, int seconds){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.invisibilityOf(elementToWait));
    }

    public static void waitForElement(WebElement elementToWait, int seconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(elementToWait));
    }

    //for WebDriverElement


//    public static void selectValueFromDropdown(By locatorOfElementToWait, String text) {
//        Select drpCountry = new Select(locatorOfElementToWait);
//        drpCountry.selectByVisibleText(text);
//    }
}

