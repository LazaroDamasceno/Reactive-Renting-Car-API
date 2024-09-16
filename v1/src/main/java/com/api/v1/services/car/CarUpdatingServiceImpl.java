package com.api.v1.services.car;

import com.api.v1.annotations.car.VIN;
import com.api.v1.domain.car.CarRepository;
import com.api.v1.dtos.car.CarResponseDto;
import com.api.v1.dtos.car.CarUpdatingRequestDto;
import com.api.v1.exceptions.car.DuplicatedPlateNumberException;
import com.api.v1.mappers.car.CarResponseMapper;
import com.api.v1.utils.car.CarFinderUtil;
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
