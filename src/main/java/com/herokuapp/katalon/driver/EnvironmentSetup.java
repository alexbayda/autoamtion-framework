package com.herokuapp.katalon.driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentSetup {

    private final String env = System.getProperty("dev");
    private final Properties props = new Properties();

    public void connectEnv() throws IOException {
        props.load(new FileInputStream(env + ".properties"));
        String dbUrl = props.getProperty("db.url");
        String dbUsername = props.getProperty("db.username");
        String dbPassword = props.getProperty("db.password");
        String serverUrl = props.getProperty("server.url");
    }
}

