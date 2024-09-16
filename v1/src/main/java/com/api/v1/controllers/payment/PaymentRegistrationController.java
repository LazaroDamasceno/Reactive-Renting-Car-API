package com.api.v1.controllers.payment;

import com.api.v1.dtos.payment.PaymentResponseDto;
import com.api.v1.services.payment.PaymentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/payments")
public class PaymentRegistrationController {

    @Autowired
    private PaymentRegistrationService service;

    @PostMapping("{ssn}/{vin}/{cardNumber}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<PaymentResponseDto> register(
            @PathVariable String ssn,
            @PathVariable String vin,
            @PathVariable String cardNumber
    ) {
        return service.register(ssn, vin, cardNumber);
    }

}
