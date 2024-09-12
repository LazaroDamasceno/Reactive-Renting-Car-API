package com.api.v2.car

data class CarRegistrationRequestDto(
    val vin: String,
    var model: String,
    var productionYear: String,
    var make: String,
    var plateNumber: String,
)
