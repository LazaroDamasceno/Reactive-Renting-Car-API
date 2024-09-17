package com.api.v1.controllers.car;

import com.api.v1.annotations.car.VIN;
import com.api.v1.dtos.car.CarResponseDto;
import com.api.v1.services.car.AllCarsRetrievingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/cars")
public class AllCarsRetrievingController {

    @Autowired
    private AllCarsRetrievingService service;

    @GetMapping("{vin}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<CarResponseDto> findByVin(@VIN @PathVariable String vin) {
        return service.findByVin(vin);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<CarResponseDto> findAll() {
        return service.findAll();
    }

}
