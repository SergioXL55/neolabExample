package com.exception;

public class AnimalNotFoundException extends Exception {

    final public static String ERROR_MESSAGE = "Animals not found";

    public AnimalNotFoundException() {
        super(ERROR_MESSAGE);
    }


}
