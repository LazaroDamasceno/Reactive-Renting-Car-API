package com.api.v2.car

data class CarResponseDto(
    val vin: String,
    val model: String,
    val productionYear: String,
    val make: String,
    val plateNumber: String,
    val createdAt: String,
    val updatedAt: String
)