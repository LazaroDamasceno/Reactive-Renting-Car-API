package com.api.v2.customer.services

import com.api.v2.customer.dtos.CustomerRegistrationRequestDto
import com.api.v2.customer.dtos.CustomerResponseDto

interface CustomerRegistrationService {

    suspend fun register(requestDto: CustomerRegistrationRequestDto): CustomerResponseDto

}