package com.api.v1.car.mappers;

import com.api.v1.car.domain.Car;
import com.api.v1.car.dtos.CarResponseDto;

public record CarResponseMapper(Car car) {

    public CarResponseDto mapToDto() {
        return new CarResponseDto(
                car.getMake(),
                car.getModel(),
                car.getProductionYear(),
                car.getVin(),
                car.getProductionYear(),
                car.getAddedAt(),
                car.getUpdatedAt()
        );
    }

}
