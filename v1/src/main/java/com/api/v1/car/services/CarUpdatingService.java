package com.api.v1.car.services;

import com.api.v1.car.dtos.CarResponseDto;
import com.api.v1.car.dtos.CarUpdatingRequestDto;
import reactor.core.publisher.Mono;

public interface CarUpdatingService {

    Mono<CarResponseDto> update(String vin, CarUpdatingRequestDto requestDto);

}
