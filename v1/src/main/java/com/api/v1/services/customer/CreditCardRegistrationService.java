package com.api.v1.services.customer;

import com.api.v1.dtos.creditcard.CreditCardRegistrationRequestDto;
import com.api.v1.dtos.creditcard.CreditCardResponseDto;
import reactor.core.publisher.Mono;

public interface CreditCardRegistrationService {

    Mono<CreditCardResponseDto> register(CreditCardRegistrationRequestDto requestDto);

}
