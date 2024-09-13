package com.api.v1.creditcar.exceptions;

public class DuplicatedCardNumberException extends RuntimeException {

    public DuplicatedCardNumberException(String message) {
        super("Card number %s is already registered.".formatted(message));
    }
}
