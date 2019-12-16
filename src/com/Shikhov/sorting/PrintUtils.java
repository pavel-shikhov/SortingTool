package com.Shikhov.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

class PrintUtils {
    static void printSortedListStats(ArrayList<Long> sortedList){
        System.out.println("Total numbers: " + sortedList.size() + ".");
        System.out.print("Sorted data: ");
        for (Long number : sortedList) {
            System.out.print(number + " ");
        }
    }

    static void printLongsStats(ArrayList<Long> numberList){
        int frequency = Collections.frequency(numberList, Collections.max(numberList));
        System.out.println("Total numbers: " + numberList.size() + ".");
        System.out.println("The greatest number: " + Collections.max(numberList) + " (" + frequency
                + " time(s), " + 100 * frequency / numberList.size() + "%).");
    }

    static void printNumberCounterStats(Map<Long, Integer> map){
        System.out.println("Total numbers: " + map.size() + ".");
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s), " + 100 * entry.getValue() / map.size() + "%.");
        }
    }

    static void printWordsStats(ArrayList<String> words){
        int frequency = Collections.frequency(words, Collections.max(words));
        String longestString = Collections.max(words, Comparator.comparing(String::length));
        System.out.println("Total words: " + words.size() + ".");
        System.out.println("The longest word: " + longestString + " (" + frequency
                + " time(s), " + 100 * frequency / words.size() + "%).");
    }

    static void printLinesStats(ArrayList<String> lines){
        int frequency = Collections.frequency(lines, Collections.max(lines));
        String longestString = Collections.max(lines, Comparator.comparing(String::length));
        System.out.println("Total lines: " + lines.size() + ".");
        System.out.println("The longest line:");
        System.out.println(longestString);
        System.out.println("(" + frequency + " time(s), " + 100 * frequency / lines.size() + "%).");
    }
}