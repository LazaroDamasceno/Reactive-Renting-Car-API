package com.api.v1.services;

import com.api.v1.dtos.CustomerRegistrationRequestDto;
import com.api.v1.dtos.CustomerResponseDto;
import reactor.core.publisher.Mono;

public interface CustomerRegistrationService {

    Mono<CustomerResponseDto> register(CustomerRegistrationRequestDto request);

}
