package com.Shikhov.SortingTool.printer;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;

public class PrinterDecorator implements Printer {
    protected Printer printer;

    private PrintStream printStream;
    public PrinterDecorator(Printer printer) {
        this.printer = printer;
//        try {
//            this.printStream = new PrintStream(outputFile);
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found.");
//        }
    }

    @Override
    public void printSortedNumberStats(ArrayList<Long> sortedList) {
        printer.printSortedNumberStats(sortedList);
    }

    @Override
    public void printSortedWordStats(ArrayList<String> sortedList) {
        printer.printSortedWordStats(sortedList);
    }

    @Override
    public void printSortedLineStats(ArrayList<String> sortedList) {
        printer.printSortedLineStats(sortedList);
    }

    @Override
    public void printNumberCounterStats(Map<Long, Integer> map) {
        printer.printNumberCounterStats(map);
    }

    @Override
    public void printWordCounterStats(Map<String, Integer> map) {
        printer.printWordCounterStats(map);
    }

    @Override
    public void printLineCounterStats(Map<String, Integer> map) {
        printer.printLineCounterStats(map);
    }
}