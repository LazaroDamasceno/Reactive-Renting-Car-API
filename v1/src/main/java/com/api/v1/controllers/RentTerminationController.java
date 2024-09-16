package com.api.v1.controllers;

import com.api.v1.services.rent.RentTerminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/rents")
public class RentTerminationController {

    @Autowired
    private RentTerminationService service;

    @PatchMapping("{orderNumber}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> terminate(@PathVariable String orderNumber) {
        return service.terminate(orderNumber);
    }

}
