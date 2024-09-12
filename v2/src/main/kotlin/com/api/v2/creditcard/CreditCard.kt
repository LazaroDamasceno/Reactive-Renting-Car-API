package com.api.v2.creditcard

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "v1_credit_cards")
data class CreditCard(
    val ownerName: String,
    val cardNumber: String,
    val addedAt: String
)
