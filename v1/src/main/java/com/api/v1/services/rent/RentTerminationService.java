package com.api.v1.services.rent;

import reactor.core.publisher.Mono;

public interface RentTerminationService {

    Mono<Void> terminate(String orderNumber);

}
