package com.Shikhov.sorting;

import java.util.*;

class MapUtils {
    //TODO: provide for a situation when a stringList item is NOT a string representation of a number
    static ArrayList<Long> convertStringListToLongList(ArrayList<String> stringList){
        ArrayList<Long> numberList = new ArrayList<>();
        for (String stringNumber : stringList) {
            try {
                numberList.add(Long.valueOf(stringNumber));
            } catch (NumberFormatException e) {
                System.out.println("\"" + stringNumber + "\" isn't a long. It's skipped.");
            }
        }
        return numberList;
    }

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

    static HashMap<Long, Integer> getCounterHashMap(ArrayList<Long> numberList){
        Set<Long> numberSet = new HashSet<>(numberList);
        HashMap<Long, Integer> map = new HashMap<>();
        for (Long number : numberSet){
            map.put(number, Collections.frequency(numberList, number));
        }
        return map;
    }

    static HashMap<String, Integer> getStringCounter(ArrayList<String> stringList){
        Set<String> stringSet = new HashSet<>(stringList);
        HashMap<String, Integer> map = new HashMap<>();
        for (String string : stringSet){
            map.put(string, Collections.frequency(stringList, string));
        }
        return map;
    }
}