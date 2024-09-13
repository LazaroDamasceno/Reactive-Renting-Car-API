package com.api.v1.services;

import com.api.v1.dtos.CarRegistrationRequestDto;
import com.api.v1.dtos.CarResponseDto;
import reactor.core.publisher.Mono;

public interface CarRegistrationService {

    Mono<CarResponseDto> register(CarRegistrationRequestDto requestDto);

}
