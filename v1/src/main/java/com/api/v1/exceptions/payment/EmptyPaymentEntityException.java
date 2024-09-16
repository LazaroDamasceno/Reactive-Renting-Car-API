package com.api.v1.exceptions.payment;

public class EmptyPaymentEntityException extends RuntimeException {

    public EmptyPaymentEntityException() {
        super("The entity Payment is empty.");
    }

}
