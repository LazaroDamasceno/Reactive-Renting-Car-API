package com.api.v2.creditcard.domain

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.ZonedDateTime

@Document(collection = "v1_credit_cards")
data class CreditCard(
    val ownerName: String,
    val cardNumber: String,
    val flag: String,
    val cvc: String,
    val dueDate: LocalDate,
    val addedAt: String
) {

    constructor(
        ownerName: String,
        cardNumber: String,
        flag: String,
        cvc: String,
        dueDate: LocalDate
    ) : this(
        ownerName,
        cardNumber,
        flag,
        cvc,
        dueDate,
        ZonedDateTime.now().toString()
    )

}
