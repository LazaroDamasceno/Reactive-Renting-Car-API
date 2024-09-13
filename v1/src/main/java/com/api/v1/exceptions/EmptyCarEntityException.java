package com.api.v1.exceptions;

public class EmptyCarEntityException extends RuntimeException {

    public EmptyCarEntityException() {
        super("Entity Car no longer exists.");
    }

}
