package com.api.v1.services.creditcard;

import com.api.v1.dtos.creditcard.CreditCardResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AllCreditCardsRetrievalService {

    Flux<CreditCardResponseDto> findAll();
    Mono<CreditCardResponseDto> findByCardNumber(String cardNumber);

}
