package com.api.v1.controllers;

import com.api.v1.services.rent.AllRentsDeletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/rents")
public class AllRentsDeletionController {

    @Autowired
    private AllRentsDeletionService service;

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAll() {
        return service.deleteAll();
    }

    @DeleteMapping("{orderNumber}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteByOrderNumber(@PathVariable String orderNumber) {
        return service.deleteByOrderNumber(orderNumber);
    }
}
