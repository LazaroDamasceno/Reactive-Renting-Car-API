package com.api.v1.creditcar.dtos;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public record CreditCarResponseDto(
        String ownerName,
        String cardNumber,
        String flag,
        String cvc,
        LocalDate dueDate,
        String addedAt
) {

    public CreditCarResponseDto(
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
