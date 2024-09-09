package com.api.v1.customer.services;

import reactor.core.publisher.Mono;

public interface CustomerDeletionService {

    Mono<Void> deleteAll();
    Mono<Void> deleteBySsn(String ssn);

}
