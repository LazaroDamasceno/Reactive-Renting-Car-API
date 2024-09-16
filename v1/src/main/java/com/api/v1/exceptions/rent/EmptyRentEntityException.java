package com.api.v1.exceptions.rent;

public class EmptyRentEntityException extends RuntimeException {

    public EmptyRentEntityException() {
        super("The entity Rent is empty.");
    }

}
