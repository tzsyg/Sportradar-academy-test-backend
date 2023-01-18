package org.example.json;

import java.util.*;

//Class for storing the highest probability results and also for getting the top ten most probable results.
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

    //Method for printing the TopTen most probable results.
    public void top_amount(){
        Iterator<Map.Entry<String, Double>> iterator = sorted_desceding().entrySet().iterator();
        for (int i = 0; i < 10; i++) {
            Map.Entry<String, Double> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    //Method for printing the inputted amount of most probable results. The validation of the input is executed in the "Menu" class.
    public void top_amount(int amount){

        Iterator<Map.Entry<String, Double>> iterator = sorted_desceding().entrySet().iterator();
        for (int i = 0; i < amount; i++) {
            Map.Entry<String, Double> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
