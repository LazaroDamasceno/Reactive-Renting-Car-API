package com.api.v2

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/customers")
class CustomerUpdateController {

    @Autowired
    private lateinit var service: CustomerUpdateService

    @PutMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun update(
        @PathVariable ssn: String,
        @RequestBody requestDto: @Valid CustomerUpdateRequestDto
    ): CustomerResponseDto {
        return service.update(ssn, requestDto)
    }

}