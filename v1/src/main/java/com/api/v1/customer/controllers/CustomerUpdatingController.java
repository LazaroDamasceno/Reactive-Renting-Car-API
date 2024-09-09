package com.api.v1.customer.controllers;

import com.api.v1.customer.annotations.SSN;
import com.api.v1.customer.dtos.CustomerResponseDto;
import com.api.v1.customer.dtos.CustomerUpdatingRequestDto;
import com.api.v1.customer.services.CustomerUpdatingService;
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
