package com.api.v1.car.services;

import com.api.v1.car.builders.CarBuilder;
import com.api.v1.car.domain.Car;
import com.api.v1.car.domain.CarRepository;
import com.api.v1.car.dtos.CarRegistrationRequestDto;
import com.api.v1.car.dtos.CarResponseDto;
import com.api.v1.car.exceptions.DuplicatedVinException;
import com.api.v1.car.mappers.CarResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class CarRegistrationServiceImpl implements CarRegistrationService {

    @Autowired
    private CarRepository repository;

    @Override
    public Mono<CarResponseDto> register(CarRegistrationRequestDto requestDto) {
        return repository
                .findAll()
                .filter(e -> e.getVin().equals(requestDto.vin()))
                .hasElements()
                .flatMap(exists -> {
                    if (exists) return Mono.error(new DuplicatedVinException(requestDto.vin()));
                    return Mono.defer(() -> {
                        Car car = CarBuilder.create().fromDto(requestDto).build();
                        car.getPlateNumbers().add(requestDto.plateNumber());
                        return repository.save(car);
                    }).flatMap(CarResponseMapper::mapToMono);
                });
    }

}
