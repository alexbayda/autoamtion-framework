package com.figma.beta;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

import static com.figma.beta.driver.WebDriver.getInstance;

public abstract class BaseTest {

    protected final WebDriver driver = getInstance().getDriver();

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
