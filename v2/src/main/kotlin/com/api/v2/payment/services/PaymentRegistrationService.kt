package com.api.v2.payment.services

import com.api.v2.payment.dtos.PaymentResponseDto

interface PaymentRegistrationService {

    suspend fun register(ssn: String, vin: String, cardNumber: String): PaymentResponseDto

}