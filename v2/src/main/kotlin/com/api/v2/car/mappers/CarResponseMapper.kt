package com.api.v2.car.mappers

import com.api.v2.car.domain.Car
import com.api.v2.car.dtos.CarResponseDto

class CarResponseMapper {

    companion object {
        fun mapToDto(car: Car): CarResponseDto {
            return CarResponseDto(
                car.vin,
                car.model,
                car.productionYear,
                car.make,
                car.plateNumber,
                car.createdAt,
                car.updatedAt
            )
        }
    }

}