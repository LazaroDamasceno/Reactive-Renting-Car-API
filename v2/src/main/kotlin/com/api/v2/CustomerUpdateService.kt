package com.api.v2

interface CustomerUpdateService {

    suspend fun update(ssn: String, requestDto: CustomerUpdateRequestDto): CustomerResponseDto

}