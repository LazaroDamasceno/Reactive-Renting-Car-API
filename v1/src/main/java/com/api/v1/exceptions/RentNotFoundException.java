package com.api.v1.exceptions;

public class RentNotFoundException extends RuntimeException {

    public RentNotFoundException(String orderNumber) {
        super("Rent %s was not found.");
    }

}
