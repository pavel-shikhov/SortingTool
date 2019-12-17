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

    static <E extends Comparable<E>> HashMap<E, Integer>  createCounter(ArrayList<E> list){
        Set<E> numberSet = new HashSet<>(list);
        HashMap<E, Integer> map = new HashMap<>();
        for (E item : numberSet){
            map.put(item, Collections.frequency(list, item));
        }
        return map;
    }
}