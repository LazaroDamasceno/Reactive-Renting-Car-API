package com.api.v2.rent.service

import com.api.v2.rent.dtos.RentResponseDto

interface RentTerminationService {

    suspend fun terminate(orderNumber: String)

}