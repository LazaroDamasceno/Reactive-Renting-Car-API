package com.api.v2.car

import java.time.ZonedDateTime
import java.util.*

class CarBuilder {

    private val id: UUID = UUID.randomUUID()
    private lateinit var vin: String
    private lateinit var model: String
    private lateinit var productionYear: String
    private lateinit var make: String
    private lateinit var plateNumber: String
    private val createdAt: String = ZonedDateTime.now().toString()

    companion object {
        fun create(): CarBuilder {
            return CarBuilder()
        }
    }

    fun fromDto(requestDto: CarRegistrationRequestDto): CarBuilder {
        vin = requestDto.vin
        model = requestDto.model
        productionYear = requestDto.productionYear
        make = requestDto.make
        plateNumber = requestDto.plateNumber
        return this
    }

    fun build(): Car {
        return Car(
            id,
            vin,
            model,
            productionYear,
            make,
            plateNumber,
            createdAt
        )
    }

}