package com.herokuapp.katalon.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult getName) {
        System.out.println("TestFailed");
    }
}
