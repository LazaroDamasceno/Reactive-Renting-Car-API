package com.api.v2.customer.services

import com.api.v2.customer.domain.Customer
import com.api.v2.customer.dtos.CustomerResponseDto

interface CustomerRegistrationService {

    suspend fun register(requestDto: Customer): CustomerResponseDto

}