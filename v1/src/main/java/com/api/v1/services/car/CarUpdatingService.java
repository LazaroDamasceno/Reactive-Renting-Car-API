package com.api.v1.services.car;

import com.api.v1.dtos.car.CarResponseDto;
import com.api.v1.dtos.car.CarUpdatingRequestDto;
import reactor.core.publisher.Mono;

public interface CarUpdatingService {

    Mono<CarResponseDto> update(String vin, CarUpdatingRequestDto requestDto);

}
