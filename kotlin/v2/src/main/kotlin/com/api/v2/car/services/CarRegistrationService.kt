package com.api.v2.car.services

import com.api.v2.car.domain.Car

interface CarRegistrationService {

    suspend fun register(car: Car)

}