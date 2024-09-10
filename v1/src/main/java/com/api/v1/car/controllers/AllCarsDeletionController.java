package com.api.v1.car.controllers;

import com.api.v1.car.annotations.VIN;
import com.api.v1.car.exceptions.CarEntityNotExistException;
import com.api.v1.car.services.AllCarsDeletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/cars")
public class AllCarsDeletionController {

    @Autowired
    private AllCarsDeletionService service;

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAll() {
        return service.deleteAll();
    }

    @DeleteMapping("{vin}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteByVin(@VIN @PathVariable String vin) {
        return service.deleteByVin(vin);
    }

}
