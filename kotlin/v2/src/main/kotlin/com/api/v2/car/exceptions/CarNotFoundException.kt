package com.api.v2.car.exceptions

class CarNotFoundException(vin: String)
    : RuntimeException("Car which VIN is $vin was not found.")