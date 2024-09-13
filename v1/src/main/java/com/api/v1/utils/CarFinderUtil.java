package com.api.v1.utils;


import com.api.v1.annotations.VIN;
import com.api.v1.domain.Car;
import com.api.v1.domain.CarRepository;
import com.api.v1.exceptions.CarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CarFinderUtil implements CarFinderUtil {

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
