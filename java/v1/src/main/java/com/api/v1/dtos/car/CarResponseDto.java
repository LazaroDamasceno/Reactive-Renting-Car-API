package com.api.v1.dtos.car;

public record CarResponseDto(
        String make,
        String model,
        int productionYear,
        String vin,
        String plateNumber,
        String addedAt,
        String updatedAt
) {
}
