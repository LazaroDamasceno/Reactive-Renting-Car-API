package com.api.v2.rent.dtos

import com.api.v2.car.dtos.CarResponseDto
import com.api.v2.customer.dtos.CustomerResponseDto
import com.api.v2.payment.dtos.PaymentResponseDto
import java.math.BigInteger

data class RentResponseDto(
    val orderNumber: BigInteger,
    val customer: CustomerResponseDto,
    val car: CarResponseDto,
    val payment: PaymentResponseDto,
    val rentedAt: String
)
