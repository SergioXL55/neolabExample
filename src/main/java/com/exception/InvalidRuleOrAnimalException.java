package com.exception;

public class InvalidRuleOrAnimalException extends Exception {

    final public static String ERROR_MESSAGE = "Could not apply rule for this animal. You should check the animal/rule file structure.";

    public InvalidRuleOrAnimalException() {
        super(ERROR_MESSAGE);
    }
}
