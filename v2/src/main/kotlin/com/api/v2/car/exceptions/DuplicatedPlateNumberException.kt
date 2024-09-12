package com.api.v2.car.exceptions

class DuplicatedPlateNumberException(plateNumber: String)
    : RuntimeException("The input plate number $plateNumber was already registered.")