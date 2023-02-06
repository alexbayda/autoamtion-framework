package com.herokuapp.katalon;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StreamTest {

    public static void main(String[] args){
        String s1 = "00";
        String s2 = new String();
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }

//    static List<Integer> readFile() throws FileNotFoundException {
//        Scanner scanner = new Scanner(new File("src/main/resources/text.txt"));
//        List<Integer> tall = new ArrayList<Integer>();
//        while (scanner.hasNextInt()) {
//            tall.add(scanner.nextInt());
//        }
//
//        return tall;
//    }
//
//
//    @Test
//    void streamTest() throws FileNotFoundException {
//        List<Integer> ages = readFile();
//        long from = System.currentTimeMillis();
//        int computedAges = ages.parallelStream()
//                .reduce(0, (a, b) -> a + b, Integer::sum);
//        long until = System.currentTimeMillis();
//        System.out.println(until - from);
//        System.out.println(computedAges);
//
//    }


}
