package com.api.v1.services;

import com.api.v1.dtos.PaymentResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AllPaymentsRetrievalService {

    Flux<PaymentResponseDto> findAll();
    Mono<PaymentResponseDto> findByOrderNumber(String orderNumber);

}
