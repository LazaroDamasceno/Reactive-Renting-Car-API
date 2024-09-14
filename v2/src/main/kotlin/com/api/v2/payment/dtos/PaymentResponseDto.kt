package com.api.v2.payment.dtos

import com.api.v2.car.dtos.CarResponseDto
import com.api.v2.creditcard.dtos.CreditCardResponseDto
import com.api.v2.customer.dtos.CustomerResponseDto
import java.math.BigInteger

data class PaymentResponseDto(
    val orderNumber: BigInteger,
    val customer: CustomerResponseDto,
    val car: CarResponseDto,
    val creditCard: CreditCardResponseDto,
    val paidAt: String
)