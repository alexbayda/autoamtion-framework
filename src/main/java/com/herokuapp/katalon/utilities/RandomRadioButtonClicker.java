package com.herokuapp.katalon.utilities;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class RandomRadioButtonClicker {

    public static void clickRandomRadioButton(List <WebElement> element) {
        if (element.size() > 0) {
            Random random = new Random();
            int randomIndex = random.nextInt(element.size());
            WebElement selectedRadioButton = element.get(randomIndex);
            selectedRadioButton.click();
        } else {
            throw new IllegalArgumentException("List of radio buttons is empty");
        }
    }
}
