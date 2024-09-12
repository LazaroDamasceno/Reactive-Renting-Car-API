package com.api.v2.creditcard.services

import com.api.v2.creditcard.domain.CreditCard
import com.api.v2.creditcard.dtos.CreditCardResponseDto

interface CreditCardRegistrationService {

    suspend fun register(creditCard: CreditCard): CreditCardResponseDto

}