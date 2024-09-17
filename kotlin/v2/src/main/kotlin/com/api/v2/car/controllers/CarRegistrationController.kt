package com.api.v2.car.controllers

import com.api.v2.car.domain.Car
import com.api.v2.car.services.CarRegistrationService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v2/cars")
class CarRegistrationController {

    @Autowired
    private lateinit var service: CarRegistrationService

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun register(@RequestBody car: @Valid Car) {
        return service.register(car)
    }

}