package com.api.v1.dtos;

import com.api.v1.annotations.PlateNumber;
import com.api.v1.annotations.VIN;
import jakarta.validation.constraints.NotBlank;

public record CarRegistrationRequestDto(
        @NotBlank String make,
        @NotBlank String model,
        int productionYear,
        @VIN String vin,
        @PlateNumber String plateNumber
) {
}
