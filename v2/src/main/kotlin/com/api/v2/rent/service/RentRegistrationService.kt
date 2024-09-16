package com.api.v2.rent.service

import com.api.v2.rent.dtos.RentResponseDto

interface RentRegistrationService {

    suspend fun register(ssn: String, vin: String, paymentOrderNumber: String, days: Long): RentResponseDto

}