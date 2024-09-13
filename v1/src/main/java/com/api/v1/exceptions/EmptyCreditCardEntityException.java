package com.api.v1.exceptions;

public class EmptyCreditCardEntityException extends RuntimeException {

    public EmptyCreditCardEntityException() {
        super("The entity CreditCard is empty.");
    }

}
