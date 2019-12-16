package com.Shikhov.sorting;

import java.util.*;
import static com.Shikhov.sorting.PrintUtils.*;
import static com.Shikhov.sorting.MapUtils.*;


public class SortingTool {
    public static void main(String[] args) {
        SortingTool tool = new SortingTool();
        tool.processCommandLineArgs(args);
        tool.getStatistics();
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
        if (argsList.contains("-sortingtype")) {
            int index = argsList.indexOf("-sortingtype");
            if (index + 1 < argsList.size() && "bycount".equals(argsList.get(index + 1))){
                sortingType = SortingType.BY_COUNT;
            }
        }
        if (argsList.contains("-datatype")) {
            int index = argsList.indexOf("-datatype");
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

    private void getStatistics() {
        ArrayList<String> stringList = getDataFromStdin();
        switch (dataType){
            case LINE:
                if (sortingType == SortingType.BY_COUNT){
                    HashMap<String, Integer> map = getStringCounter(stringList);
                    LinkedHashMap<String, Integer> sortedMap = sortNumberHashMapByKey2(map);
                    printWordCounterStats(sortedMap);
                } else {
                    Collections.sort(stringList);
                    printSortedLineStats(stringList);
                }
                break;
            case LONG:
                ArrayList<Long> numberList = convertStringListToLongList(stringList);
                if (sortingType == SortingType.BY_COUNT){
                    HashMap<Long, Integer> map = getCounterHashMap(numberList);
                    LinkedHashMap<Long, Integer> sortedMap = sortNumberHashMapByKey2(map);
                    printNumberCounterStats(sortedMap);
                } else {
                    Collections.sort(numberList);
                    printSortedNumberStats(numberList);
                }
                break;
            case WORD:
            default:
                if (sortingType == SortingType.BY_COUNT){
                    HashMap<String, Integer> map = getStringCounter(stringList);
                    LinkedHashMap<String, Integer> sortedMap = sortNumberHashMapByKey2(map);
                    printWordCounterStats(sortedMap);
                } else {
                    Collections.sort(stringList);
                    printSortedWordStats(stringList);
                }
                break;
        }
    }

    //Made it non-static to use current object's `state`.
    // Should it be like that?
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
}



