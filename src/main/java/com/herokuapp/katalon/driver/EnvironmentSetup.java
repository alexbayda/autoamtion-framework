package com.herokuapp.katalon.driver;

import org.aeonbits.owner.ConfigFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class EnvironmentSetup {

    public EnvironmentSetup(){
    }
    public static final Properties props = new Properties();

    public static final GeneralConfig generalConfig = ConfigFactory.create(GeneralConfig.class);

    public static void connectEnv(String env) throws IOException {
        props.load(new FileInputStream("src\\main\\resources\\" + env + ".properties"));
        String websiteUrl = props.getProperty("website.url");
        DriverManager.getDriver().get(websiteUrl);
    }
}

