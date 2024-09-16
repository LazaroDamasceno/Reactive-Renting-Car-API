package com.api.v1.services;

import reactor.core.publisher.Mono;

public interface RentTerminationService {

    Mono<Void> terminate(String orderNumber);

}
