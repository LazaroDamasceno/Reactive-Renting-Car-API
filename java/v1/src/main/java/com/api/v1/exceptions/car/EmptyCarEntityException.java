package com.api.v1.exceptions.car;

public class EmptyCarEntityException extends RuntimeException {

    public EmptyCarEntityException() {
        super("Entity Car no longer exists.");
    }

}
