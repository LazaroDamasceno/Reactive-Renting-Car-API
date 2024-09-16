package com.api.v2.rent.controllers

import com.api.v2.rent.dtos.RentResponseDto
import com.api.v2.rent.service.AllRentsRetrievalService
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v2/rents")
class AllRentRetrievalController {

    @Autowired
    private lateinit var service: AllRentsRetrievalService

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun findAll(): Flow<RentResponseDto> {
        return service.findAll()
    }

    @DeleteMapping("{orderNumber}")
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun findByOrderNumber(@PathVariable orderNumber: String): RentResponseDto {
        return service.findByOrderNumber(orderNumber)
    }

}