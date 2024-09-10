package com.api.v1.car.mappers;

import com.api.v1.car.domain.Car;
import com.api.v1.car.dtos.CarResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CarResponseMapper {

    public static Mono<CarResponseDto> mapToMono(Car car) {
        return Mono.just(mapToDto(car));
    }

    public static Flux<CarResponseDto> mapToFLux(Flux<Car> cars) {
        return cars.flatMap(car -> Flux.just(mapToDto(car)));
    }

    private static CarResponseDto mapToDto(Car car) {
        return new CarResponseDto(
                car.getMake(),
                car.getModel(),
                car.getProductionYear(),
                car.getVin(),
                car.getProductionYear(),
                car.getAddedAt(),
                car.getUpdatedAt()
        );
    }

}
