package com.api.v1.services.car;

import com.api.v1.dtos.car.CarRegistrationRequestDto;
import com.api.v1.dtos.car.CarResponseDto;
import reactor.core.publisher.Mono;

public interface CarRegistrationService {

    Mono<CarResponseDto> register(CarRegistrationRequestDto requestDto);

}
