package com.Shikhov.SortingTool.printer;

import java.util.ArrayList;
import java.util.Map;

public class StandardPrinter implements Printer {
    @Override
    public void printSortedNumberStats(ArrayList<Long> sortedList) {
        System.out.println("Total numbers: " + sortedList.size() + ".");
        System.out.print("Sorted data: ");
        for (Long number : sortedList) {
            System.out.print(number + " ");
        }
    }

    @Override
    public void printSortedWordStats(ArrayList<String> sortedList) {
        System.out.println("Total words: " + sortedList.size() + ".");
        System.out.print("Sorted data: ");
        for (String string : sortedList) {
            System.out.print(string + " ");
        }
    }

    @Override
    public void printSortedLineStats(ArrayList<String> sortedList) {
        System.out.println("Total lines: " + sortedList.size() + ".");
        System.out.print("Sorted data: ");
        for (String string : sortedList) {
            System.out.println(string);
        }
    }

    @Override
    public void printNumberCounterStats(Map<Long, Integer> map) {
        long sum = 0;
        for (Integer n : map.values()){
            sum += n;
        }
        System.out.println("Total numbers: " + sum + ".");
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s), " + Math.round(100.0 * entry.getValue() / sum) + "%.");
        }
    }

    @Override
    public void printWordCounterStats(Map<String, Integer> map) {
        long sum = 0;
        for (Integer n : map.values()){
            sum += n;
        }
        System.out.println("Total words: " + sum + ".");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s), " + Math.round(100.0 * entry.getValue() / sum) + "%.");
        }
    }

    @Override
    public void printLineCounterStats(Map<String, Integer> map) {
        long sum = 0;
        for (Integer n : map.values()){
            sum += n;
        }
        System.out.println("Total lines: " + sum + ".");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s), " + Math.round(100.0 * entry.getValue() / sum) + "%.");
        }
    }
}