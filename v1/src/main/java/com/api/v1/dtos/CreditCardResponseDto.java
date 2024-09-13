package com.api.v1.dtos;

import java.time.LocalDate;

public record CreditCardResponseDto(
        String cardNumber,
        String flag,
        LocalDate dueDate
) {
}
