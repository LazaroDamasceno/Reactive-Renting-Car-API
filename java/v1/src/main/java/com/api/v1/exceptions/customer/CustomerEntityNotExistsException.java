package com.api.v1.exceptions.customer;

public class CustomerEntityNotExistsException extends RuntimeException {

    public CustomerEntityNotExistsException() {
        super("Entity 'Customer' no longer exists.");
    }

}
