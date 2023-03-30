package com.herokuapp.katalon;

import com.herokuapp.katalon.pageobject.BookAppointment;
import com.herokuapp.katalon.pageobject.HomePage;
import com.herokuapp.katalon.pageobject.LoginPage;
import com.herokuapp.katalon.testdatalayer.UserFactory;
import com.herokuapp.katalon.testdatalayer.dto.UserDto;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.herokuapp.katalon.utilities.RandomSelector.getRandom;
import static org.testng.Assert.assertTrue;


public class BookAppointmentTests extends BaseTest {

    private final BookAppointment bookAppointment = PageFactory.initElements(driver, BookAppointment.class);
    private final HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    private final LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);


    @BeforeMethod
    void setUp() {
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