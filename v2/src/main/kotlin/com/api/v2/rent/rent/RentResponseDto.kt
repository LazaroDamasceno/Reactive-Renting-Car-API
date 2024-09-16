package com.api.v2.rent.rent

import com.api.v2.car.domain.Car
import com.api.v2.customer.domain.Customer
import com.api.v2.customer.dtos.CustomerResponseDto
import com.api.v2.payment.domain.Payment
import java.math.BigInteger

data class RentResponseDto(
    val orderNumber: BigInteger,
    val customer: CustomerResponseDto,
    val car: Car,
    val payment: Payment,
    val rentedAt: String
)
