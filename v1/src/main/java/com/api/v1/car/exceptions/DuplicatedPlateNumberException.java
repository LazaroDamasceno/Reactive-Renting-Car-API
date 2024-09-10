package com.api.v1.car.exceptions;

public class DuplicatedPlateNumberException extends RuntimeException {

    public DuplicatedPlateNumberException(String plateNumber) {
        super("The input plate number %s was already used.".formatted(plateNumber));
    }

}
