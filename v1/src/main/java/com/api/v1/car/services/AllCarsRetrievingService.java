package com.api.v1.car.services;

import com.api.v1.car.dtos.CarResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AllCarsRetrievingService {

    Mono<CarResponseDto> findByVin(String vin);
    Flux<CarResponseDto> findAll();

}
