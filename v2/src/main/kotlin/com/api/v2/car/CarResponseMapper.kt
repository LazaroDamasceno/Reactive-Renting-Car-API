package com.api.v2.car

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