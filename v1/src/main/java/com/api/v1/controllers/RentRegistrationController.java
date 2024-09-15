package com.api.v1.controllers;

import com.api.v1.dtos.RentResponseDto;
import com.api.v1.services.RentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/rents")
public class RentRegistrationController {

    @Autowired
    private RentRegistrationService service;

    @PostMapping("{ssn}/{vin}/{paymentOrderNumber}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<RentResponseDto> register(
            @PathVariable String ssn,
            @PathVariable String vin,
            @PathVariable String paymentOrderNumber
    ) {
        return service.register(ssn, vin, paymentOrderNumber);
    }
}
