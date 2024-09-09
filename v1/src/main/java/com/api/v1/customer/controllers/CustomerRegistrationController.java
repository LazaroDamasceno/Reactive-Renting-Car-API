package com.api.v1.customer.controllers;

import com.api.v1.customer.dtos.CustomerRegistrationRequestDto;
import com.api.v1.customer.dtos.CustomerResponseDto;
import com.api.v1.customer.services.CustomerRegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerRegistrationController {

    @Autowired
    private CustomerRegistrationService service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CustomerResponseDto> register(@Valid @RequestBody CustomerRegistrationRequestDto request) {
        return service.register(request);
    }

}
