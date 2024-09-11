package com.api.v2.customer.services

import com.api.v2.customer.dtos.CustomerResponseDto
import com.api.v2.dtos.CustomerUpdateRequestDto

interface CustomerUpdateService {

    suspend fun update(ssn: String, requestDto: CustomerUpdateRequestDto): com.api.v2.customer.dtos.CustomerResponseDto

}