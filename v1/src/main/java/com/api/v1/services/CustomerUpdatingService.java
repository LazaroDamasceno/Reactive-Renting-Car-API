package com.api.v1.services;

import com.api.v1.dtos.CustomerResponseDto;
import com.api.v1.dtos.CustomerUpdatingRequestDto;
import reactor.core.publisher.Mono;

public interface CustomerUpdatingService {

    Mono<CustomerResponseDto> update(String ssn, CustomerUpdatingRequestDto requestDto);

}
