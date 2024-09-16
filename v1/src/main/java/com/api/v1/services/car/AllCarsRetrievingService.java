package com.api.v1.services.car;

import com.api.v1.dtos.car.CarResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AllCarsRetrievingService {

    Mono<CarResponseDto> findByVin(String vin);
    Flux<CarResponseDto> findAll();

}
