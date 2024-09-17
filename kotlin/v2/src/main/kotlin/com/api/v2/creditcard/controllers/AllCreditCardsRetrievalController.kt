package com.api.v2.creditcard.controllers

import com.api.v2.creditcard.dtos.CreditCardResponseDto
import com.api.v2.creditcard.services.AllCreditCardsRetrievalService
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v2/credit-cards")
class AllCreditCardsRetrievalController {

    @Autowired
    private lateinit var service: AllCreditCardsRetrievalService

    @GetMapping("{cardNumber}")
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun findByCardNumber(@PathVariable cardNumber: String): CreditCardResponseDto {
        return service.findByCardNumber(cardNumber)
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun findAll(): Flow<CreditCardResponseDto> {
        return service.findAll()
    }

}