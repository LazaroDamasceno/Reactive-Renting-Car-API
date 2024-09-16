package com.api.v2.rent

import kotlinx.coroutines.flow.Flow

interface AllRentsRetrievalService {

    suspend fun findByOrderNumber(orderNumber: String): RentResponseDto
    suspend fun findAll(): Flow<RentResponseDto>

}