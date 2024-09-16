package com.api.v1.exceptions.creditcard;

public class EmptyCreditCardEntityException extends RuntimeException {

    public EmptyCreditCardEntityException() {
        super("The entity CreditCard is empty.");
    }

}
