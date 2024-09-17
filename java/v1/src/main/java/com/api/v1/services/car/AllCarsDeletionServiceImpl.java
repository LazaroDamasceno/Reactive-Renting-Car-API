package com.api.v1.services.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.annotations.car.VIN;
import com.api.v1.domain.car.CarRepository;
import com.api.v1.exceptions.car.EmptyCarEntityException;
import com.api.v1.utils.car.CarFinderUtil;

import reactor.core.publisher.Mono;

@Service
class AllCarsDeletionServiceImpl implements AllCarsDeletionService {

    @Autowired
    private CarRepository repository;

    @Autowired
    private CarFinderUtil carFinderUtil;

    @Override
    public Mono<Void> deleteAll() {
        return repository
                .findAll()
                .hasElements()
                .flatMap(hasElements -> {
                    if (!hasElements) return Mono.error(EmptyCarEntityException::new);
                    return repository.deleteAll();
                });
    }

    @Override
    public Mono<Void> deleteByVin(@VIN String vin) {
        return carFinderUtil
                .find(vin)
                .flatMap(car -> repository.delete(car));
    }

}
