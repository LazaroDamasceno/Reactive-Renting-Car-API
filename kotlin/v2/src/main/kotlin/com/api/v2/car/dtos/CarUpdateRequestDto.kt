package com.api.v2.car.dtos

data class CarUpdateRequestDto(
    var model: String,
    var productionYear: String,
    var make: String,
    var plateNumber: String
)