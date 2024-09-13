package com.api.v2.payment.dtos

import com.api.v2.car.dtos.CarResponseDto
import com.api.v2.creditcard.dtos.CreditCardResponseDto
import com.api.v2.customer.dtos.CustomerResponseDto

data class PaymentResponseDto(
    val customer: CustomerResponseDto,
    val car: CarResponseDto,
    val creditCard: CreditCardResponseDto,
    val paidAt: String
)