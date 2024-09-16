package com.api.v1.dtos.car;

import com.api.v1.annotations.car.PlateNumber;
import com.api.v1.annotations.car.VIN;
import jakarta.validation.constraints.NotBlank;

public record CarRegistrationRequestDto(
        @NotBlank String make,
        @NotBlank String model,
        int productionYear,
        @VIN String vin,
        @PlateNumber String plateNumber
) {
}
