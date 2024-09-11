package com.api.v2.customer.controllers

import com.api.v2.customer.dtos.CustomerResponseDto
import com.api.v2.customer.services.AllCustomerRetrieveService
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/customers")
class AllCustomerRetrieveController {

    @Autowired
    private lateinit var service: AllCustomerRetrieveService

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