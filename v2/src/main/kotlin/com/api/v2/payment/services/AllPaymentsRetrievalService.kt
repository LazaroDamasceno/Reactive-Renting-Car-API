package com.api.v2.payment.services

import com.api.v2.payment.dtos.PaymentResponseDto
import kotlinx.coroutines.flow.Flow

interface AllPaymentsRetrievalService {

    suspend fun findAll(): Flow<PaymentResponseDto>
    suspend fun findByOrderNumber(orderNumber: String): PaymentResponseDto

}