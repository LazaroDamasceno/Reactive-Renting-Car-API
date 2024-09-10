package com.api.v1.car.dtos;

public record CarResponseDto(
        String make,
        String model,
        int productionYear,
        String vin,
        int plateNumber
) {
}
