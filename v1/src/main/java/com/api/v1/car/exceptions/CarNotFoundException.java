package com.api.v1.car.exceptions;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(String vin) {
        super("Car which VIN is %s was not found.".formatted(vin));
    }

}
