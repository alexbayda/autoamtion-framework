package com.herokuapp.katalon.utilities;

import java.util.List;
import java.util.Random;

public class RandomRadioButtonClicker {

    public static <E> E getRandom(List<E> element) {
        Random random = new Random();
        int randomIndex = random.nextInt(element.size());
        return element.get(randomIndex);
    }
}

//faker library
