package com.api.v1.services.rent;

import com.api.v1.dtos.rent.RentResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AllRentsRetrievalService {

    Mono<RentResponseDto> findByOrderNumber(String orderNumber);
    Flux<RentResponseDto> findAll();

}
