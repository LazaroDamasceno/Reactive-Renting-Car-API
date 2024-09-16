package com.api.v1.controllers;

import com.api.v1.dtos.car.CarRegistrationRequestDto;
import com.api.v1.dtos.car.CarResponseDto;
import com.api.v1.services.car.CarRegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/cars")
public class CarRegistrationController {

    @Autowired
    private CarRegistrationService service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CarResponseDto> register(@RequestBody @Valid CarRegistrationRequestDto requestDto) {
        return service.register(requestDto);
    }

}
