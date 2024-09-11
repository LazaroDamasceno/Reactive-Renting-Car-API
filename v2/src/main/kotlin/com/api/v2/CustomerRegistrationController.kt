package com.api.v2

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/v1/customers")
class CustomerRegistrationController {

    @Autowired
    lateinit var service: CustomerRegistrationService

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun register(@RequestBody requestDto: @Valid CustomerRegistrationRequestDto): Mono<CustomerResponseDto> {
        return service.register(requestDto)
    }

}