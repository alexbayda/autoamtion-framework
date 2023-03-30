package com.herokuapp.katalon.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class RandomSelector {

    public static <E> E getRandom(List<E> element) {
        Random random = new Random();
        int randomIndex = random.nextInt(element.size());
        return element.get(randomIndex);
    }

    public static void randomByText(WebElement dropdown, String text) {
        Select random = new Select(dropdown);
        random.selectByVisibleText(text);
    }
}

//faker library
