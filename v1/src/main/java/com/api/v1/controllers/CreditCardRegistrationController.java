package com.api.v1.controllers;

import com.api.v1.dtos.CreditCardRegistrationRequestDto;
import com.api.v1.dtos.CreditCardResponseDto;
import com.api.v1.services.CreditCardRegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/credit-cards")
public class CreditCardRegistrationController {

    @Autowired
    private CreditCardRegistrationService service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CreditCardResponseDto> register(@Valid @RequestBody CreditCardRegistrationRequestDto requestDto) {
        return service.register(requestDto);
    }

}
