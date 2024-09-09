package com.api.v1.customer.services;

import com.api.v1.customer.dtos.CustomerResponseDto;
import com.api.v1.customer.dtos.CustomerUpdatingRequestDto;
import reactor.core.publisher.Mono;

public interface CustomerUpdatingService {

    Mono<CustomerResponseDto> update(String ssn, CustomerUpdatingRequestDto requestDto);

}
