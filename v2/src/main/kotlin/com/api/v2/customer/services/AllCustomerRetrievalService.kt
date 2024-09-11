package com.api.v2.customer.services

import com.api.v2.customer.dtos.CustomerResponseDto
import kotlinx.coroutines.flow.Flow

interface AllCustomerRetrievalService {

    suspend fun findBySsn(ssn: String): CustomerResponseDto
    suspend fun findAll(): Flow<CustomerResponseDto>

}