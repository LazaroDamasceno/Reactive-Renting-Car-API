package com.api.v1.creditcar.dtos;

import java.time.LocalDate;

public record CreditCardResponseDto(
        String cardNumber,
        String flag,
        LocalDate dueDate
) {
}
