package com.api.v1.dtos;

import java.time.LocalDate;

import com.api.v1.annotations.PhoneNumber;
import com.api.v1.annotations.SSN;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerRegistrationRequestDto(
        @NotBlank String firstName,
        String middleName,
        @NotBlank String lastName,
        @SSN String ssn,
        @NotNull LocalDate birthDate,
        @NotBlank @Email String email,
        @NotBlank String address,
        @PhoneNumber String phoneNumber
) {
}
