package com.api.v1.car.utils;


import com.api.v1.car.annotations.VIN;
import com.api.v1.car.domain.Car;
import com.api.v1.car.domain.CarRepository;
import com.api.v1.car.exceptions.CarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CarFinderUtilImpl implements CarFinderUtil {

    @Autowired
    private CarRepository repository;

    @Override
    public Mono<Car> find(@VIN String vin) {
        return repository
                .findAll()
                .filter(e -> e.getVin().equals(vin))
                .singleOrEmpty()
                .switchIfEmpty(Mono.error(new CarNotFoundException(vin)));
    }

}
