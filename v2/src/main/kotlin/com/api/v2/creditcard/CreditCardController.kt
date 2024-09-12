package com.api.v2.creditcard

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/credit-cards")
class CreditCardController {

    @Autowired
    private lateinit var service: CreditCardRegistrationService

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun register(@RequestBody creditCard: @Valid CreditCard): CreditCardResponseDTO {
        return service.register(creditCard)
    }

}