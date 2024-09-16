package com.api.v1.services.payment;

import com.api.v1.dtos.payment.PaymentResponseDto;
import reactor.core.publisher.Mono;

public interface PaymentRegistrationService {

    Mono<PaymentResponseDto> register(String ssn, String vin, String cardNumber);

}
