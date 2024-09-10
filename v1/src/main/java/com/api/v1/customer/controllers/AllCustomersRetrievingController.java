package com.api.v1.customer.controllers;

import com.api.v1.customer.annotations.SSN;
import com.api.v1.customer.dtos.CustomerResponseDto;
import com.api.v1.customer.services.AllCustomersRetrievingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/customers")
public class AllCustomersRetrievingController {
    
    @Autowired
    private AllCustomersRetrievingService service;

    @GetMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<CustomerResponseDto> findBySsn(@SSN @PathVariable String ssn) {
        return service.findBySsn(ssn);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<CustomerResponseDto> findAll() {
        return service.findAll();
    }

}
