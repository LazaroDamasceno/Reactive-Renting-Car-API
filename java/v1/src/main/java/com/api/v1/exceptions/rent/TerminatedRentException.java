package com.api.v1.exceptions.rent;

public class TerminatedRentException extends RuntimeException {

    public TerminatedRentException(String orderNumber) {
        super("Rent which order number is %s is already terminated.".formatted(orderNumber));
    }
}
