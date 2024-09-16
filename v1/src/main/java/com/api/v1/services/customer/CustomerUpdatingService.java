package com.api.v1.services.customer;

import com.api.v1.dtos.customer.CustomerResponseDto;
import com.api.v1.dtos.customer.CustomerUpdatingRequestDto;
import reactor.core.publisher.Mono;

public interface CustomerUpdatingService {

    Mono<CustomerResponseDto> update(String ssn, CustomerUpdatingRequestDto requestDto);

}
