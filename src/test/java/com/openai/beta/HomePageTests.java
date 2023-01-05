package com.openai.beta;

import com.openapi.beta.driver.WebDriver;
import com.openapi.beta.pageobject.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class HomePageTests extends BaseTest{

    private final HomePage homePage = PageFactory.initElements(driver, HomePage.class);

    @Test
    void homepageTest() {

        homePage.openHomePage().openLoginPage();
    }
}
