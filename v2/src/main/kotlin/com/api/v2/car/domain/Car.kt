package com.api.v2.car.domain

import com.api.v2.car.dtos.CarUpdateRequestDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.ZonedDateTime
import java.util.UUID

@Document(collection = "v1_cars")
class Car(
    @Id
    val id: UUID,
    val vin: String,
    var model: String,
    var productionYear: String,
    var make: String,
    var plateNumber: String,
    val createdAt: String,
) {

    lateinit var updatedAt: String

    fun update(requestDto: CarUpdateRequestDto) {
        model = requestDto.model
        productionYear = requestDto.productionYear
        make = requestDto.make
        plateNumber = requestDto.plateNumber
        updatedAt = ZonedDateTime.now().toString()
    }

}