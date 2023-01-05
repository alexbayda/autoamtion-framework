package com.openai.beta;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

import static com.openapi.beta.driver.WebDriver.getInstance;

public abstract class BaseTest {

    protected final WebDriver driver = getInstance().getDriver();

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
