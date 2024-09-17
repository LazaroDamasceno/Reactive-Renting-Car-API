package com.api.v1.services.payment;

import com.api.v1.dtos.payment.PaymentResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AllPaymentsRetrievalService {

    Flux<PaymentResponseDto> findAll();
    Mono<PaymentResponseDto> findByOrderNumber(String orderNumber);

}
