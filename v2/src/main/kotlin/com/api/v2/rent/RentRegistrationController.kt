package com.api.v2.rent

import com.api.v2.rent.dtos.RentResponseDto
import com.api.v2.rent.service.RentRegistrationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/rents")
class RentRegistrationController {

    @Autowired
    private lateinit var service: RentRegistrationService

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("{ssn}/{vin}/{paymentOrderNumber}")
    suspend fun register(
        @PathVariable ssn: String,
        @PathVariable vin: String,
        @PathVariable paymentOrderNumber: String
    ): RentResponseDto {
        return service.register(ssn, vin, paymentOrderNumber)
    }

}