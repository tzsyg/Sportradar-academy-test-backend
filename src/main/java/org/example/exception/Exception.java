package org.example.exception;

public class Exception {

    public static void checkRange(int input){
        if (input < 0 || input > 74) {
            throw new IndexOutOfBoundsException("Input must be between 0 and 74.");
        }
    }
}
