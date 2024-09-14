package com.api.v1.dtos;

import com.api.v1.annotations.CVC;
import com.api.v1.annotations.CardNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreditCardRegistrationRequestDto(
        @NotBlank String ownerName,
        @CardNumber String cardNumber,
        @NotBlank String flag,
        @CVC String cvc,
        @NotNull LocalDate dueDate
) {
}
