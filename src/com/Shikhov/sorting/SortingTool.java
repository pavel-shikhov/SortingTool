package com.Shikhov.sorting;

import java.util.*;

public class SortingTool {
    public static void main(String[] args) {
        SortingTool sortingTool = new SortingTool();
        sortingTool.processInput(args);
    }

    private enum State {
        ON,
        SORTING_INTEGERS,
        PROCESSING_LONGS,
        PROCESSING_LINES,
        PROCESSING_WORDS
    }

    State state;
    public SortingTool() {
        this.state = State.ON;
    }

    private void processInput(String[] args) {
        ArrayList<String> stringList;
        if (Arrays.asList(args).contains("-sortIntegers")) {
            state = State.SORTING_INTEGERS;
            stringList = getStringList();
            ArrayList<Long> longList = convertStringListToLongList(stringList);
            Collections.sort(longList);
            printSortedListStats(longList);
        } else if (args.length >= 1 && args.length <= 2 && args[0].equals("-dataType")){
            switch (args[1]){
                case "long":
                    state = State.PROCESSING_LONGS;
                    stringList = getStringList();
                    ArrayList<Long> longList = convertStringListToLongList(stringList);
                    printLongsStats(longList);
                    break;
                case "line":
                    state = State.PROCESSING_LINES;
                    stringList = getStringList();
                    printLinesStats(stringList);
                    break;
                case "word":
                default:
                    stringList = getStringList();
                    state = State.PROCESSING_WORDS;
                    printWordsStats(stringList);
                    break;
            }
        }
    }

    //Made it non-static to use current object's `state`.
    // Any workaround?
    private ArrayList<String> getStringList(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> stringList = new ArrayList<>();
        switch (state){
            case PROCESSING_LINES:
                while (scanner.hasNextLine()){
                    stringList.add(scanner.nextLine());
                }
            case PROCESSING_WORDS:
            case PROCESSING_LONGS:
            default:
                while (scanner.hasNext()){
                    stringList.add(scanner.next());
                }
        }
        return stringList;
    }

    //TODO: provide for a situation when a stringList item is NOT a string representation of a number
    private static ArrayList<Long> convertStringListToLongList(ArrayList<String> stringList){
        ArrayList<Long> numberList = new ArrayList<>();
        for (String stringNumber : stringList) {
            numberList.add(Long.valueOf(stringNumber));
        }
        return numberList;
    }

    private static void printSortedListStats(ArrayList<Long> sortedList){
        System.out.println("Total numbers: " + sortedList.size() + ".");
        System.out.print("Sorted data: ");
        for (Long number : sortedList) {
            System.out.print(number + " ");
        }
    }

    private static void printLongsStats(ArrayList<Long> numberList){
        int frequency = Collections.frequency(numberList, Collections.max(numberList));
        System.out.println("Total numbers: " + numberList.size() + ".");
        System.out.println("The greatest number: " + Collections.max(numberList) + " (" + frequency
                + " time(s), " + 100 * frequency / numberList.size() + "%).");
    }

    private static void printWordsStats(ArrayList<String> words){
        int frequency = Collections.frequency(words, Collections.max(words));
        String longestString = Collections.max(words, Comparator.comparing(String::length));
        System.out.println("Total words: " + words.size() + ".");
        System.out.println("The longest word: " + longestString + " (" + frequency
                 + " time(s), " + 100 * frequency / words.size() + "%).");
    }

    private static void printLinesStats(ArrayList<String> lines){
        int frequency = Collections.frequency(lines, Collections.max(lines));
        String longestString = Collections.max(lines, Comparator.comparing(String::length));
        System.out.println("Total lines: " + lines.size() + ".");
        System.out.println("The longest line:");
        System.out.println(longestString);
        System.out.println("(" + frequency + " time(s), " + 100 * frequency / lines.size() + "%).");
    }
}
