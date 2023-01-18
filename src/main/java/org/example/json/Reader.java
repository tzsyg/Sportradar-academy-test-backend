package org.example.json;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Reader {
    private Gson gson;
    private JsonReader eventsCapture;

//Class for reading Json.

    public Reader(Gson gson) {
        this.gson = gson;
    }

    public void reader(){

        try {
            eventsCapture = new JsonReader(new FileReader("src/main/resources/BE_data.json"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Event event = gson.fromJson(eventsCapture, Event.class);
        event.toString();

    }
}

