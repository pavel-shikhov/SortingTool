package com.Shikhov.sorting;

import java.util.*;
import static com.Shikhov.sorting.PrintUtils.*;
import static com.Shikhov.sorting.MapUtils.*;


public class SortingTool {
    public static void main(String[] args) {
        SortingTool tool = new SortingTool();
        tool.checkArgs(args);
        tool.getStatistics();
    }

    private enum DataType {
        LONG,
        LINE,
        WORD
    }

    private enum SortingType {
        NATURAL,
        BYCOUNT
    }

    private static String[] getEnumValues(Class<? extends Enum<?>> e){
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }

    DataType dataType;
    SortingType sortingType;
    public SortingTool() {
        this.dataType = DataType.WORD;
        this.sortingType = SortingType.NATURAL;
    }

    private void checkArgs(String[] args) {
        //search for the dataType cli argument
        ArrayList<Integer> indices = new ArrayList<>();
        int parameterIndex = getElementIndex(args, "-dataType");
        if (parameterIndex != -1) {
            indices.add(parameterIndex);
            if (parameterIndex + 1 < args.length) {
                String[] datatypes = getEnumValues(DataType.class);
                if (Arrays.asList(datatypes).contains(args[parameterIndex + 1].toUpperCase())) {
                    indices.add(parameterIndex + 1);
                    this.dataType = DataType.valueOf(args[parameterIndex + 1].toUpperCase());
                }
            } else {
                System.out.println("No data type defined!");
            }
        }

        //search for the sortingType cli argument
        parameterIndex = getElementIndex(args, "-sortingType");
        if (parameterIndex != -1) {
            indices.add(parameterIndex);
            if (parameterIndex + 1 < args.length) {
                String[] sortingTypes = getEnumValues(SortingType.class);
                if (Arrays.asList(sortingTypes).contains(args[parameterIndex + 1].toUpperCase())) {
                    indices.add(parameterIndex + 1);
                    this.sortingType = SortingType.valueOf(args[parameterIndex + 1].toUpperCase());
                }
            } else {
                System.out.println("No sorting type defined!");
            }
        }

        for (int i = 0; i < args.length; i++) {
            if (!indices.contains(i)){
                System.out.println("\"" + args[i] + "\" isn't a valid parameter. It's skipped.");
            }
        }
    }


    private static int getElementIndex(String[] array, String element){
        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(array[i].toLowerCase(), element.toLowerCase())){
                return i;
            }
        }
        return -1;
    }

    private void getStatistics() {
        ArrayList<String> stringList = getDataFromStdin();
        switch (dataType){
            case LINE:
                if (sortingType == SortingType.BYCOUNT){
                    HashMap<String, Integer> map = getStringCounter(stringList);
                    LinkedHashMap<String, Integer> sortedMap = sortHashMapByKey(map);
                    printWordCounterStats(sortedMap);
                } else {
                    Collections.sort(stringList);
                    printSortedLineStats(stringList);
                }
                break;
            case LONG:
                ArrayList<Long> numberList = convertStringListToLongList(stringList);
                if (sortingType == SortingType.BYCOUNT){
                    HashMap<Long, Integer> map = getCounterHashMap(numberList);
                    LinkedHashMap<Long, Integer> sortedMap = sortHashMapByKey(map);
                    printNumberCounterStats(sortedMap);
                } else {
                    Collections.sort(numberList);
                    printSortedNumberStats(numberList);
                }
                break;
            case WORD:
            default:
                if (sortingType == SortingType.BYCOUNT){
                    HashMap<String, Integer> map = getStringCounter(stringList);
                    LinkedHashMap<String, Integer> sortedMap = sortHashMapByKey(map);
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



