package com.api.v2.customer.services

import com.api.v2.dtos.CustomerRegistrationRequestDto
import com.api.v2.customer.dtos.CustomerResponseDto

interface CustomerRegistrationService {

    suspend fun register(requestDto: CustomerRegistrationRequestDto): com.api.v2.customer.dtos.CustomerResponseDto

}