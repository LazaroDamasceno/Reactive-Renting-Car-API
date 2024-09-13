package com.api.v1.creditcar.exceptions;

public class EmptyCreditCardEntityException extends RuntimeException {

    public EmptyCreditCardEntityException() {
        super("The entity CreditCard is empty.");
    }

}
