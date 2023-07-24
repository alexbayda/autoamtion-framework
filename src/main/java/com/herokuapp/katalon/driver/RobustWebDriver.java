package com.herokuapp.katalon.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RobustWebDriver implements WebDriver {

    WebDriver originalWebDriver;

    public RobustWebDriver(WebDriver webDriver) {
        this.originalWebDriver = webDriver;
    }

    @Override
    public void get(String url) {
        originalWebDriver.get(url);
    }


    @Override
    public String getCurrentUrl() {
        return originalWebDriver.getCurrentUrl();
    }
    @Override
    public String getTitle() {
        return originalWebDriver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return originalWebDriver.findElements(by)
                .stream().map(e -> new RobustWebElement(e, by, this))
                .collect(Collectors.toList());
    }

    @Override
    public WebElement findElement(By by) {
        return new RobustWebElement(originalWebDriver.findElement(by), by, this);
    }

    @Override
    public String getPageSource() {
        return null;
    }

    public RobustWebDriver() {
        super();
    }

    @Override
    public void close() {
        originalWebDriver.close();

    }

    @Override
    public void quit() {
        originalWebDriver.close();
    }

    @Override
    public Set<String> getWindowHandles() {
        return originalWebDriver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return originalWebDriver.getWindowHandle();

    }

    @Override
    public TargetLocator switchTo() {
        return originalWebDriver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return originalWebDriver.navigate();
    }

    @Override
    public Options manage() {
        return originalWebDriver.manage();
    }

}
