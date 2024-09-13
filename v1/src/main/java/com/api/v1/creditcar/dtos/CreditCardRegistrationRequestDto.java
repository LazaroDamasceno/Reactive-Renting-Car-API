package com.api.v1.creditcar.dtos;

import java.time.LocalDate;

public record CreditCardRegistrationRequestDto(
        String ownerName,
        String cardNumber,
        String flag,
        String cvc,
        LocalDate dueDate
) {
}
