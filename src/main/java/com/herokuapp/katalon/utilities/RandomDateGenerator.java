package com.herokuapp.katalon.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomDateGenerator {


    public static String fillRandomDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Random random = new Random();
        long randomTimestamp = (long) (random.nextDouble() * (System.currentTimeMillis() + 10000000000L));
        Date randomDate = new Date(randomTimestamp);
        return dateFormat.format(randomDate);
    }
}
