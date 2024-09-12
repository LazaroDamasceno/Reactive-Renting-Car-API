package com.api.v2.car

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
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

    lateinit var updateAt: String

    var plateNumbersUsed: Set<String> = mutableSetOf()

}