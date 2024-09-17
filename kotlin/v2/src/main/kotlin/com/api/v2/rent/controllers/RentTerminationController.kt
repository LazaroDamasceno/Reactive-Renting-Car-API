package com.api.v2.rent.controllers

import com.api.v2.rent.service.RentTerminationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v2/rents")
class RentTerminationController {

    @Autowired
    private lateinit var service: RentTerminationService

    @ResponseStatus(value = HttpStatus.OK)
    @PatchMapping("{orderNumber}")
    suspend fun terminate(@PathVariable orderNumber: String) {
        return service.terminate(orderNumber)
    }

}