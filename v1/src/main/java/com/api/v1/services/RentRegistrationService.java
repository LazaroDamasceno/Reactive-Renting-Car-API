package com.api.v1.services;

import com.api.v1.dtos.RentResponseDto;
import reactor.core.publisher.Mono;

public interface RentRegistrationService {

    Mono<RentResponseDto> register(String ssn, String vin, String paymentOrderNumber, int days);

}
