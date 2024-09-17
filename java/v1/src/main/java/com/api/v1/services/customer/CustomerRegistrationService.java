package com.api.v1.services.customer;

import com.api.v1.dtos.customer.CustomerRegistrationRequestDto;
import com.api.v1.dtos.customer.CustomerResponseDto;
import reactor.core.publisher.Mono;

public interface CustomerRegistrationService {

    Mono<CustomerResponseDto> register(CustomerRegistrationRequestDto request);

}
