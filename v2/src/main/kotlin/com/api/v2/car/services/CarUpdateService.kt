package com.api.v2.car.services

import com.api.v2.car.dtos.CarUpdateRequestDto

interface CarUpdateService {

    suspend fun update(vin: String, requestDto: CarUpdateRequestDto)

}