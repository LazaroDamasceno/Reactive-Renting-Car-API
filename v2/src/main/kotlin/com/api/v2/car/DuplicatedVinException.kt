package com.api.v2.car

class DuplicatedVinException(vin: String)
    : RuntimeException("The input vin $vin is already registered.")