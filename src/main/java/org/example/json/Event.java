package org.example.json;
import java.util.ArrayList;

public class Event {
    ArrayList<Matches> Events;

    public String listPrint(){
        String stringList ="";
        for(Matches x : Events) {
            stringList += x;
        }
        return stringList;
    }


    @Override
    public String toString() {
        return  listPrint() +"\n"+"\n";
    }


}
