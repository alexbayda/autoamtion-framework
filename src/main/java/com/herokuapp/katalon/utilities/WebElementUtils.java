package com.herokuapp.katalon.utilities;

import org.openqa.selenium.WebElement;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class WebElementUtils {

    private WebElementUtils(){
    }

    static void callMethod(WebElement element, Consumer<WebElement> method) {
        method.accept(element);
    }

    static <U> void callMethod(WebElement element, BiConsumer<WebElement, U> method, U parameter) {
        method.accept(element, parameter);
    }

    static <T> T callMethodWithReturn(WebElement element, Function<WebElement, T> method) {
        return method.apply(element);
    }

    static <T, U> T callMethodWithReturn(WebElement element, BiFunction<WebElement, U, T> method, U parameter) {
        return method.apply(element, parameter);
    }
}
