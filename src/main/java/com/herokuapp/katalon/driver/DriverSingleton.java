//package com.herokuapp.katalon.driver;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//
//public class DriverSingleton {
//    private static DriverSingleton instance;
//    private WebDriver driver;
//
//    private DriverSingleton(String browser) {
//        switch (browser) {
//            case "chrome" -> {
//                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//                driver = new ChromeDriver();
//            }
//            case "firefox" -> {
//                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
//                driver = new FirefoxDriver();
//            }
//            case "edge" -> {
//                System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
//                driver = new EdgeDriver();
//            }
//            default -> System.out.println("Invalid browser type");
//        }
//    }
//
//    public static DriverSingleton getInstance(String browser) {
//        if (instance == null) {
//            instance = new DriverSingleton(browser);
//        }
//        return instance;
//    }
//
//    public WebDriver getDriver() {
//        return driver;
//    }
//}
//
