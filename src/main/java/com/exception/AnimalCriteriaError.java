package com.exception;

public class AnimalCriteriaError extends Exception {

    final public static String ERROR_MESSAGE = "Animal criteria not found or invalid";

    public AnimalCriteriaError() {
        super(ERROR_MESSAGE);
    }
}
