package com.herokuapp.katalon.driver;

import lombok.Getter;

@Getter
public enum BrowserType {

    CHROME("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"),
    FIREFOX("webdriver.gecko.driver", "src/main/resources/geckodriver.exe"),
    EDGE("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");

    BrowserType(String browser, String path) {
    }
}

