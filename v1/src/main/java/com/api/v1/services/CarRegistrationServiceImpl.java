package com.api.v1.services;

import com.api.v1.builders.CarBuilder;
import com.api.v1.domain.Car;
import com.api.v1.domain.CarRepository;
import com.api.v1.dtos.CarRegistrationRequestDto;
import com.api.v1.dtos.CarResponseDto;
import com.api.v1.exceptions.DuplicatedVinException;
import com.api.v1.mappers.CarResponseMapper;
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
                    }).flatMap(e -> Mono.just(new CarResponseMapper(e).mapToDto()));
                });
    }

}
