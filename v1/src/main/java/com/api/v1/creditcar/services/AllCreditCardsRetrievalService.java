package com.api.v1.creditcar.services;

import com.api.v1.creditcar.dtos.CreditCardResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AllCreditCardsRetrievalService {

    Flux<CreditCardResponseDto> findAll();
    Mono<CreditCardResponseDto> findByCardNumber(String cardNumber);

}
