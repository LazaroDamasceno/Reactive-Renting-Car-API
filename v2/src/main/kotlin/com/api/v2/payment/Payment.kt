package com.api.v2.payment

import com.api.v2.car.domain.Car
import com.api.v2.creditcard.domain.CreditCard
import com.api.v2.customer.domain.Customer
import org.springframework.data.mongodb.core.mapping.Document
import java.time.ZonedDateTime

@Document(collection = "v2_payments")
data class Payment(
    val customer: Customer,
    val car: Car,
    val creditCard: CreditCard,
    val paidAt: String
) {

    constructor(
        customer: Customer,
        car: Car,
        creditCard: CreditCard
    ): this (
        customer,
        car,
        creditCard,
        ZonedDateTime.now().toString()
    )

}
