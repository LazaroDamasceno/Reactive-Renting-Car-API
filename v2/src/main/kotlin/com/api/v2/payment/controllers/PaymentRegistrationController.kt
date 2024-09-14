package com.api.v2.payment.controllers

import com.api.v2.payment.dtos.PaymentResponseDto
import com.api.v2.payment.services.PaymentRegistrationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v2/payments")
class PaymentRegistrationController {

    @Autowired
    private lateinit var service: PaymentRegistrationService

    @PostMapping("{ssn}/{vin}/{cardNumber}")
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun register(
        @PathVariable ssn: String,
        @PathVariable vin: String,
        @PathVariable cardNumber: String
    ): PaymentResponseDto {
        return service.register(ssn, vin, cardNumber)
    }


}