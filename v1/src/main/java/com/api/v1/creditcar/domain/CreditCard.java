package com.api.v1.creditcar.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Document(collection = "v1_credit_cards")
public record CreditCard(
    String ownerName,
    String cardNumber,
    String flag,
    String cvc,
    LocalDate dueDate,
    String addedAt
) {

    public CreditCard(
            String ownerName,
            String cardNumber,
            String flag,
            String cvc,
            LocalDate dueDate
    ) {
        this(
                ownerName,
                cardNumber,
                flag,
                cvc,
                dueDate,
                ZonedDateTime.now().toString()
        );
    }

}
