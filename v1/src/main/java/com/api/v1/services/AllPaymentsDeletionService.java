package com.api.v1.services;

import reactor.core.publisher.Mono;

public interface AllPaymentsDeletionService {

    Mono<Void> deleteAll();
    Mono<Void> deleteByOrderNumber(String orderNumber);

}
