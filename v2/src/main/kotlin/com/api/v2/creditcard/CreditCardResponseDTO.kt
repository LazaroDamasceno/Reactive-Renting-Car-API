package com.api.v2.creditcard

import java.time.LocalDate

data class c(
    val ownerName: String,
    val cardNumber: String,
    val flag: String,
    val cvc: String,
    val dueDate: LocalDate,
    val addedAt: String
)
