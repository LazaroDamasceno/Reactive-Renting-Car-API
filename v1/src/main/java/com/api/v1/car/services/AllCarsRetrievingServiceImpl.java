package com.api.v1.car.services;

import com.api.v1.car.annotations.VIN;
import com.api.v1.car.domain.CarRepository;
import com.api.v1.car.dtos.CarResponseDto;
import com.api.v1.car.exceptions.EmptyCarEntityException;
import com.api.v1.car.mappers.CarResponseMapper;
import com.api.v1.car.utils.CarFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
                .flatMap(CarResponseMapper::mapToMono);
    }

    @Override
    public Flux<CarResponseDto> findAll() {
        return repository
                .findAll()
                .hasElements()
                .flatMapMany(hasElements -> {
                    if (!hasElements) return Mono.error(EmptyCarEntityException::new);
                    return CarResponseMapper.mapToFLux(repository.findAll());
                });
    }

}
