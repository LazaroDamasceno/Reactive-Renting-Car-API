package com.api.v1.mappers;

import com.api.v1.domain.Car;
import com.api.v1.dtos.CarResponseDto;

public record CarResponseMapper(Car car) {

    public CarResponseDto mapToDto() {
        return new CarResponseDto(
                car.getMake(),
                car.getModel(),
                car.getProductionYear(),
                car.getVin(),
                car.getPlateNumber(),
                car.getAddedAt(),
                car.getUpdatedAt()
        );
    }

}
