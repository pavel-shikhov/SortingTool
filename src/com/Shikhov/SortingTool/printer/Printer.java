package com.Shikhov.SortingTool.printer;

import java.util.ArrayList;
import java.util.Map;

public interface Printer{
    void printSortedNumberStats(ArrayList<Long> sortedList);
    void printSortedWordStats(ArrayList<String> sortedList);
    void printSortedLineStats(ArrayList<String> sortedList);
    void printNumberCounterStats(Map<Long, Integer> map);
    void printWordCounterStats(Map<String, Integer> map);
    void printLineCounterStats(Map<String, Integer> map);
}