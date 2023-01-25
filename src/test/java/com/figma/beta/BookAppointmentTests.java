package com.figma.beta;

import com.figma.beta.pageobject.BookAppointment;
import com.figma.beta.pageobject.HomePage;
import com.figma.beta.pageobject.LoginPage;
import com.figma.beta.testdatalayer.UserFactory;
import com.figma.beta.testdatalayer.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookAppointmentTests extends BaseTest {

    private final BookAppointment bookAppointment = PageFactory.initElements(driver, BookAppointment.class);
    private final HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    private final LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);



    @BeforeEach
    void setUp() {
        driver.manage().deleteAllCookies();
        homePage.openHomePage();
        assertTrue(homePage.isHomepageElementDisplayed(homePage.hamburgerMenuLocator));
    }


    @Test
    public void makeAppointment() {
        bookAppointment.clickBookAppointmentButton();
        UserDto user = UserFactory.getValidUser();
        loginPage.signIn(user);
        assertTrue(loginPage.isElementDisplayed(loginPage.bookAppointmentButton));
        bookAppointment.fillAppointmentForm();
        assertTrue(bookAppointment.isElementDisplayed(bookAppointment.summaryLocator));
    }
}