package com.api.v1.car.dtos;

import com.api.v1.car.annotations.PlateNumber;
import com.api.v1.car.annotations.VIN;
import jakarta.validation.constraints.NotBlank;

public record CarRegistrationRequestDto(
        @NotBlank String make,
        @NotBlank String model,
        int productionYear,
        @VIN String vin,
        @PlateNumber String plateNumber
) {
}
