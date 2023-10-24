package com.example.imageapi.exception;

public class FilterMalformedException extends RuntimeException {


    public FilterMalformedException() {
        super("Filter is malformed.");
    }

    public FilterMalformedException(String message) {
        super(message);
    }
}