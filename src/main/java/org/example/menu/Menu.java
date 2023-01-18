package org.example.menu;

import com.google.gson.Gson;
import org.example.json.Alphabetically;
import org.example.json.Reader;
import org.example.json.TopTen;

import java.util.Scanner;

import static org.example.exception.Exception.checkRange;

//Menu class for easier usage of the program.
public class Menu {
    private int choice;
    private int amount;
    private Scanner scanner;

    public void menu(){
        System.out.println("1) Print 10 most probable results");
        System.out.println("2) Print as many probable results as you want");
        System.out.println("3) Print teams alphabetically");
        scanner = new Scanner(System.in);
        System.out.print(">>");
        choice = scanner.nextInt();

        Gson gson = new Gson();
        Reader reader = new Reader(gson);
        TopTen map = new TopTen();

        switch (choice) {
            case 1:
                reader.reader();
                map.top_amount();
                break;
            case 2:
                System.out.println("How many teams want you see?");
                reader.reader();
                System.out.print(">>");
                amount = scanner.nextInt();
                try {
                    checkRange(amount);
                    map.top_amount(amount);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }

                break;
            case 3:
                Alphabetically a = new Alphabetically();
                reader.reader();
                System.out.println(a.printList());
                break;
        }

    }
}
