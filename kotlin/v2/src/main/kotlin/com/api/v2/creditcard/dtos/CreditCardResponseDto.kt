package com.api.v2.creditcard.dtos

import java.time.LocalDate

data class CreditCardResponseDto(
    val cardNumber: String,
    val flag: String,
    val dueDate: LocalDate
)
