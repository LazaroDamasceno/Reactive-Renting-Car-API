package com.api.v2.rent.service

import com.api.v2.rent.dtos.RentResponseDto
import kotlinx.coroutines.flow.Flow

interface AllRentsRetrievalService {

    suspend fun findByOrderNumber(orderNumber: String): RentResponseDto
    suspend fun findAll(): Flow<RentResponseDto>

}