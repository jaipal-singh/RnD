package com.test.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStreamer {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<10;i++) {
            map.put(""+i, i+5);
        }
        
        System.out.println("map - " + map);
        
//        Map<String, String> mapped = map.entrySet().stream().collect(
//                Collectors.toMap(Map.Entry::getKey, entry -> String.valueOf(entry.getValue())));
//        
//        System.out.println("mapped - " + mapped);
        
        Map<Integer, String> mapped1 = map.entrySet().stream().collect(
                Collectors.toMap(Map.Entry::getValue, entry -> String.valueOf(entry.getKey())));
        
        System.out.println("mapped1 - " + mapped1);
    }

}
