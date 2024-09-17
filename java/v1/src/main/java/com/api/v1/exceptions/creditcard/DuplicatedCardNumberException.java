package com.api.v1.exceptions.creditcard;

public class DuplicatedCardNumberException extends RuntimeException {

    public DuplicatedCardNumberException(String cardNumber) {
        super("Card number %s is already registered.".formatted(cardNumber));
    }
}
