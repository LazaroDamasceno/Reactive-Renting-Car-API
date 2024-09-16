package com.api.v1.services;

import com.api.v1.dtos.RentResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AllRentsRetrievalService {

    Mono<RentResponseDto> findByOrderNumber(String orderNumber);
    Flux<RentResponseDto> findAll();

}
