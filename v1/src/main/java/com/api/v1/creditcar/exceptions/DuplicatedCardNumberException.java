package com.api.v1.creditcar.exceptions;

public class DuplicatedCardNumberException extends RuntimeException {

    public DuplicatedCardNumberException(String cardNumber) {
        super("Card number %s is already registered.".formatted(cardNumber));
    }
}
