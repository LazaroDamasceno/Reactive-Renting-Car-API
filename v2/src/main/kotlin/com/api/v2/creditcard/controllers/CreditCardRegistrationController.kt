package com.api.v2.creditcard.controllers

import com.api.v2.creditcard.services.CreditCardRegistrationService
import com.api.v2.creditcard.domain.CreditCard
import com.api.v2.creditcard.dtos.CreditCardResponseDto
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/credit-cards")
class CreditCardRegistrationController {

    @Autowired
    private lateinit var service: CreditCardRegistrationService

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun register(@RequestBody creditCard: @Valid CreditCard): CreditCardResponseDto {
        return service.register(creditCard)
    }

}