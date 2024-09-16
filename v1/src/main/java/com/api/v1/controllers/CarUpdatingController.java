package com.api.v1.controllers;

import com.api.v1.annotations.car.VIN;
import com.api.v1.dtos.car.CarResponseDto;
import com.api.v1.dtos.car.CarUpdatingRequestDto;
import com.api.v1.services.car.CarUpdatingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/cars")
public class CarUpdatingController {

    @Autowired
    private CarUpdatingService service;

    @PutMapping("{vin}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<CarResponseDto> update(
            @VIN @PathVariable String vin,
            @Valid @RequestBody CarUpdatingRequestDto requestDto
    ) {
        return service.update(vin, requestDto);
    }

}
