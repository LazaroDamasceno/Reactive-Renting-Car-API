package com.api.v1.dtos.creditcard;

import com.api.v1.annotations.creditcard.CardNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreditCardRegistrationRequestDto(
        @NotBlank String ownerName,
        @CardNumber String cardNumber,
        @NotBlank String flag,
        @NotBlank @Size(min=3, max=3) String cvc,
        @NotNull LocalDate dueDate
) {
}
