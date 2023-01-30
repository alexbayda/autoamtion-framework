package com.herokuapp.katalon.utilities;

import org.apache.commons.lang.RandomStringUtils;

public class RandomGenerator {
    public static String getEmail() {
        return RandomStringUtils.randomAlphabetic(5) +
                "@" +
                RandomStringUtils.randomAlphabetic(3) +
                ".com";
    }
    public static String getPassword() {
        return RandomStringUtils.randomAlphabetic(8);
    }

}
