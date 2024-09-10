package com.api.v1.car.utils;

import com.api.v1.car.domain.Car;
import reactor.core.publisher.Mono;

public interface CarFinderUtil {

    Mono<Car> find(String vin);

}
