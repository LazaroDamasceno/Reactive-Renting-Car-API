package com.api.v1.creditcar.services;

import com.api.v1.creditcar.domain.CreditCard;
import com.api.v1.creditcar.dtos.CreditCardResponseDto;
import reactor.core.publisher.Mono;

public interface CreditCardRegistrationService {

    Mono<CreditCardResponseDto> register(CreditCard creditCard);

}
