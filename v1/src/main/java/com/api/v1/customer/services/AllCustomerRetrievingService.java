package com.api.v1.customer.services;

import com.api.v1.customer.dtos.CustomerResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AllCustomerRetrievingService {

    Mono<CustomerResponseDto> findBySsn(String ssn);
    Flux<CustomerResponseDto> findAll();

}
