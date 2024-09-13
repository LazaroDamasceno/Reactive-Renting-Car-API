package com.api.v1.builders;

import com.api.v1.domain.Car;
import com.api.v1.dtos.CarRegistrationRequestDto;
import jakarta.validation.Valid;

import java.time.ZonedDateTime;
import java.util.UUID;

public class CarBuilder {

    private final UUID id = UUID.randomUUID();
    private String make;
    private String model;
    private int productionYear;
    private String vin;
    private String plateNumber;
    private final String addedAt = ZonedDateTime.now().toString();

    private CarBuilder() {}

    public static CarBuilder create() {
        return new CarBuilder();
    }

    public CarBuilder fromDto(@Valid CarRegistrationRequestDto requestDto) {
        this.make = requestDto.make();
        this.model = requestDto.model();
        this.productionYear = requestDto.productionYear();
        this.vin = requestDto.vin();
        this.plateNumber = requestDto.plateNumber();
        return this;
    }

    public Car build() {
        return new Car(
                id,
                make,
                model,
                productionYear,
                vin,
                plateNumber,
                addedAt
        );
    }

}
