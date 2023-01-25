package com.figma.beta;

import com.figma.beta.pageobject.LoginPage;
import com.figma.beta.testdatalayer.UserFactory;
import com.figma.beta.testdatalayer.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class LoginPageTests extends BaseTest {


    private final LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);


    @BeforeEach
    void setUp() {
        loginPage.openLoginPage();
        driver.manage().deleteAllCookies();
    }


    @Test
    public void testSuccessfulLogin() {
        UserDto user = UserFactory.getValidUser();
        loginPage.signIn(user);
    }

    @Test
    public void testInvalidEmail() {
        UserDto user = UserFactory.getRandomEmailUser();
        loginPage.signIn(user);

    }

    @Test
    public void testInvalidPassword() {
        UserDto user = UserFactory.getRandomEmailUser();
        loginPage.signIn(user);
    }

}
