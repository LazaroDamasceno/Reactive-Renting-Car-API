package com.api.v1.services;

import com.api.v1.dtos.CustomerResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AllCustomersRetrievingService {

    Mono<CustomerResponseDto> findBySsn(String ssn);
    Flux<CustomerResponseDto> findAll();

}
