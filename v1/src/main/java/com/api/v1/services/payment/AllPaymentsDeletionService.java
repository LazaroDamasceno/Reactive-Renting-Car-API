package com.api.v1.services.payment;

import reactor.core.publisher.Mono;

public interface AllPaymentsDeletionService {

    Mono<Void> deleteAll();
    Mono<Void> deleteByOrderNumber(String orderNumber);

}
