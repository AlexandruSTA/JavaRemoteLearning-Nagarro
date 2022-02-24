package com.nagarro.exceptions;

public class IllegalNumberOfStudentsException extends RuntimeException {
    private final String message;

    public IllegalNumberOfStudentsException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
