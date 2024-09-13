package com.api.v1.services;

import reactor.core.publisher.Mono;

public interface CustomerDeletionService {

    Mono<Void> deleteAll();
    Mono<Void> deleteBySsn(String ssn);

}
