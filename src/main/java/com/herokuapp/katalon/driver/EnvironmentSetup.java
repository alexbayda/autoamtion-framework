package com.herokuapp.katalon.driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class EnvironmentSetup {

    public EnvironmentSetup(){
    }
    public static final Properties props = new Properties();


    private static final String env = System.getProperty("env");

    public static void connectEnv() throws IOException {
        props.load(new FileInputStream("src\\main\\resources\\" + env + ".properties"));
        String websiteUrl = props.getProperty("website.url");
        DriverManager.getDriver().get(websiteUrl);
    }
}

