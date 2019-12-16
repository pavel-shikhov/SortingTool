package com.Shikhov.sorting;

import java.util.*;
import static com.Shikhov.sorting.PrintUtils.*;

import static java.util.Arrays.asList;


public class SortingTool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }


    private enum DataType {
        LONG,
        LINE,
        WORD
    }

    private enum SortingType {
        NATURAL,
        BY_COUNT
    }

    DataType dataType;
    SortingType sortingType;
    public SortingTool() {
        this.dataType = DataType.WORD;
        this.sortingType = SortingType.NATURAL;
    }

    private void processCommandLineArgs(String[] args){
        for (int i = 0; i < args.length; i++) {
            args[i] = args[i].toLowerCase(Locale.ENGLISH);
        }
        List<String> argsList = Arrays.asList(args);
        if (argsList.contains("-sortingType")) {
            int index = argsList.indexOf("-sortingType");
            if (index + 1 < argsList.size() && "bycount".equals(argsList.get(index + 1))){
                sortingType = SortingType.BY_COUNT;
            }
        }
        if (argsList.contains("-dataType")) {
            int index = argsList.indexOf("-dataType");
            if (index + 1 < argsList.size()){
                switch (argsList.get(index + 1).toLowerCase(Locale.ENGLISH)){
                    case "long":
                        dataType = DataType.LONG;
                        break;
                    case "line":
                        dataType = DataType.LINE;
                        break;
                    case "word":
                    default:
                        dataType = DataType.WORD;
                        break;
                }
            }
        }
    }

    private static HashMap<Long, Integer> getNumberCounter(ArrayList<String> stringList){
        ArrayList<Long> longList = convertStringListToLongList(stringList);
        Set<Long> numberSet = new HashSet<>(longList);
        HashMap<Long, Integer> map = new HashMap<>();
        for (Long number : numberSet){
            map.put(number, Collections.frequency(longList, number));
        }
        return map;
    }

    private static HashMap<String, Integer> getStringCounter(ArrayList<String> stringList){
        Set<String> stringSet = new HashSet<>(stringList);
        HashMap<String, Integer> map = new HashMap<>();
        for (String string : stringSet){
            map.put(string, Collections.frequency(stringList, string));
        }
        return map;
    }



    private void processInput(String[] args) {
        ArrayList<String> stringList = getDataFromStdin();

        switch (dataType){
            case LINE:

                break;
            case WORD:

                break;
            case LONG:
                if (sortingType == SortingType.BY_COUNT){
                    HashMap<Long, Integer> map = getNumberCounter(stringList);
                    TreeMap<Long, Integer> sortedMap = new TreeMap<>(map);
                    PrintUtils.printNumberCounterStats(sortedMap);
                }
                break;
        }


        ArrayList<String> stringList;
        if (asList(args).contains("-sortIntegers")) {
            dataType = DataType.SORTING_INTEGERS;
            stringList = getDataFromStdin();
            ArrayList<Long> longList = convertStringListToLongList(stringList);
            Collections.sort(longList);
            printSortedListStats(longList);
        } else if (args.length >= 1 && args.length <= 2 && args[0].equals("-dataType")){
            switch (args[1]){
                case "long":
                    dataType = DataType.PROCESSING_LONGS;
                    stringList = getDataFromStdin();
                    ArrayList<Long> longList = convertStringListToLongList(stringList);
                    printLongsStats(longList);
                    break;
                case "line":
                    dataType = DataType.PROCESSING_LINES;
                    stringList = getDataFromStdin();
                    printLinesStats(stringList);
                    break;
                case "word":
                default:
                    stringList = getDataFromStdin();
                    dataType = DataType.PROCESSING_WORDS;
                    printWordsStats(stringList);
                    break;
            }
        }
    }

    //Made it non-static to use current object's `state`.
    // Any workaround?
    private ArrayList<String> getDataFromStdin(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> stringList = new ArrayList<>();
        switch (dataType){
            case LINE:
                while (scanner.hasNextLine()){
                    stringList.add(scanner.nextLine());
                }
            case WORD:
            case LONG:
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
}



