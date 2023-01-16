package org.example.json;

import java.util.*;

public class TopTen {
    public static HashMap<String, Double> map = new HashMap<>();

    public LinkedHashMap<String, Double> sorted_desceding(){
        LinkedHashMap<String, Double> sortedMap = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        return sortedMap;
    }

    //The top 10 probability
    public void top_amount(){
        Iterator<Map.Entry<String, Double>> iterator = sorted_desceding().entrySet().iterator();
        for (int i = 0; i < 10; i++) {
            Map.Entry<String, Double> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    //Method that takes the amount from the input
    public void top_amount(int amount){

        Iterator<Map.Entry<String, Double>> iterator = sorted_desceding().entrySet().iterator();
        for (int i = 0; i < amount; i++) {
            Map.Entry<String, Double> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
