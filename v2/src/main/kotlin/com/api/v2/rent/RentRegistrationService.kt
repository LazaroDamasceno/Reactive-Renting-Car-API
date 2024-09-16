package com.api.v2.rent

interface RentRegistrationService {

    suspend fun register(ssn: String, vin: String, paymentOrderNumber: String): RentResponseDto

}