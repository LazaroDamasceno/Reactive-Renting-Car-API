package com.api.v2.rent;

import com.api.v2.car.domain.Car
import com.api.v2.customer.domain.Customer
import com.api.v2.payment.Payment
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.UUID;

@Document(collection = "v1_rents")
class Rent(
    @Id
    val id: UUID,
    val car: Car,
    val customer: Customer,
    val payment: Payment,
    val rentedAt: String,
    val dueDate: String

) {

    var returnedAt: String? = null

    fun markAsReturned() {
        returnedAt = ZonedDateTime.now().toString();
    }

}
