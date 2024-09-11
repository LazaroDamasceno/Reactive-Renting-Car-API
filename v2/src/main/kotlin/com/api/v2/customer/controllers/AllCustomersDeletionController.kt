package com.api.v2.customer.controllers

import com.api.v2.customer.services.AllCustomersDeletionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/customers")
class AllCustomersDeletionController {

    @Autowired
    private lateinit var service: AllCustomersDeletionService

    @DeleteMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    suspend fun deleteBySsn(@PathVariable ssn: String) {
        return service.deleteBySsn(ssn)
    }

    @DeleteMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    suspend fun deleteAll() {
        return service.deleteAll();
    }

}