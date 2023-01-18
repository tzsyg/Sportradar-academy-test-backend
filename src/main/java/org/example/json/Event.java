package org.example.json;
import java.util.ArrayList;

//Class for mapping the Event list.

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
