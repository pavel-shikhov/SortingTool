package com.Shikhov.sorting;

import java.security.PublicKey;
import java.util.*;

public class SortingTool {
    public static void main(String[] args) {
        String dataType = args[1];
        SortingTool sortingTool = new SortingTool();
        sortingTool.processInput(dataType);
    }

    private void processInput(String dataType) {
        switch (dataType){
            case "long":
                processNumericInput();
                break;
            case "line":
                processLineInput();
                break;
            case "word":
                processWordInput();
                break;
            default:
                processWordInput();
                break;
        }
    }

    private static void processNumericInput(){
        Scanner scanner = new Scanner(System.in);
        long currentNumber = 0;
        long greatestNumber = 0;
        int generalCounter = 0;
        int greatestNumberCounter = 0;
        if (scanner.hasNextInt()) {
            greatestNumber = scanner.nextInt();
            greatestNumberCounter++;
            generalCounter++;
        }
        while (scanner.hasNextInt()){
            currentNumber = scanner.nextInt();
            generalCounter++;
            if (currentNumber > greatestNumber) {
                greatestNumber = currentNumber;
                greatestNumberCounter = 1;
            } else if (currentNumber == greatestNumber) {
                greatestNumberCounter++;
            }
        }
        System.out.println("Total numbers: " + generalCounter + ".");
        System.out.println("The greatest number: " + greatestNumber + " (" + greatestNumberCounter + " time(s), " + 100 * greatestNumberCounter / generalCounter + "%).");
    }

    private static void processLineInput(){
        Scanner scanner = new Scanner(System.in);
        String longestLine = new String();
        String currentLine = new String();
        int generalCounter = 0;
        int longestLineCounter = 0;
        if (scanner.hasNextLine()) {
            longestLine = scanner.nextLine();
            longestLineCounter++;
            generalCounter++;
        }
        while (scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            generalCounter++;
            if (currentLine.length() > longestLine.length()) {
                longestLine = currentLine;
                longestLineCounter = 1;
            } else if (currentLine.equals(longestLine)) {
                longestLineCounter++;
            }
        }
        System.out.println("Total lines: " + generalCounter + ".");
        System.out.println("The longest line:");
        System.out.println(longestLine);
        System.out.println("(" + longestLineCounter + " time(s), " + 100 * longestLineCounter / generalCounter + "%).");
    }

    private static void processWordInput(){
        Scanner scanner = new Scanner(System.in);
        String longestWord = new String();
        String currentWord = new String();
        int generalCounter = 0;
        int longestWordCounter = 0;
        if (scanner.hasNext()) {
            longestWord = scanner.next();
            longestWordCounter++;
            generalCounter++;
        }
        while (scanner.hasNext()){
            currentWord = scanner.next();
            generalCounter++;
            if (currentWord.length() > longestWord.length()) {
                longestWord = currentWord;
                longestWordCounter = 1;
            } else if (currentWord.equals(longestWord)) {
                longestWordCounter++;
            }
        }
        System.out.println("Total words: " + generalCounter + ".");
        System.out.println("The longest word: " + longestWord + " (" + longestWordCounter + " time(s), " + 100 * longestWordCounter / generalCounter + "%).");
    }
}
