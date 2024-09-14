package com.api.v1.exceptions;

public class PaymentNotFoundException extends RuntimeException {

    public PaymentNotFoundException(String orderNumber) {
        super("Order number %s was not found".formatted(orderNumber));
    }

}
