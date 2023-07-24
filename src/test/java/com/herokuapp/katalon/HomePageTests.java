package com.herokuapp.katalon;

import com.herokuapp.katalon.driver.DriverManager;
import com.herokuapp.katalon.pageobject.GooglePage;
import com.herokuapp.katalon.pageobject.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomePageTests extends BaseTest {

    private HomePage homePage;

    private GooglePage googlePage;

    @BeforeMethod
    public void innit() {
        DriverManager.getDriver();
        googlePage = new GooglePage();
        homePage = new HomePage(DriverManager.getDriver());
    }


    @Test
    public void testHomePage() {
        homePage.openLoginPage();
        assertTrue(homePage.isHomepageElementDisplayed());
    }

    @Test
    public void testTest(){
        WebDriver driver = DriverManager.getDriver();
        driver.get("http://google.com");
        WebElement element = driver.findElement(By.xpath("//*[@name='q']"));
        element.sendKeys("something");
        System.out.println(element);
        driver.navigate().refresh();
        WebElement element2 = driver.findElement(By.xpath("//*[@name='q']"));
        element2.sendKeys("somethingElse");
        System.out.println(element2);
    }
}
