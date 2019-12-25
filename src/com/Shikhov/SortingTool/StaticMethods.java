package com.Shikhov.SortingTool;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StaticMethods {
    static ArrayList<Integer> indices = new ArrayList<>();

    static <E extends Comparable<E>> LinkedHashMap<E, Integer> sortHashMapByKey(HashMap<E, Integer> map){
        ArrayList<E> keys = new ArrayList<>(map.keySet());
        ArrayList<Integer> values = new ArrayList<>(map.values());
        Collections.sort(keys);
        Collections.sort(values);
        LinkedHashMap<E, Integer> sortedMap = new LinkedHashMap<>();

        for (Integer value : values) {
            Iterator<E> keyIt = keys.iterator();
            while (keyIt.hasNext()){
                E key = keyIt.next();
                if (map.get(key).equals(value)){
                    keyIt.remove();
                    sortedMap.put(key, value);
                    break;
                }
            }
        }
        return sortedMap;
    }

    static <E extends Comparable<E>> HashMap<E, Integer>  createCounter(ArrayList<E> list){
        Set<E> numberSet = new HashSet<>(list);
        HashMap<E, Integer> map = new HashMap<>();
        for (E item : numberSet){
            map.put(item, Collections.frequency(list, item));
        }
        return map;
    }

    static void printWrongCliArgs(String[] args){
        for (int i = 0; i < args.length; i++) {
            if (!indices.contains(i)){
                System.out.println("\"" + args[i] + "\" isn't a valid parameter. It's skipped.");
            }
        }
    }

    static ArrayList<Long> convertStringListToLongList(ArrayList<String> stringList){
        ArrayList<Long> numberList = new ArrayList<>();
        for (String item : stringList) {
            try {
                numberList.add(Long.valueOf(item));
            } catch (NumberFormatException e) {
                System.out.println("\"" + item + "\" isn't a long. It's skipped.");
            }
        }
        return numberList;
    }

    static File getOutputFileFromCli(List<String> cliArgs) {
        int argIndex = cliArgs.indexOf("-outputFile");
        if (argIndex == -1){
            return null;
        }
        indices.add(argIndex);
        if (argIndex + 1 < cliArgs.size()
                && !cliArgs.get(argIndex + 1).matches("-dataType|-sortingType|-inputFile|-outputFile")) {
            indices.add(argIndex+1);
            File outputFile = new File("./" + cliArgs.get(argIndex + 1));
            if (outputFile.isFile()) {
                return outputFile;
            } else {
                Pattern pattern = Pattern.compile("[a-z0-9]+\\.txt");
                Matcher matcher = pattern.matcher(cliArgs.get(argIndex + 1));
                if (matcher.matches()){
                    return outputFile;
                } else {
                    System.out.println("Invalid file name.");
                    return null;
                }
            }
        } else {
            System.out.println("No output file defined!");
        }
        return null;
    }

    static SortingType getSortingTypeFromCli(List<String> cliArgs){
        int argIndex = cliArgs.indexOf("-sortingType");
        if (argIndex == -1){
            return null;
        }
        indices.add(argIndex);
        if (argIndex + 1 < cliArgs.size() &&
                !cliArgs.get(argIndex + 1).matches("-dataType|-sortingType|-inputFile|-outputFile")) {
            indices.add(argIndex+1);
            List<String> sortingTypes = Stream.of(SortingType.values())
                    .map(SortingType::name)
                    .collect(Collectors.toList());
            if (sortingTypes.contains(cliArgs.get(argIndex + 1).toUpperCase())){
                return SortingType.valueOf(cliArgs.get(argIndex + 1).toUpperCase());
            }
        } else {
            System.out.println("No sorting type defined!");
            return null;
        }
        return null;
    }

    static File getInputFileFromCli(List<String> cliArgs) {
        int argIndex = cliArgs.indexOf("-inputFile");
        if (argIndex == -1){
            return null;
        }
        indices.add(argIndex);
        if (argIndex + 1 < cliArgs.size() &&
                !cliArgs.get(argIndex + 1).matches("-dataType|-sortingType|-inputFile|-outputFile")) {
            indices.add(argIndex+1);
            File inputFile = new File("./" + cliArgs.get(argIndex + 1));
            if (inputFile.isFile()) {
                return inputFile;
            }
        } else {
            System.out.println("No input file defined!");
        }
        return null;
    }

    static DataType getDataTypeFromCli(List<String> cliArgs){
        int argIndex = cliArgs.indexOf("-dataType");
        if (argIndex == -1){
            return null;
        }
        indices.add(argIndex);
        if (argIndex + 1 < cliArgs.size() &&
                !cliArgs.get(argIndex + 1).matches("-dataType|-sortingType|-inputFile|-outputFile")) {
            indices.add(argIndex+1);
            List<String> dataTypes = Stream.of(DataType.values())
                    .map(DataType::name)
                    .collect(Collectors.toList());
            if (dataTypes.contains(cliArgs.get(argIndex + 1).toUpperCase())){
                return DataType.valueOf(cliArgs.get(argIndex + 1).toUpperCase());
            }
        } else {
            System.out.println("No data type defined!");
            return null;
        }
        return null;
    }
}