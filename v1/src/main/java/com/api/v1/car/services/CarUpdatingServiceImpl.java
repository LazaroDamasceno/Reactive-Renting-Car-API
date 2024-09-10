package com.api.v1.car.services;

import com.api.v1.car.annotations.VIN;
import com.api.v1.car.domain.CarRepository;
import com.api.v1.car.dtos.CarResponseDto;
import com.api.v1.car.dtos.CarUpdatingRequestDto;
import com.api.v1.car.exceptions.DuplicatedPlateNumberException;
import com.api.v1.car.mappers.CarResponseMapper;
import com.api.v1.car.utils.CarFinderUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class CarUpdatingServiceImpl implements CarUpdatingService {

    @Autowired
    private CarFinderUtil carFinderUtil;

    @Autowired
    private CarRepository repository;

    @Override
    public Mono<CarResponseDto> update(@VIN String vin, @Valid CarUpdatingRequestDto requestDto) {
        return carFinderUtil
                .find(vin)
                .flatMap(car -> {
                    if (car.getPlateNumbers().contains(requestDto.plateNumber())) {
                        return Mono.error(new DuplicatedPlateNumberException(requestDto.plateNumber()));
                    }
                    car.update(requestDto);
                    car.getPlateNumbers().add(requestDto.plateNumber());
                    return repository.save(car);
                }).flatMap(CarResponseMapper::mapToMono);
    }

}
