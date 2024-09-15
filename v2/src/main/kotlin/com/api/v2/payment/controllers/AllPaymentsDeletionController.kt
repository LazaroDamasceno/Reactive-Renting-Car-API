package com.api.v2.payment.controllers

import AllPaymentsDeletionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*

@RequestMapping("api/v2/payments")
@RestController
class AllPaymentsDeletionController {

    @Autowired
    lateinit var service: AllPaymentsDeletionService

    @ResponseStatus(value = NO_CONTENT)
    @DeleteMapping
    suspend fun deleteAll() {
        return service.deleteAll()
    }

    @ResponseStatus(value = NO_CONTENT)
    @DeleteMapping("{orderNumber}")
    suspend fun deleteByOrderNumber(@PathVariable orderNumber: String) {
        return service.deleteByOrderNumber(orderNumber)
    }

}