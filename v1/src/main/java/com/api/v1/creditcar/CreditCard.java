package com.api.v1.creditcar;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "v1_credit_cards")
public record CreditCard(
    String ownerName,
    String cardNumber,
    String flag,
    String cvc,
    LocalDate dueDate,
    String addedAt
) {}
