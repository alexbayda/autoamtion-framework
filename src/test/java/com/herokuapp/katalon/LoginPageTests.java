package com.herokuapp.katalon;

import com.herokuapp.katalon.pageobject.LoginPage;
import com.herokuapp.katalon.testdatalayer.UserFactory;
import com.herokuapp.katalon.testdatalayer.dto.UserDto;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginPageTests extends BaseTest {


    LoginPage loginPage;

    @Test
    public void testSuccessfulLogin() {
        UserDto user = UserFactory.getValidUser();
        loginPage.signIn(user);
        assertTrue(loginPage.isBookAppointmentButtonDisplayed());
    }

    @Test
    public void testCSVFileLogin() {
        loginPage.signInFromCSVFile();
        assertTrue(loginPage.isElementDisplayed(loginPage.loginErrorMessage));
    }

    @Test
    public void testJSONFileLogin(){
        loginPage.signInFromJSONFile();
        assertTrue(loginPage.isElementDisplayed(loginPage.loginErrorMessage));
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
