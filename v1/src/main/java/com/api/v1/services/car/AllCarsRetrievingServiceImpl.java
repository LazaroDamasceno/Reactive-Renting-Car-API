package com.api.v1.services.car;

import com.api.v1.annotations.car.VIN;
import com.api.v1.domain.car.CarRepository;
import com.api.v1.dtos.car.CarResponseDto;
import com.api.v1.exceptions.car.EmptyCarEntityException;
import com.api.v1.mappers.car.CarResponseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.utils.car.CarFinderUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class AllCarsRetrievingServiceImpl implements AllCarsRetrievingService {

    @Autowired
    private CarFinderUtil carFinderUtil;

    @Autowired
    private CarRepository repository;

    @Override
    public Mono<CarResponseDto> findByVin(@VIN String vin) {
        return carFinderUtil
                .find(vin)
                .flatMap(e -> Mono.just(new CarResponseMapper(e).mapToDto()));
    }

    @Override
    public Flux<CarResponseDto> findAll() {
        return repository
                .findAll()
                .hasElements()
                .flatMapMany(hasElements -> {
                    if (!hasElements) return Mono.error(EmptyCarEntityException::new);
                    return repository.findAll().flatMap(e -> Flux.just(new CarResponseMapper(e).mapToDto()));
                });
    }

}
