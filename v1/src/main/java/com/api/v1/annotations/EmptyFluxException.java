package com.api.v1.annotations;

public class EmptyFluxException extends RuntimeException {

    public EmptyFluxException() {
        super("The flux is empty.");
    }

}
