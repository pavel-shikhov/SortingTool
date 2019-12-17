package com.Shikhov.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

class PrintUtils {
    static void printSortedNumberStats(ArrayList<Long> sortedList){
        System.out.println("Total numbers: " + sortedList.size() + ".");
        System.out.print("Sorted data: ");
        for (Long number : sortedList) {
            System.out.print(number + " ");
        }
    }

    static void printSortedWordStats(ArrayList<String> sortedList){
        System.out.println("Total words: " + sortedList.size() + ".");
        System.out.print("Sorted data: ");
        for (String string : sortedList) {
            System.out.print(string + " ");
        }
    }

    static void printSortedLineStats(ArrayList<String> sortedList){
        System.out.println("Total lines: " + sortedList.size() + ".");
        System.out.print("Sorted data: ");
        for (String string : sortedList) {
            System.out.println(string);
        }
    }

    static void printNumberCounterStats(Map<Long, Integer> map){
        long sum = 0;
        for (Integer n : map.values()){
            sum += n;
        }
        System.out.println("Total numbers: " + sum + ".");
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s), " + Math.round(100.0 * entry.getValue() / sum) + "%.");
        }
    }

    static void printWordCounterStats(Map<String, Integer> map){
        long sum = 0;
        for (Integer n : map.values()){
            sum += n;
        }
        System.out.println("Total words: " + sum + ".");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s), " + Math.round(100.0 * entry.getValue() / sum) + "%.");
        }
    }

}