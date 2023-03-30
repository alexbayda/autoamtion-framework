package com.herokuapp.katalon;

import com.herokuapp.katalon.pageobject.LoginPage;
import com.herokuapp.katalon.testdatalayer.UserFactory;
import com.herokuapp.katalon.testdatalayer.dto.UserDto;
import com.herokuapp.katalon.utilities.CSVUtilities;
import com.herokuapp.katalon.utilities.TestListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginPageTests extends BaseTest {


    LoginPage loginPage;

    TestListener testListener;

    @BeforeMethod
    void setUp() {
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
    }


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
