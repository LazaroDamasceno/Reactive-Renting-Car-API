package com.api.v1.creditcar.services;

import reactor.core.publisher.Mono;

public interface AllCreditCardsDeletionService {

    Mono<Void> deleteAll();
    Mono<Void> deleteByCardNumber(String cardNumber);

}
