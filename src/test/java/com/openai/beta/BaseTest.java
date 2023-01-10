package com.openai.beta;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.openapi.beta.driver.WebDriver.getInstance;

public abstract class BaseTest {

    protected final WebDriver driver = getInstance().getDriver();

    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));


    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
