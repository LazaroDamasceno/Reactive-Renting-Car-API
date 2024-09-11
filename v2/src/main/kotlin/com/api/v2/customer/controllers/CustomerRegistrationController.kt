package com.api.v2.customer.controllers

import com.api.v2.customer.services.CustomerRegistrationService
import com.api.v2.dtos.CustomerRegistrationRequestDto
import com.api.v2.customer.dtos.CustomerResponseDto
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/customers")
class CustomerRegistrationController {

    @Autowired
    private lateinit var service: com.api.v2.customer.services.CustomerRegistrationService

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun register(@RequestBody requestDto: @Valid CustomerRegistrationRequestDto): com.api.v2.customer.dtos.CustomerResponseDto {
        return service.register(requestDto)
    }

}