package com.api.v1.services;

import com.api.v1.dtos.PaymentResponseDto;
import reactor.core.publisher.Mono;

public interface PaymentRegistrationService {

    Mono<PaymentResponseDto> register(String ssn, String vin, String cardNumber);

}
