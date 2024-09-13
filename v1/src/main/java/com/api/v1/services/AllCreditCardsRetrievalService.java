package com.api.v1.services;

import com.api.v1.dtos.CreditCardResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AllCreditCardsRetrievalService {

    Flux<CreditCardResponseDto> findAll();
    Mono<CreditCardResponseDto> findByCardNumber(String cardNumber);

}
