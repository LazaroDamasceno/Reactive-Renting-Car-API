package com.api.v2.creditcard

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document(collection = "v1_credit_cards")
data class CreditCard(
    val ownerName: String,
    val cardNumber: String,
    val flag: String,
    val cvc: String,
    val dueDate: LocalDate,
    val addedAt: String
)
