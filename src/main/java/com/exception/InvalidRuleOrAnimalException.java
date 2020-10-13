package com.exception;

public class InvalidRuleOrAnimalException extends Exception {

    final public static String ERROR_MESSAGE = "The rules doesn't fit these animals";

    public InvalidRuleOrAnimalException() {
        super(ERROR_MESSAGE);
    }
}
