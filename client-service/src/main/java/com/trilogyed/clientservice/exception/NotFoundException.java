package com.trilogyed.clientservice.exception;

/**
 * Exception class to handle not found cases in get APIs
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(int badPostId) {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
