package com.api.v2.creditcard.controllers

import com.api.v2.creditcard.services.AllCreditCardDeletionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/credit-cards")
class AllCreditCardDeletionController {

    @Autowired
    private lateinit var service: AllCreditCardDeletionService

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    suspend fun deleteAll() {
        return service.deleteAll()
    }

    @DeleteMapping("by-card-number/{cardNumber}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    suspend fun deleteByCardNumber(@PathVariable cardNumber: String) {
        return service.deleteByCardNumber(cardNumber)
    }

}