package com.api.v1.utils.car;


import com.api.v1.annotations.car.VIN;
import com.api.v1.domain.car.Car;
import com.api.v1.domain.car.CarRepository;
import com.api.v1.exceptions.car.CarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CarFinderUtil {

    @Autowired
    private CarRepository repository;

    public Mono<Car> find(@VIN String vin) {
        return repository
                .findAll()
                .filter(e -> e.getVin().equals(vin))
                .singleOrEmpty()
                .switchIfEmpty(Mono.error(new CarNotFoundException(vin)));
    }

}
