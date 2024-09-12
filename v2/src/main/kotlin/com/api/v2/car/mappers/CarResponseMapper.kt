package com.api.v2.car.mappers

import com.api.v2.car.domain.Car
import com.api.v2.car.dto.CarResponseDto

class CarResponseMapper {

    companion object {
        fun mapToDto(car: Car): CarResponseDto {
            return CarResponseDto(
                car.vin,
                car.model,
                car.productionYear,
                car.make,
                car.plateNumber,
                car.createdAt
            )
        }
    }

}