package com.Shikhov.SortingTool.printer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;

public class FilePrinter extends PrinterDecorator {

    PrintStream fileOutputStream;
    PrintStream standardOutputStream = System.out;
    public FilePrinter(Printer printer, File outputFile){
        super(printer);
        try {
            fileOutputStream = new PrintStream(outputFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    @Override
    public void printSortedNumberStats(ArrayList<Long> sortedList) {
        System.setOut(fileOutputStream);
        super.printSortedNumberStats(sortedList);
        System.setOut(standardOutputStream);
    }

    @Override
    public void printSortedWordStats(ArrayList<String> sortedList) {
        System.setOut(fileOutputStream);
        super.printSortedWordStats(sortedList);
        System.setOut(standardOutputStream);
    }

    @Override
    public void printSortedLineStats(ArrayList<String> sortedList) {
        System.setOut(fileOutputStream);
        super.printSortedLineStats(sortedList);
        System.setOut(standardOutputStream);
    }

    @Override
    public void printNumberCounterStats(Map<Long, Integer> map) {
        System.setOut(fileOutputStream);
        super.printNumberCounterStats(map);
        System.setOut(standardOutputStream);
    }

    @Override
    public void printWordCounterStats(Map<String, Integer> map) {
        System.setOut(fileOutputStream);
        super.printWordCounterStats(map);
        System.setOut(standardOutputStream);
    }

    @Override
    public void printLineCounterStats(Map<String, Integer> map) {
        System.setOut(fileOutputStream);
        super.printLineCounterStats(map);
        System.setOut(standardOutputStream);
    }
}