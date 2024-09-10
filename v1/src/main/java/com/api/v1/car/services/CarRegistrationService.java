package com.api.v1.car.services;

import com.api.v1.car.dtos.CarRegistrationRequestDto;
import com.api.v1.car.dtos.CarResponseDto;
import reactor.core.publisher.Mono;

public interface CarRegistrationService {

    Mono<CarResponseDto> register(CarRegistrationRequestDto requestDto);

}
