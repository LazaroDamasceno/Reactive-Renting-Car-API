package com.api.v1.car.services;

import com.api.v1.car.annotations.VIN;
import com.api.v1.car.domain.CarRepository;
import com.api.v1.car.exceptions.CarEntityNotExistException;
import com.api.v1.car.utils.CarFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
                    if (!hasElements) return Mono.error(CarEntityNotExistException::new);
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
