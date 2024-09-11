package com.api.v2

import reactor.core.publisher.Mono

interface CustomerRegistrationService {

    suspend fun register(requestDto: CustomerRegistrationRequestDto): Mono<CustomerResponseDto>

}