package com.api.v1.dtos;

import com.api.v1.annotations.PlateNumber;
import jakarta.validation.constraints.NotBlank;

public record CarUpdatingRequestDto(
        @NotBlank String make,
        @NotBlank String model,
        int productionYear,
        @PlateNumber String plateNumber
) {
}
