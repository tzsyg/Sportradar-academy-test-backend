package org.example.json;


import java.util.*;

public class Alphabetically {
    public static HashSet<String> alphabetically = new HashSet<String>();

    public static HashSet<String> getAlphabetically() {
        return alphabetically;
    }

    public static void setAlphabetically(HashSet<String> alphabetically) {
        Alphabetically.alphabetically = alphabetically;
    }

    public TreeSet<String> sortSet(){
        TreeSet<String> mySet = new TreeSet<>(alphabetically);

        return mySet;
    }
    public String printList(){

        return sortSet().toString();
    }

    @Override
    public String toString() {
        return "Alphabetically{}";
    }
}
