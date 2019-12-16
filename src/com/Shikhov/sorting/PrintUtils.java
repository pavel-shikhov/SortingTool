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

    static void printLongsStats(ArrayList<Long> numberList){
        int frequency = Collections.frequency(numberList, Collections.max(numberList));
        System.out.println("Total numbers: " + numberList.size() + ".");
        System.out.println("The greatest number: " + Collections.max(numberList) + " (" + frequency
                + " time(s), " + 100 * frequency / numberList.size() + "%).");
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

    static void printLineCounterStats(Map<String, Integer> map){
        long sum = 0;
        for (Integer n : map.values()){
            sum += n;
        }
        System.out.println("Total lines: " + sum + ".");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s), " + Math.round(100.0 * entry.getValue() / sum) + "%.");
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