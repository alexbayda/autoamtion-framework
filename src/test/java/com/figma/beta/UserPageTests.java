package com.figma.beta;

import com.figma.beta.pageobject.LoginPage;
import com.figma.beta.pageobject.UserPage;
import com.figma.beta.testdatalayer.UserFactory;
import com.figma.beta.testdatalayer.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class UserPageTests extends BaseTest {

    private final UserPage userPage = PageFactory.initElements(driver, UserPage.class);

    LoginPage loginPage = new LoginPage(driver);


    @BeforeEach
    void setUp() throws InterruptedException {
        UserDto user = UserFactory.getValidUser();
        driver.manage().deleteAllCookies();
        loginPage.openLoginPage();
        loginPage.signIn(user);
    }

    @Test
    public void createProject() {
        userPage.clickNewDesignButton();
    }
}