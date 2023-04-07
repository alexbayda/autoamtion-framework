package com.herokuapp.katalon.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver driver; //need to getDriver without a parameter - done

    //create 2 methods 1 for setup, another one to get (driver) - done
    // * try to produce stackOverflow and outOfMemory exception ~ * create own linked list

    public static WebDriver getDriver(){
        if (driver == null){
            throw new IllegalStateException("404");
        }
        return driver;
    }

    public static void setup(String browser) {
        switch (browser) {
                case "chrome" -> {
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                }
                case "firefox" -> {
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                    driver = new FirefoxDriver();
                }
                case "edge" -> {
                    System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
                    driver = new EdgeDriver();
                }
                default -> throw new IllegalArgumentException("Invalid browser type" + browser);
            }
        }
    }