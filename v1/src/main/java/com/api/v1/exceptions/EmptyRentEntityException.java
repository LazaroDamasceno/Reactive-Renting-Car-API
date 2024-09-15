package com.api.v1.exceptions;

public class EmptyRentEntityException extends RuntimeException {

    public EmptyRentEntityException() {
        super("The entity Rent is empty.");
    }

}
