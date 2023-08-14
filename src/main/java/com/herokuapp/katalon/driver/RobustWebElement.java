package com.herokuapp.katalon.driver;

import com.herokuapp.katalon.utilities.WebElementUtils;
import org.openqa.selenium.*;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class RobustWebElement implements WebElement {

    WebElement originalElement;
    RobustWebDriver driver;
    By by;

    int MAX_RETRIES = 10;
    String SERE = "Element is no longer attached to the DOM";

    RobustWebElement(WebElement element, By by, RobustWebDriver driver) {
        this.originalElement = element;
        this.by = by;
        this.driver = driver;
    }

    void executeMethodWithRetries(Consumer<WebElement> method) {
        int retries = 0;
        while (retries < MAX_RETRIES) {
            try {
                 WebElementUtils.callMethod(originalElement, method);
                return;
            } catch (StaleElementReferenceException ex) {
                refreshElement();
            }
            retries++;
        }
        throw new StaleElementReferenceException(SERE);
    }

    private void refreshElement() {
        this.originalElement = driver.findElement(by);
    }

    <T> T executeMethodWithRetries(Function<WebElement, T> method) {
        return null;
    }

    <U> void executeMethodWithRetriesVoid(BiConsumer<WebElement, U> method, U parameter) {
    }

    <T, U> T executeMethodWithRetries(BiFunction<WebElement, U, T> method, U parameter) {

        return null;
    }

    @Override
    public void click() {
        executeMethodWithRetries(WebElement::click);
    }

    @Override
    public void submit() {

    }

    @Override
    public String getDomProperty(String name) {
        return WebElement.super.getDomProperty(name);
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        System.out.println("sending keys");
        Consumer<WebElement> consumer = webElement -> originalElement.sendKeys(keysToSend);
        executeMethodWithRetries(consumer);
    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return originalElement.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return originalElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return originalElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return originalElement.isEnabled();
    }

    @Override
    public String getText() {
        return originalElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return originalElement.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return originalElement.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return originalElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return originalElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return originalElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return originalElement.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return originalElement.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return originalElement.getScreenshotAs(target);
    }
}
