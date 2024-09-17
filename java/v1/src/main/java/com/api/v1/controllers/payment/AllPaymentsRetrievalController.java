package com.api.v1.controllers.payment;

import com.api.v1.dtos.payment.PaymentResponseDto;
import com.api.v1.services.payment.AllPaymentsRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/v1/payments")
@RestController
public class AllPaymentsRetrievalController {

    @Autowired
    private AllPaymentsRetrievalService service;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<PaymentResponseDto> findAll() {
        return service.findAll();
    }

    @GetMapping("{orderNumber}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<PaymentResponseDto> findByOrderNumber(@PathVariable String orderNumber) {
        return service.findByOrderNumber(orderNumber);
    }

}
