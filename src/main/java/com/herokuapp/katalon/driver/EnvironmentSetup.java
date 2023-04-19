package com.herokuapp.katalon.driver;

import com.beust.jcommander.Parameter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class EnvironmentSetup {

    public EnvironmentSetup(){
    }
    public static final Properties props = new Properties();


    @Parameter
    private static final String env = System.getProperty("environment");

    public static void connectEnv() throws IOException {
        props.load(new FileInputStream("src\\main\\resources\\" + env + ".properties"));
        String websiteUrl = props.getProperty("website.url");
        DriverManager.getDriver().get(websiteUrl);
    }
}

