package com.api.v1.car.services;

import reactor.core.publisher.Mono;

public interface AllCarsDeletionService {

    Mono<Void> deleteAll();
    Mono<Void> deleteByVin(String vin);

}
