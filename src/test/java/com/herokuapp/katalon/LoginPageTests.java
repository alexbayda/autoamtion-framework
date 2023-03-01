package com.herokuapp.katalon;

import com.herokuapp.katalon.pageobject.LoginPage;
import com.herokuapp.katalon.testdatalayer.UserFactory;
import com.herokuapp.katalon.testdatalayer.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTests extends BaseTest {


    private final LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);


    @BeforeEach
    void setUp() {
        loginPage.openLoginPage();
    }


    @Test
    public void testSuccessfulLogin() {
        UserDto user = UserFactory.getValidUser();
        loginPage.signIn(user);
        assertTrue(loginPage.isBookAppointmentButtonDisplayed());
    }

    @Test
    public void testInvalidEmail() {
        UserDto user = UserFactory.getRandomEmailUser();
        loginPage.signIn(user);
        assertTrue(loginPage.isElementDisplayed(loginPage.loginErrorMessage));
    }

    @Test
    public void testInvalidPassword() {
        UserDto user = UserFactory.getRandomEmailUser();
        loginPage.signIn(user);
        assertTrue(loginPage.isElementDisplayed(loginPage.loginErrorMessage));
    }

}
