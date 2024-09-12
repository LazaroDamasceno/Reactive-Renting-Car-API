package com.api.v2.car

class DuplicatedPlateNumberException(plateNumber: String)
    : RuntimeException("The input plate number $plateNumber was already registered.")