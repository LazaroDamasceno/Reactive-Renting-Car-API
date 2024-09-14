package com.api.v2.payment.controllers

import com.api.v2.payment.dtos.PaymentResponseDto
import com.api.v2.payment.services.AllPaymentsRetrievalService
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/payments")
class AllPaymentsRetrievalController {

    @Autowired
    private lateinit var service: AllPaymentsRetrievalService

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun findAll(): Flow<PaymentResponseDto> {
        return service.findAll()
    }

    @GetMapping("{orderNumber}")
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun findByOrderNumber(@PathVariable orderNumber: String): PaymentResponseDto {
        return service.findByOrderNumber(orderNumber)
    }

}