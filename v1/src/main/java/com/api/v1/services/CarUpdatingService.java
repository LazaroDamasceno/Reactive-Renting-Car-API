package com.api.v1.services;

import com.api.v1.dtos.CarResponseDto;
import com.api.v1.dtos.CarUpdatingRequestDto;
import reactor.core.publisher.Mono;

public interface CarUpdatingService {

    Mono<CarResponseDto> update(String vin, CarUpdatingRequestDto requestDto);

}
