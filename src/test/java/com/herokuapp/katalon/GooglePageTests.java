package com.herokuapp.katalon;

import com.herokuapp.katalon.driver.BrowserType;
import com.herokuapp.katalon.driver.DriverManager;
import com.herokuapp.katalon.pageobject.GooglePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.stream.Stream;

public class GooglePageTests {

    private GooglePage googlePage;


    @DataProvider(name = "SearchQueries") //dataProvider -comes form of Array
    public Iterator<Object[]> getSearchQueries() {
        return Stream.of(
                new Object[]{"cats"},
                new Object[]{"dogs"},
                new Object[]{"ducks"}
        ).iterator();
    }

    @BeforeMethod
    public void innit() {
        googlePage = new GooglePage();
        DriverManager.setup(BrowserType.FIREFOX);
    }

    @Test(dataProvider = "SearchQueries")
    public void searchAndClick1(String searchQuery) {
        googlePage.openGooglePage();
        googlePage.typeSearchQuery(searchQuery);
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


    //TestNg***
    //selenium

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