package com.api.v2.car.services

import com.api.v2.car.dto.CarRegistrationRequestDto

interface CarRegistrationService {

    suspend fun register(requestDto: CarRegistrationRequestDto)

}