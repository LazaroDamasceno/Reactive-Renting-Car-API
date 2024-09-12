package com.api.v2.car.services

import com.api.v2.car.dtos.CarResponseDto
import kotlinx.coroutines.flow.Flow

interface AllCarsRetrievalService {

    suspend fun findAll(): Flow<CarResponseDto>
    suspend fun findByVin(vin: String): CarResponseDto

}