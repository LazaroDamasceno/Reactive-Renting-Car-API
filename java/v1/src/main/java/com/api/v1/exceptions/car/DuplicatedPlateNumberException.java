package com.api.v1.exceptions.car;

public class DuplicatedPlateNumberException extends RuntimeException {

    public DuplicatedPlateNumberException(String plateNumber) {
        super("The input plate number %s was already used.".formatted(plateNumber));
    }

}
