package com.api.v1.exceptions;

public class CreditCardNotFoundException extends RuntimeException {

    public CreditCardNotFoundException(String cardNumber) {
        super("Credit card which number is %s was not found.".formatted(cardNumber));
    }

}
