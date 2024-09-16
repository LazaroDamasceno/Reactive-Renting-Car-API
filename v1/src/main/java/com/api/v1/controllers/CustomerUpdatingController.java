package com.api.v1.controllers;

import com.api.v1.annotations.customer.SSN;
import com.api.v1.dtos.customer.CustomerResponseDto;
import com.api.v1.dtos.customer.CustomerUpdatingRequestDto;
import com.api.v1.services.customer.CustomerUpdatingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerUpdatingController {

    @Autowired
    private CustomerUpdatingService updatingService;

    @PutMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    Mono<CustomerResponseDto> update(
            @SSN @PathVariable String ssn,
            @RequestBody @Valid CustomerUpdatingRequestDto requestDto
    ) {
        return updatingService.update(ssn, requestDto);
    }

}
