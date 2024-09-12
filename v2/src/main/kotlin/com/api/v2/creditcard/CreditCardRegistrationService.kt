package com.api.v2.creditcard

interface CreditCardRegistrationService {

    suspend fun register(creditCard: CreditCard): CreditCard

}