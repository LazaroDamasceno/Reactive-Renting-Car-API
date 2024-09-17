package com.api.v2.customer.controllers

import com.api.v2.customer.dtos.CustomerResponseDto
import com.api.v2.customer.services.AllCustomersRetrievalService
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v2/customers")
class AllCustomersRetrievalController {

    @Autowired
    private lateinit var service: AllCustomersRetrievalService

    @GetMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun findBySsn(@PathVariable ssn: String): CustomerResponseDto {
        return service.findBySsn(ssn)
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun findAll(): Flow<CustomerResponseDto> {
        return service.findAll()
    }

}