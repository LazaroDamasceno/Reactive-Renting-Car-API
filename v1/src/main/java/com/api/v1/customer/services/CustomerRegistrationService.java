package com.api.v1.customer.services;

import com.api.v1.customer.dtos.CustomerRegistrationRequestDto;
import com.api.v1.customer.dtos.CustomerResponseDto;
import reactor.core.publisher.Mono;

public interface CustomerRegistrationService {

    Mono<CustomerResponseDto> register(CustomerRegistrationRequestDto request);

}
