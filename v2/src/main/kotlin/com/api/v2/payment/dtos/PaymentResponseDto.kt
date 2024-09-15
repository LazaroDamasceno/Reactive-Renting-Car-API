package com.api.v2.payment.dtos

import com.api.v2.creditcard.dtos.CreditCardResponseDto
import java.math.BigInteger

data class PaymentResponseDto(
    val orderNumber: BigInteger,
    val creditCard: CreditCardResponseDto,
    val paidAt: String
)