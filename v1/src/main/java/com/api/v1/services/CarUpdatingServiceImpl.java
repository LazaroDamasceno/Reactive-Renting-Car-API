package com.api.v1.services;

import com.api.v1.annotations.VIN;
import com.api.v1.domain.CarRepository;
import com.api.v1.dtos.CarResponseDto;
import com.api.v1.dtos.CarUpdatingRequestDto;
import com.api.v1.exceptions.DuplicatedPlateNumberException;
import com.api.v1.mappers.CarResponseMapper;
import com.api.v1.utils.CarFinderUtil;
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
                }).flatMap(e -> Mono.just(new CarResponseMapper(e).mapToDto()));
    }

}
