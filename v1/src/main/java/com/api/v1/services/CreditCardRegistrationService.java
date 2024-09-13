package com.api.v1.services;

import com.api.v1.dtos.CreditCardRegistrationRequestDto;
import com.api.v1.dtos.CreditCardResponseDto;
import reactor.core.publisher.Mono;

public interface CreditCardRegistrationService {

    Mono<CreditCardResponseDto> register(CreditCardRegistrationRequestDto requestDto);

}
