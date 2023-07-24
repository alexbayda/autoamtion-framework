package com.herokuapp.katalon;

import com.herokuapp.katalon.driver.DriverManager;
import com.herokuapp.katalon.pageobject.BookAppointment;
import com.herokuapp.katalon.pageobject.HomePage;
import com.herokuapp.katalon.pageobject.LoginPage;
import com.herokuapp.katalon.testdatalayer.UserFactory;
import com.herokuapp.katalon.testdatalayer.dto.UserDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.herokuapp.katalon.utilities.RandomSelector.getRandom;
import static org.testng.Assert.assertTrue;


public class BookAppointmentTests extends BaseTest {

    private BookAppointment bookAppointment;
    private HomePage homePage;
    private LoginPage loginPage;


    @BeforeMethod
    void setUp() {
        homePage = new HomePage(DriverManager.getDriver());
        bookAppointment = new BookAppointment(DriverManager.getDriver());
        loginPage = new LoginPage(DriverManager.getDriver());
        homePage.openHomePage();
        assertTrue(homePage.isHomepageElementDisplayed());
    }

    @Test
    public void makeAppointment() {
        bookAppointment.clickBookAppointmentButton();
        UserDto user = UserFactory.getValidUser();
        loginPage.signIn(user);
        assertTrue(loginPage.isBookAppointmentButtonDisplayed());
        bookAppointment.fillFacilityDropDownByText("Hongkong CURA Healthcare Center");
        bookAppointment.checkHospitalReadmission();
        getRandom(bookAppointment.getHealthCareRadioButtonList());
        bookAppointment.fillRandomDate();
        bookAppointment.fillCommentField("This is a comment");
        bookAppointment.submitAppointment();
        assertTrue(bookAppointment.confirmationIsDisplayed());
    }
}