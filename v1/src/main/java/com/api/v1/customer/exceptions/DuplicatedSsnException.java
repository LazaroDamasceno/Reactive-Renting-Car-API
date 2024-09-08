package com.api.v1.customer.exceptions;

public class DuplicatedSsnException extends RuntimeException {

    public DuplicatedSsnException(String ssn) {
        super("The given SSN %s is already used.".formatted(ssn));
    }

}
