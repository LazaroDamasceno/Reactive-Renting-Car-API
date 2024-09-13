package com.api.v1.creditcar.controller;

import com.api.v1.creditcar.dtos.CreditCardResponseDto;
import com.api.v1.creditcar.services.AllCreditCardsRetrievalService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/credit-cars")
public class AllCreditCardsRetrievalController {

    @Autowired
    private AllCreditCardsRetrievalService service;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<CreditCardResponseDto> findAll() {
        return service.findAll();
    }

    @GetMapping("{cardNumber}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<CreditCardResponseDto> findByCardNumber(@Valid @PathVariable String cardNumber) {
        return service.findByCardNumber(cardNumber);
    }

}
