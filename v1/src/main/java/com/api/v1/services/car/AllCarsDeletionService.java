package com.api.v1.services.car;

import reactor.core.publisher.Mono;

public interface AllCarsDeletionService {

    Mono<Void> deleteAll();
    Mono<Void> deleteByVin(String vin);

}
