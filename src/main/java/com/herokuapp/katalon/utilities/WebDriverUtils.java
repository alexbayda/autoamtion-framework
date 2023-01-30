package com.herokuapp.katalon.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverUtils {

    public static void waitForElement(WebDriver driver, By locatorOfElementToWait, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorOfElementToWait));
    }

    public static void waitForElement(WebDriver driver, WebElement elementToWait, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(elementToWait));
    }

    //for WebDriverElement
    public static void selectValueFromDropdown(WebElement dropdown, String text) {
        Select drpCountry = new Select(dropdown);
        drpCountry.selectByVisibleText(text);
    }

//    public static void selectValueFromDropdown(By locatorOfElementToWait, String text) {
//        Select drpCountry = new Select(locatorOfElementToWait);
//        drpCountry.selectByVisibleText(text);
//    }
}

