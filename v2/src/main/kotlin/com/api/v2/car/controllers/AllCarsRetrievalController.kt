package com.api.v2.car.controllers

import com.api.v2.car.dtos.CarResponseDto
import com.api.v2.car.services.AllCarsRetrievalService
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v2/cars")
class AllCarsRetrievalController {

    @Autowired
    private lateinit var service: AllCarsRetrievalService

    @GetMapping("{vin}")
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun findByVin(vin: String): CarResponseDto {
        return service.findByVin(vin)
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun findAll(): Flow<CarResponseDto> {
        return service.findAll()
    }

}