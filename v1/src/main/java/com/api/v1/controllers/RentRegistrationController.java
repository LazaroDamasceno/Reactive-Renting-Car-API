package com.api.v1.controllers;

import com.api.v1.annotations.customer.SSN;
import com.api.v1.annotations.car.VIN;
import com.api.v1.dtos.rent.RentResponseDto;
import com.api.v1.services.rent.RentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/rents")
public class RentRegistrationController {

    @Autowired
    private RentRegistrationService service;

    @PostMapping("{ssn}/{vin}/{paymentOrderNumber}/{days}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<RentResponseDto> register(
            @PathVariable @SSN String ssn,
            @PathVariable @VIN String vin,
            @PathVariable String paymentOrderNumber,
            @PathVariable int days
    ) {
        return service.register(ssn, vin, paymentOrderNumber, days);
    }
}
