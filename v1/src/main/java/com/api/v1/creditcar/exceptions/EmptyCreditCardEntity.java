package com.api.v1.creditcar.exceptions;

public class EmptyCreditCardEntity extends RuntimeException {

    public EmptyCreditCardEntity() {
        super("The entity CreditCard is empty.");
    }

}
