package com.api.v2

interface CustomerRegistrationService {

    suspend fun register(requestDto: CustomerRegistrationRequestDto): CustomerResponseDto

}