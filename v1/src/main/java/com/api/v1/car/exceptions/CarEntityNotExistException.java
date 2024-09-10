package com.api.v1.car.exceptions;

public class CarEntityNotExistException extends RuntimeException {

    public CarEntityNotExistException() {
        super("Entity Car no longer exists.");
    }

}
