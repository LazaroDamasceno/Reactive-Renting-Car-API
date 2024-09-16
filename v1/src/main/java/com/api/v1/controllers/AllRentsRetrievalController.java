package com.api.v1.controllers;

import com.api.v1.dtos.rent.RentResponseDto;
import com.api.v1.services.rent.AllRentsRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/rents")
public class AllRentsRetrievalController {

    @Autowired
    private AllRentsRetrievalService service;

    @GetMapping("{orderNumber}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<RentResponseDto> findByOrderNumber(@PathVariable String orderNumber) {
        return service.findByOrderNumber(orderNumber);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<RentResponseDto> findAll() {
        return service.findAll();
    }

}
