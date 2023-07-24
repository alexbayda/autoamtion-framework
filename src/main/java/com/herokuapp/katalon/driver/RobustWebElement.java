package com.herokuapp.katalon.driver;

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

    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
