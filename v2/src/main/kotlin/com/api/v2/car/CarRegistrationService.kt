package com.api.v2.car

interface CarRegistrationService {

    suspend fun register(requestDto: CarRegistrationRequestDto)

}