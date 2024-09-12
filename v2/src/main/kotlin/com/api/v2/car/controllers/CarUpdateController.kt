package com.api.v2.car.controllers

import com.api.v2.car.dtos.CarResponseDto
import com.api.v2.car.dtos.CarUpdateRequestDto
import com.api.v2.car.services.CarUpdateService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/cars")
private class CarUpdateController {

    @Autowired
    private lateinit var service: CarUpdateService

    @PutMapping("{vin}")
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun update(
        @PathVariable vin: String,
        @RequestBody requestDto: @Valid CarUpdateRequestDto
    ): CarResponseDto {
        return service.update(vin, requestDto)
    }

}