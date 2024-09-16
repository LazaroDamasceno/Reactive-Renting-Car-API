package com.api.v2.rent.domain

import com.api.v2.car.domain.Car
import com.api.v2.customer.domain.Customer
import com.api.v2.payment.domain.Payment
import com.api.v2.payment.utils.PaymentOrderGeneratorUtil
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigInteger
import java.time.ZonedDateTime
import java.util.*

@Document(collection = "v2_rents")
data class Rent(
    @Id val id: UUID,
    val orderNumber: BigInteger,
    val customer: Customer,
    val car: Car,
    val payment: Payment,
    val rentedAt: String
) {

    constructor(
        customer: Customer,
        car: Car,
        payment: Payment
    ) : this(
        UUID.randomUUID(),
        PaymentOrderGeneratorUtil.generate(),
        customer,
        car,
        payment,
        ZonedDateTime.now().toString()
    )

}