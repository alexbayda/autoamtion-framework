package com.herokuapp.katalon;

import com.herokuapp.katalon.driver.BrowserType;
import com.herokuapp.katalon.driver.DriverManager;
import com.herokuapp.katalon.pageobject.GooglePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GooglePageTests {

    private GooglePage googlePage;


    @BeforeMethod
    public void innit() {
        googlePage = new GooglePage();
        DriverManager.setup(BrowserType.FIREFOX);
    }


    @Test
    public void searchAndClick1() {
        googlePage.openGooglePage();
        googlePage.typeSearchQuery("cats");
        System.out.println("Thread id: " + Thread.currentThread().getId());
        googlePage.pressSearchButton();
        DriverManager.getDriver().close();
    }

    @Test
    public void searchAndClick2() {
        GooglePage googlePage = new GooglePage();
        googlePage.openGooglePage();
        googlePage.typeSearchQuery("dogs");
        System.out.println("Thread id: " + Thread.currentThread().getId());
        googlePage.pressSearchButton();
        DriverManager.getDriver().close();
    }

    @Test
    public void searchAndClick3() {
        GooglePage googlePage = new GooglePage();
        googlePage.openGooglePage();
        googlePage.typeSearchQuery("ducks");
        System.out.println("Thread id: " + Thread.currentThread().getId());
        googlePage.pressSearchButton();
        DriverManager.getDriver().close();
    }

    //dataprovider -come is form of Array
    //@Test(threadPoolSize = 3, invocationCount = 3, timeOut = 2000)
    //TestNg***
    //selenium

    // bring up 3 browsers to type "something" + Thread id (make thread safe)
    //jenkins + groovy
    //springBoot for testNg
    //annotations
    //retry analyzer
    //injector annotation
    //junit report to record statistics into xml then into DB (fail pass, time to execute)
//        googlePage.refreshPage();
//googlePage.typeSearchQuery("somethingElse");
    //switch to
    //use findElements with empty list
    //3 types of statements
    //try H2 db
}