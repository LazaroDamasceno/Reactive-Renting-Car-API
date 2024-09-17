package com.api.v2.creditcard.services

interface AllCreditCardDeletionService {

    suspend fun deleteAll()
    suspend fun deleteByCardNumber(cardNumber: String)

}