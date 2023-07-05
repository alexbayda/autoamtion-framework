package com.herokuapp.katalon.pageobject;

import com.herokuapp.katalon.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GooglePage {


    private By searchInput = By.xpath("//*[@name='q']");
    private By searchButton = By.xpath("(//*[@name='btnK'])[2]");
    private final static String URL = "http://google.com";

    public void openGooglePage() {
        DriverManager.getDriver().get(URL);
    }

    public void typeSearchQuery(String query) {
        DriverManager.getDriver().findElement(searchInput).sendKeys(query);
        System.out.println("Type query: " + query + " in search input");
    }

    public void refreshPage() {
        DriverManager.getDriver().navigate().refresh();
        System.out.println("Refreshing Page");
    }

    public void pressSearchButton() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement buttonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].click();", buttonElement);
        System.out.println("Clicking Button");
    }
}

