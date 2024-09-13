package com.api.v1.services;

import com.api.v1.annotations.VIN;
import com.api.v1.domain.CarRepository;
import com.api.v1.dtos.CarResponseDto;
import com.api.v1.exceptions.EmptyCarEntityException;
import com.api.v1.mappers.CarResponseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.utils.CarFinderUtil;

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
