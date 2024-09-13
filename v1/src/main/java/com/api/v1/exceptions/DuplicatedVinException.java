package com.api.v1.exceptions;

public class DuplicatedVinException extends RuntimeException {

    public DuplicatedVinException(String vin) {
        super("The input VIN is %s already registered.".formatted(vin));
    }
}
