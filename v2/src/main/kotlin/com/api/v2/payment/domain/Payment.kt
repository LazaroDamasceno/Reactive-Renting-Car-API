package com.api.v2.payment.domain

import com.api.v2.car.domain.Car
import com.api.v2.creditcard.domain.CreditCard
import com.api.v2.customer.domain.Customer
import com.api.v2.payment.utils.PaymentOrderGeneratorUtil
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigInteger
import java.time.ZonedDateTime
import java.util.UUID

@Document(collection = "v2_payments")
data class Payment(
    @Id val id: UUID,
    val paymentOrder: BigInteger,
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
        UUID.randomUUID(),
        PaymentOrderGeneratorUtil.generate(),
        customer,
        car,
        creditCard,
        ZonedDateTime.now().toString()
    )

}
