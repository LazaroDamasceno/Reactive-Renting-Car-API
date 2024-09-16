package com.api.v1.controllers;

import com.api.v1.annotations.customer.SSN;
import com.api.v1.services.customer.CustomerDeletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerDeletionController {

    @Autowired
    private CustomerDeletionService service;

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteAll() {
        return service.deleteAll();
    }

    @DeleteMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteBySsn(@SSN @PathVariable String ssn) {
        return service.deleteBySsn(ssn);
    }

}
