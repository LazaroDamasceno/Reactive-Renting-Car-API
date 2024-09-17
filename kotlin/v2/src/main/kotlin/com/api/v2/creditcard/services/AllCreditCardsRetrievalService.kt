package com.api.v2.creditcard.services

import com.api.v2.creditcard.dtos.CreditCardResponseDto
import kotlinx.coroutines.flow.Flow

interface AllCreditCardsRetrievalService {

    suspend fun findByCardNumber(cardNumber: String): CreditCardResponseDto
    suspend fun findAll(): Flow<CreditCardResponseDto>

}