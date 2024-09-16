package com.api.v1.dtos.creditcard;

import java.time.LocalDate;

public record CreditCardResponseDto(
        String cardNumber,
        String flag,
        LocalDate dueDate
) {
}
