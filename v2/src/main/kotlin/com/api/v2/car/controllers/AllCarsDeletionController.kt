package com.api.v2.car.controllers

import com.api.v2.car.services.AllCarsDeletionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/cars")
class AllCarsDeletionController {

    @Autowired
    private lateinit var service: AllCarsDeletionService

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    suspend fun deleteAll() {
        return service.deleteAll()
    }

    @DeleteMapping("{vin}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    suspend fun deleteByVin(@PathVariable vin: String) {
        return service.deleteByVin(vin)
    }

}