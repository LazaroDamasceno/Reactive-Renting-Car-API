package com.api.v2.car.services

import com.api.v2.car.dtos.CarRegistrationRequestDto

interface CarRegistrationService {

    suspend fun register(requestDto: CarRegistrationRequestDto)

}