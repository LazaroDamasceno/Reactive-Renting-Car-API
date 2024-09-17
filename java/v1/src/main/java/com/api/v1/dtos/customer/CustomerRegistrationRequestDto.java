package com.api.v1.dtos.customer;

import java.time.LocalDate;
import com.api.v1.annotations.customer.SSN;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CustomerRegistrationRequestDto(
        @NotBlank String firstName,
        String middleName,
        @NotBlank String lastName,
        @SSN String ssn,
        @NotNull LocalDate birthDate,
        @NotBlank @Email String email,
        @NotBlank String address,
        @NotBlank @Size(min=10, max=10) String phoneNumber
) {
}
