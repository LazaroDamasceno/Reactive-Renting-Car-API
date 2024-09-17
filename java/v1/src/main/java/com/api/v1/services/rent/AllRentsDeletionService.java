package com.api.v1.services.rent;

import reactor.core.publisher.Mono;

public interface AllRentsDeletionService {

    Mono<Void> deleteAll();
    Mono<Void> deleteByOrderNumber(String orderNumber);

}
