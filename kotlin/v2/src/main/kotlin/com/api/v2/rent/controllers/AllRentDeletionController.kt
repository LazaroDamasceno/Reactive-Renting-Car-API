package com.api.v2.rent.controllers

import com.api.v2.rent.service.AllRentsDeletionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v2/rents")
class AllRentDeletionController {

    @Autowired
    private lateinit var service: AllRentsDeletionService

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    suspend fun deleteAll() {
        return service.deleteAll()
    }

    @DeleteMapping("{orderNumber}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    suspend fun deleteByOrderNumber(@PathVariable orderNumber: String) {
        return service.deleteByOrderNumber(orderNumber)
    }

}